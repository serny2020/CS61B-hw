public class Exercise1b {
    public static void main(String[] args) {
        int size = Integer.parseInt(args[0]);
        drawTriangle(size);
    }

    public static void drawTriangle(int N) {
        int row = 0;
        while (row < N) {
            int col = 0;
            while (col <= row) {
                System.out.print('*');
                col = col + 1;
            }
            System.out.println();
            row = row + 1;
        }

    }
}
