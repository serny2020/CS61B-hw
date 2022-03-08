public interface Deque<Item> {
    void addFirst(Item items);

    void addLast(Item items);

    boolean isEmpty();

    int size();

    void printDeque();

    Item removeFirst();

    Item removeLast();

    Item get(int index);

}
