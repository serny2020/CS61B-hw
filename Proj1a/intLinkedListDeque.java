public class intLinkedListDeque {
    public class DLNode {
        public DLNode prev;
        public int item;
        public DLNode next;

        public DLNode(DLNode p, int i, DLNode n) {
            prev = p;
            item = i;
            next = n;
        }
    }

    private DLNode sentFront;
    private DLNode sentBack;
    private int size = 0;

    public intLinkedListDeque() {
        sentFront = new DLNode(null, 65, sentBack); // sentBack is a null pointer at this point
        sentBack = new DLNode(sentFront, 65, null); // sentBack now has address
        sentFront.next = sentBack;
    }

    public intLinkedListDeque(int item) {
        DLNode first = new DLNode(sentFront, item, sentBack);
        sentFront = new DLNode(null, 65, first);
        sentBack = new DLNode(first, 65, null);
        size = 1;
    }

    public void addFirst(int item) {
        sentFront.next = new DLNode(sentFront, item, sentFront.next); // (forward-link)
        sentFront.next.next.prev = sentFront.next; // (backlink)sentFront.next.next now is the second node
        size += 1;
    }

    public void addLast(int item) {
        sentBack.prev = new DLNode(sentBack.prev, item, sentBack);
        sentBack.prev.prev.next = sentBack.prev; // sentBack.prev.prev now is the second-to-last node
        size += 1;
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        DLNode ptr = sentFront.next;
        for (int i = 0; i < size; i++) {
            System.out.print(ptr.item + " ");
            ptr = ptr.next;
        }
        System.out.println();
    }


    public int getfirst() {
        return sentFront.next.item;
    }

    public int removeFirst() {
        if (size != 0) {
            int target = sentFront.next.item;
            sentFront.next = sentFront.next.next;
            size -= 1;
            return target;
        }
        return 0;
    }

    public int removeLast() {
        if (size != 0) {
            int target = sentBack.prev.item;
            sentBack.prev = sentBack.prev.prev;
            size -= 1;
            return target;
        }
        return 0;
    }

    public int get(int index) {
        if (size != 0) {
            DLNode ptr = sentFront.next;
//            DLNode ptr = new DLNode(sentFront, sentFront.next.item, sentFront.next);
            for (int i = 0; i < index; i++) {
                ptr = ptr.next;
            }
            return (ptr.item);
        }
        return 0;
    }


    public static void main(String[] args) {
        intLinkedListDeque L = new intLinkedListDeque();
        L.addFirst(1);
        L.addLast(2);
        L.addLast(3);
        L.addFirst(0);
        L.printDeque();

        System.out.println("getFirst: " + L.getfirst());
        System.out.println("size: " + L.size());
        System.out.println("if empty: " + L.isEmpty());
        System.out.println("second item: " + L.get(1));
        System.out.println("remove first:" + L.removeFirst());
        System.out.println("remove last:" + L.removeLast());
        System.out.println("remove first:" + L.removeFirst());
        System.out.println("remove last:" + L.removeLast());
        System.out.println("if empty: " + L.isEmpty());
        System.out.println("refilling: ");
        L.addFirst(1);
        L.addLast(2);
        L.addLast(3);
        L.addFirst(0);
        L.printDeque();

    }
}
