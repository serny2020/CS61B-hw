public class HelloNumbers {
    public static void main(String[] args) {
        int sum = 0;
        int i = 1;
        while ( i <= 10) {
            System.out.print(sum + " ");
            sum = sum + i;
            i += 1;
        }
        System.out.println();
    }
}