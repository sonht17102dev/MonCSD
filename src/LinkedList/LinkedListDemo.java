package LinkedList;

public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList<Integer> integers = new LinkedList<Integer>();

        integers.addAtStart(5);
        integers.addAtStart(10);
        integers.addAtStart(2);
        integers.addAtStart(12);
        integers.addAtStart(19);
        integers.addAtStart(20);
        integers.deleteAtStart();
        System.out.println(integers.length());
        integers.toString();
        System.out.println(integers.find(5));
    }
}
