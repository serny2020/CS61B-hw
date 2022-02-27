public class Planet {
    /**
     * All numbers in this project are doubles; All instance variables and methods are
     * required to be declared using public key world.
     */
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;
    private static final double G = 6.67e-11; // constant variable

    public Planet(double xP, double yP, double xV, double yV, double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    public Planet(Planet p) {
        this(p.xxPos, p.yyPos, p.xxVel, p.yyVel, p.mass, p.imgFileName);
//        this.xxPos = p.xxPos;
//        this.yyPos = p.yyPos;
//        this.xxVel = p.xxVel;
//        this.yyVel = p.yyVel;
//        this.mass = p.mass;
//        this.imgFileName = p.imgFileName;
    }

    public double calcDistance(Planet a) {
        double xDiatance = this.xxPos - a.xxPos;
        double yDiatance = this.yyPos - a.yyPos;
        double distance = Math.pow(xDiatance, 2) + Math.pow(yDiatance, 2);
        return Math.sqrt(distance);
    }

    public double calcForceExertedBy(Planet a) {
        double force = (G * a.mass * this.mass) / Math.pow(this.calcDistance(a), 2);
        return force;
    }

    public double calcForceExertedByX(Planet a) {
        double cos = (a.xxPos - this.xxPos) / (this.calcDistance(a));
        return (this.calcForceExertedBy(a) * cos);
    }

    public double calcForceExertedByY(Planet a) {
        double cos = (a.yyPos - this.yyPos) / (this.calcDistance(a));
        return (this.calcForceExertedBy(a) * cos);
    }

    public double calcNetForceExertedByX(Planet[] a) {
        double netForceX = 0;
        for (Planet s : a) {
            if (this.equals(s)) {
                continue;
            }
            netForceX += this.calcForceExertedByX(s);
        }
        return netForceX;
    }

    public double calcNetForceExertedByY(Planet[] a) {
        double netForceY = 0;
        for (Planet s : a) {
            if (this.equals(s)) {
                continue;
            }
            netForceY += this.calcForceExertedByY(s);
        }
        return netForceY;
    }

    public void update(double dt, double fX, double fY) {
        this.xxVel = this.xxVel + dt * (fX / this.mass);
        this.yyVel = this.yyVel + dt * (fY / this.mass);
        this.xxPos = this.xxPos + dt * this.xxVel;
        this.yyPos = this.yyPos + dt * this.yyVel;
    }

    public void draw() {
        String imageToDraw = "images/" + this.imgFileName;
        StdDraw.picture(this.xxPos, this.yyPos, imageToDraw);
    }
}
