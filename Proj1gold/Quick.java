public class Quick {

    /* print out the elements in ArraySolution*/
    public static void printArrayDequeSolution(ArrayDequeSolution<Integer> a) {
        for (int i = 0; i < a.size(); i++) {
            System.out.print(a.get(i) + " ");
        }
    }

    /* check if Student Array is the same as ArraySolution*/
    public static void main(String[] args) {
        StudentArrayDeque<Integer> sad = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> ads = new ArrayDequeSolution<>();

        for (int i = 0; i < 50; i += 1) {
            double numberBetweenZeroAndOne = StdRandom.uniform();
//            StdRandom.setSeed(1);
            if (numberBetweenZeroAndOne > 0.75) {
                sad.addFirst(i);
                ads.addFirst(i);
//                failureSequence = failureSequence + "addFirst(" + i + ")\n";
            } else if (numberBetweenZeroAndOne > 0.5) {
                sad.addLast(i);
                ads.addLast(i);
//                failureSequence = failureSequence + "addLast(" + i + ")\n";
            } else if (numberBetweenZeroAndOne > 0.25) {
                if (!sad.isEmpty() && !ads.isEmpty()) {
                    Integer a = sad.removeFirst();
                    Integer b = ads.removeFirst();
//                    assertEquals(failureSequence, b, a);
//                    failureSequence = failureSequence + "removeFirst()\n";
                }
            } else {
                if (!sad.isEmpty() && !ads.isEmpty()) {
                    Integer a = sad.removeLast();
                    Integer b = ads.removeLast();
//                    assertEquals(failureSequence, b, a);
//                    failureSequence = failureSequence + "removeLast()\n";
                }
            }
        }

        System.out.println("Student solution: ");
        sad.printDeque();
        System.out.println("Array solution: ");
        printArrayDequeSolution(ads);

    }
}
