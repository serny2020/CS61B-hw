public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;
    private static final int N = 8; // starting array size (scalar)
    private static final double R = 0.25; // array usage factor
//    private static final int RFACTOR = 2;

    public ArrayDeque() {
        items = (T[]) new Object[N];
        size = 0;
        nextFirst = N / 2; // initialize in the middle
        nextLast = N / 2 + 1;
    }

    /**
     * resize the underlying array to the target capacity.
     */
    private void inesize(int capacity) {
        T[] a = (T[]) new Object[capacity];

//        System.arraycopy(items, plusOne(nextFirst), a, 1, items.length - plusOne(nextFirst));
//        System.arraycopy(items, 0, a, items.length - plusOne(nextFirst) + 1, nextLast);
//        nextFirst = 0;
//        nextLast = size + 1;
//        items = a;


        int start = plusOne(nextFirst);
        int firstPart = items.length - plusOne(nextFirst);
        for (int i = 1; i <= firstPart; i++) {
            a[i] = items[start];
            start++;
        }
        int secondPart = items.length - plusOne(nextFirst) + 1;
        int firstIndex = 0;
        for (int Ncounter = 1; Ncounter <= nextLast; Ncounter++) {
            a[secondPart] = items[firstIndex];
            secondPart++;
            firstIndex++;
        }
        nextFirst = 0;
        nextLast = size + 1;
        items = a;
    }

    //
    private void desize(int capacity) {
        T[] a = (T[]) new Object[capacity];

//        if (nextFirst > nextLast) {
//            System.arraycopy(items, plusOne(nextFirst), a, 1, items.length - nextFirst - 1);
//            System.arraycopy(items, 0, a, items.length - nextFirst, nextLast);
//        } else {
//            /* nextFirst < nextLast */
//            System.arraycopy(items, nextFirst + 1, a, 1, size);
//        }
//        nextFirst = 0;
//        nextLast = size + 1;
//        items = a;

        int firstIndex = plusOne(nextFirst);
        if (nextFirst > nextLast) {
            for (int i = 1; i <= items.length - nextFirst - 1; i++) {
                a[i] = items[firstIndex];
                firstIndex++;
            }
            int secondIndex = items.length - nextFirst;
            int d = 0;
            for (int i = secondIndex; i <= nextLast; i++) {
                a[i] = items[d];
                d++;
            }
        } else {
            /* nextFirst < nextLast */
//            System.arraycopy(items, nextFirst + 1, a, 1, size);
            int b = nextFirst + 1;
            for (int i = 1; i <= size; i++) {
                a[i] = items[b];
                b++;
            }

        }
        nextFirst = 0;
        nextLast = size + 1;
        items = a;
    }

    //
//
//    /**
//     * constant time consumption
//     */
    public void addLast(T x) {
        if (size == items.length) {
            inesize(size * 2);
        }
//        int index = computeIndex(nextLast);

        items[nextLast] = x;
        size += 1;
        nextLast = plusOne(nextLast);
    }

    /**
     * constant time consumption
     */
    public void addFirst(T x) {
        if (size == items.length) {
            inesize(size * 2);
        }
        items[nextFirst] = x;
        size += 1;
        nextFirst = minusOne(nextFirst);
    }

    /**
     * circular index, size is adjusting with array
     */
