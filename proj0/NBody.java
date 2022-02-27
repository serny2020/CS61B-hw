public class NBody {
    public static double readRadius(String fileName) {
        In in = new In(fileName);
        in.readDouble(); // drop first line of planet number
        return in.readDouble();
    }

    public static Planet[] readPlanets(String fileName) {
        In in = new In(fileName);
        int n = in.readInt(); // casting by readInt() automatically
        Planet[] planets = new Planet[n];
        in.readDouble(); // drop next line of radius
        for (int i = 0; i < n; i++) {
            double xxPos = in.readDouble();
            double yyPos = in.readDouble();
            double xxVal = in.readDouble();
            double yyVal = in.readDouble();
            double mass = in.readDouble();
            String name = in.readString();
            Planet planet = new Planet(xxPos, yyPos, xxVal, yyVal, mass, name);
            planets[i] = planet;
        }
        return planets;
    }

    public static void main(String[] args) {
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        double radius = readRadius(filename);
        Planet[] planets = readPlanets(filename);

        String imageToDraw = "images/starfield.jpg";
        StdDraw.setScale(-radius, radius);

        StdDraw.picture(0, 0, imageToDraw);
        for (Planet p : planets) {
            p.draw();
        }

        StdDraw.enableDoubleBuffering();
        int n = planets.length;
        double time = 0;
        while (time <= T) {
            // StdDraw.clear();
            double[] xForce = new double[n];
            double[] yForce = new double[n];
            for (int j = 0; j < n; j++) { //calculate new force for each planet
                xForce[j] = planets[j].calcNetForceExertedByX(planets);
                yForce[j] = planets[j].calcNetForceExertedByY(planets);
            }
            for (int j = 0; j < n; j++) { // update on each planet
                planets[j].update(dt, xForce[j], yForce[j]); // caveat: input argument is dt
            }
            StdDraw.picture(0, 0, imageToDraw); //draw background image
            for (Planet p : planets) { //draw all of the planets
                p.draw();
            }
            StdDraw.show(); // show the offscreen buffer
            StdDraw.pause(10); // pause for 10 milliseconds
            time += dt; // increase time variable
        }

        // output result for checking
        StdOut.printf("%d\n", planets.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < planets.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                    planets[i].yyVel, planets[i].mass, planets[i].imgFileName);
        }

    }

}
