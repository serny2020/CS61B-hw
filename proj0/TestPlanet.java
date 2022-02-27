public class TestPlanet {
    public static void main(String[] args) {
        Planet sun = new Planet(1e12, 2e11, 0, 0, 2e30, "sun");
        Planet saturn = new Planet(2.3e12, 9.5e11, 0, 0, 6e26, "saturn");
        double force = saturn.calcForceExertedBy(sun);
        System.out.println("pairwise force is " + force);
    }
}
