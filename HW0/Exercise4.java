public class Exercise4 {
    public static void windowPosSum(int[] a, int n) {
        /** your code here */
        for (int i = 0; i < a.length; i++) {
            if (a[i] < 0) continue; // skip negative values
            if (i == a.length - 1) break; // avoid going over the end of the array
            else {
                int sum = a[i];
                for (int j = 1; (j <= n && (i + j) < a.length); j++) {
                    sum = sum + a[i + j];
                }
                a[i] = sum;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = { 1, 2, -3, 4, 5, 4 };
        int n = 3;
        windowPosSum(a, n);

        // Should print 4, 8, -3, 13, 9, 4
        System.out.println(java.util.Arrays.toString(a));
    }
}