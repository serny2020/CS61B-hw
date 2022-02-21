public class Exercise2 {
    /** Returns the maximum value from m. */
    public static int max(int[] m) {
        int greatest = m[0];
        for (int i = 1; i < m.length; i++) {
            if (greatest < m[i]) {
                greatest = m[i];
            }
        }
        return greatest;
    }

    public static void main(String[] args) {
        int[] numbers = new int[] { 9, 2, 15, 2, 22, 10, 6 };
        System.out.println(max(numbers));
    }
}

