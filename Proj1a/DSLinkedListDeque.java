public class DSLinkedListDeque<T> {
    public class DLNode {
        public DLNode prev;
        public T item;
        public DLNode next;

        public DLNode(DLNode p, T i, DLNode n) {
            prev = p;
            item = i;
            next = n;
        }
    }

    private DLNode sentFront;
    private DLNode sentBack;
    private int size = 0;
    private T stuff;

    public DSLinkedListDeque() {
        sentFront = new DLNode(null, stuff, sentBack); // sentBack is a null pointer at this point
        sentBack = new DLNode(sentFront, stuff, null); // sentBack now has address
        sentFront.next = sentBack;
    }

    public DSLinkedListDeque(T item) {
        DLNode first = new DLNode(sentFront, item, sentBack);
        sentFront = new DLNode(null, stuff, first);
        sentBack = new DLNode(first, stuff, null);
        size = 1;
    }

    public void addFirst(T item) {
        sentFront.next = new DLNode(sentFront, item, sentFront.next); // (forward-link)
        sentFront.next.next.prev = sentFront.next; // (backlink)sentFront.next.next now is the second node
        size += 1;
    }

    public void addLast(T item) {
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


    public T getfirst() {
        return sentFront.next.item;
    }

    public T removeFirst() {
        if (size != 0) {
            T target = sentFront.next.item;
            sentFront.next = sentFront.next.next;
            size -= 1;
            return target;
        }
        return null;
    }

    public T removeLast() {
        if (size != 0) {
            T target = sentBack.prev.item;
            sentBack.prev = sentBack.prev.prev;
            size -= 1;
            return target;
        }
        return null;
    }

    public T get(int index) {
        if (size != 0) {
            DLNode ptr = sentFront.next;
//            DLNode ptr = new DLNode(sentFront, sentFront.next.item, sentFront.next);
            for (int i = 0; i < index; i++) {
                ptr = ptr.next;
            }
            return (ptr.item);
        }
        return null;
    }


    public static void main(String[] args) {
        LinkedListDeque<String> L = new LinkedListDeque();
        L.addFirst("hello");
        L.addLast("world");
        L.addLast("!");
        L.addFirst("first");
        L.printDeque();
        System.out.println();

        System.out.println("getFirst: " + L.getfirst());
        System.out.println("size: " + L.size());
        System.out.println("if empty: " + L.isEmpty());
        System.out.println("remove first:" + L.removeFirst());
        System.out.println("remove last:" + L.removeLast());
        L.printDeque();
        System.out.println();

        System.out.println("first item: " + L.get(0));
        L.printDeque();

    }
}


