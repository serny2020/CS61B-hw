public class Planet {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;
    static final double G = 6.67e-11;

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
        double x_distance = this.xxPos - a.xxPos;
        double y_distance = this.yyPos - a.yyPos;
        double distance = Math.pow(x_distance, 2) + Math.pow(y_distance, 2);
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
        double net_force_x = 0;
        for (Planet s : a) {
            if (this.equals(s)) {
                continue;
            }
            net_force_x += this.calcForceExertedByX(s);
        }
        return net_force_x;
    }

    public double calcNetForceExertedByY(Planet[] a) {
        double net_force_y = 0;
        for (Planet s : a) {
            if (this.equals(s)) {
                continue;
            }
            net_force_y += this.calcForceExertedByY(s);
        }
        return net_force_y;
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
