package LinkedList;

public class LinkedList<T> {
    private Node<T> head;

    public Node<T> getHead() {
        return this.head;
    }

    public void addAtStart(T data) {
        Node<T> newNode = new Node<T>(data);
        newNode.setNextNode(this.head);
        this.head = newNode;
    }

    public Node<T> deleteAtStart() {
        Node<T> toDel = this.head;
        this.head = this.head.getNextNode();
        return toDel;
    }


    public int find(T data) {
        int pos = 0;
        Node<T> curr = this.head;
        while (curr != null) {
            if (curr.getData().equals(data)) {
                return pos;
            }
            curr = curr.getNextNode();
            pos++;
        }
        return -1;
    }

    public int length() {
        if (head == null)
            return 0;
        int length = 0;
        Node<T> curr = this.head;
        while (curr != null) {
            length += 1;
            curr = curr.getNextNode();
        }
        return length;
    }

    public boolean isEmpty() {
        return this.head == null;
    }
}
