public class LinkedListDeque<T> {
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

    private DLNode sentinel;
    private int size = 0;
    private T stuff;

    public LinkedListDeque() {
        sentinel = new DLNode(sentinel, stuff, sentinel); // sentBack is a null pointer at this point
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
    }

    public LinkedListDeque(T item) {
        sentinel = new DLNode(sentinel, stuff, sentinel); // sentBack is a null pointer at this point
        DLNode first = new DLNode(sentinel, item, sentinel);
        sentinel.prev = first;
        sentinel.next = first;
        size = 1;
    }

    public void addFirst(T item) {
        sentinel.next = new DLNode(sentinel, item, sentinel.next); // (forward-link) sentinel.next is the first one
        sentinel.next.next.prev = sentinel.next; // backlink from second to first
        size += 1;
    }

    public void addLast(T item) {
        sentinel.prev = new DLNode(sentinel.prev, item, sentinel); // sentinel.prev is the last one
        sentinel.prev.prev.next = sentinel.prev; // backlink
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
        DLNode ptr = sentinel.next;
        for (int i = 0; i < size; i++) {
            System.out.print(ptr.item + " ");
            ptr = ptr.next;
        }
        System.out.println();
    }


    public T getfirst() {
        return sentinel.next.item;
    }

    public T removeFirst() {
        if (size != 0) {
            T target = sentinel.next.item;
            sentinel.next = sentinel.next.next;
            size -= 1;
            return target;
        }
        return null;
    }

    public T removeLast() {
        if (size != 0) {
            T target = sentinel.prev.item;
            sentinel.prev = sentinel.prev.prev;
            size -= 1;
            return target;
        }
        return null;
    }

    public T get(int index) {
        if (size != 0) {
            DLNode ptr = sentinel.next;
//            DLNode ptr = new DLNode(sentFront, sentFront.next.item, sentFront.next);
            for (int i = 0; i < index; i++) {
                ptr = ptr.next;
            }
            return (ptr.item);
        }
        return null;
    }


//    public static void main(String[] args) {
//        LinkedListDeque<Integer> L = new LinkedListDeque(3);
//        L.addFirst(3);
//        L.addLast(5);
//        L.addLast(6);
//        L.addFirst(9);
//        L.printDeque();
//        System.out.println();
////
//        System.out.println("getFirst: " + L.getfirst());
//        System.out.println("size: " + L.size());
//        System.out.println("if empty: " + L.isEmpty());
//        System.out.println("remove first:" + L.removeFirst());
//        System.out.println("remove last:" + L.removeLast());
//        L.printDeque();
//        System.out.println();
//
//        System.out.println("first item: " + L.get(0));
//        L.printDeque();
//
//    }
}