//    private int computeIndex(int index) {
//        if (index < 0) {
//            return (index + items.length);
//        }
//        return index % items.length;
//    }
    private int minusOne(int index) {
        if (index == 0) { // minimum of an array go to the end
            return items.length - 1;
        } else return index - 1;
    }

    private int plusOne(int index) {
        if (index == items.length - 1) { // maximum of array go back to the beginning
            return 0;
        } else return index + 1;
    }


    public T removeLast() {
        T x = items[minusOne(nextLast)];
//        if (size == 2) {
//            resize(N); //minimum size, one more element of null
//        }
        if ((items.length >= 16) && ((double) (size) / items.length <= R)) { // usage at least 25%
            desize(items.length / 2);
        }
        items[minusOne(nextLast)] = null; // avoid loitering
        size -= 1;
        nextLast = minusOne(nextLast); // move backward
        return x;
    }

    public T removeFirst() {
        T x = items[plusOne(nextFirst)];
//        if (size + 1 == 2) {
//            resize(N); //minimum size
//        }
        if ((items.length >= 16) && ((double) (size) / items.length <= R)) {
            desize(items.length / 2);
        }
        items[plusOne(nextFirst)] = null;
        size -= 1;
        nextFirst = plusOne(nextFirst); // move forward
        return x;
    }

    public T get(int index) {
//        return items[index];
        if (index > size - 1 || index < 0) {
            return null;
        }
        return items[(index + (nextFirst + 1)) % items.length];
    } // starting at 1st element of underlying array, and scale to adjust the array length

}

    public int size() {
        return size;
    }

    public void printDeque() {
        int first = plusOne(nextFirst);
        while (first != nextLast) { // circle ends, but cannot print the full array condition
            System.out.print(items[first] + " ");
            first = plusOne(first); // move backward
        }
        System.out.println();
    }


    public boolean isEmpty() {
//        if (size == 0) {
//            return true;
//        } else return false;
        return size == 0;
    }

    public static void main(String[] args) {
        ArrayDeque<Integer> de = new ArrayDeque<>();
        de.addFirst(13);
        de.addFirst(12);
        de.addFirst(11);
        de.addFirst(10);
        de.addFirst(9);
        de.addFirst(8);
        de.addFirst(7);
        de.addFirst(6);

        de.printDeque(); // common bug

        de.addFirst(5); // expansion
        de.addFirst(4);
        de.addFirst(3);
        de.addFirst(2);
        de.addFirst(1);
        de.addFirst(0);

        de.printDeque();

        de.removeLast();
        de.removeLast();
        de.removeLast();
        de.removeLast();
        de.removeLast();
        de.removeLast();
        de.removeLast();
        de.removeLast();
        de.removeLast();
        de.removeLast();
        de.removeLast(); // shrinkage

        de.printDeque();

    }
}

//    public static void main(String[] args) {
//        ArrayDeque<Integer> de = new ArrayDeque<>();
//        de.addFirst(10);
//        de.addFirst(9);
//        de.addFirst(8);
//        de.addFirst(7);
//        de.addFirst(6);
//        de.addFirst(5);
//        de.addFirst(4);
//        de.addFirst(3);
//        de.addFirst(2);
//        de.addFirst(1);
//        System.out.println("size: " + de.size());
//        de.printDeque(); // expect 1 2
//
//        de.removeLast();
//        de.removeFirst();
//        de.removeLast();
//        de.removeFirst();
//        de.removeLast();
//        de.removeLast();
//        de.removeFirst();
//        de.removeLast();
//        de.removeFirst();
//        de.removeLast();
//        System.out.println(de.isEmpty());
//
//        de.addFirst(20);
//        de.addFirst(19);
//        de.addFirst(18);
//        de.addFirst(17);
//        de.addFirst(16);
//        de.addFirst(15);
//        de.addFirst(14);
//        de.addFirst(13);
//        de.addFirst(12);
//        de.addFirst(11);
//        de.addFirst(1);
//        de.addFirst(2);
//        de.addFirst(3);
//        de.addFirst(4);
//        de.addFirst(5);
//        de.addFirst(6);
//        de.addFirst(7);
//        de.addLast(8);
//        de.addLast(9);
//        de.addLast(10);
//        System.out.println("size: " + de.size());
//        de.printDeque(); // expect 1 2
//
//        de.removeLast();
//        de.removeFirst();
//        de.removeLast();
//        de.removeFirst();
//        de.removeLast();
//        de.removeLast();
//        de.removeFirst();
//        de.removeLast();
//        de.removeFirst();
//        de.removeLast();
//        de.removeLast();
//        de.removeFirst();
//        de.removeLast();
//        de.removeFirst();
//        de.removeLast();
//        de.removeLast();
//        de.removeFirst();
//        de.removeLast();
//        de.removeFirst();
//        de.removeLast();
//        System.out.println(de.isEmpty());
//
//        de.addFirst(1);
//        de.addFirst(2);
//        de.addFirst(3);
//        de.addFirst(4);
//        de.addFirst(5);
//        de.addFirst(6);
//        de.addFirst(7);
//        de.addFirst(8);
//        de.addFirst(9);
//        de.addFirst(10);
//        de.addFirst(11);
//        de.addFirst(12);
//        de.addFirst(13);
//        de.addFirst(14);
//        de.addFirst(15);
//        de.addFirst(16);
//        de.addFirst(17);
//        de.addFirst(18);
//        de.addFirst(19);
//        de.addFirst(20);
//        de.addFirst(21);
//        de.addFirst(22);
//        de.addFirst(23);
//        de.addFirst(24);
//        de.addFirst(25);
//        de.addFirst(26);
//        de.addFirst(27);
//        de.addFirst(28);
//        de.addLast(29);
//        de.addLast(30);
//        de.addLast(31);
//        System.out.println("size: " + de.size());
//        de.printDeque(); // expect 1 2
//    }
//}



