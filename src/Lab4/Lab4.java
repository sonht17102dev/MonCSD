package Lab4;

public class Lab4 {
    public static void main(String [] args) {
        String [] a = {"HOA","HA","LAN","NOI","MUA","NAY"};
        int [] b = {25,17,26,19,23,21};
        MyList t = new MyList();
        t.addMany(a,b);

        System.out.println("Traverse:");
        t.traverse();

        System.out.println("Sort by name:");
        t.sortByName();
        t.traverse();
        System.out.println();
    }
}
// Lớp Person chứa các thông tin và hoạt động cho mỗi người

class Person
{String name;int age;
    Person(String xName, int xAge) {name = xName;age=xAge;}
    public String toString() {return(name + " " + age);}
}

// Lớp Node chứa thông tin của mỗi người và biến next để trỏ tới nút tiếp theo
class Node
{Person info;
    Node next;
    Node(Person x, Node p) {info=x;next=p;}
    Node(Person x) {this(x,null);}
}

// Xây dựng danh sách liên kết
class MyList
{Node head,tail;
    MyList() {head=tail=null;}
    void clear() {head=tail=null;}
    boolean isEmpty() {return(head==null);}

    // Hàm thêm 1 người vào đuôi danh sách liên kết
    void add(Person x){
        Node node = new Node(x);
        if(isEmpty()) head = tail = node;
        tail.next = node;
        tail = tail.next;
    }

    // Hàm thêm nhiều người vào danh sách liên kết, thông tin ( tên và tuổi) của mọi người được lưu trong 2 mảng a và b
    void addMany(String [] a, int [] b){
        for (int i = 0; i < a.length; i++) {
            add(new Person(a[i], b[i]));
        }
    }

    // Hàm duyệt danh sách liên kết
    void traverse(){
        Node node = head;
        while (node!=null){
            System.out.println(node.info.toString());
            node = node.next;
        }

    }

    // Hàm sắp xếp theo tên
    void sortByName(){
//        Node current = head;
//        while (current!= null){
//            Node currentNext = current.next;
//            while (currentNext != null) {
//                if (current.info.name.compareTo(currentNext.info.name) > 0) {
//                    Person temp = current.info;
//                    current.info = currentNext.info;
//                    currentNext.info = temp;
//                }
//                currentNext = currentNext.next;
//            }
//            current = current.next;
//
//        }
        for(Node node = head; node!=null; node=node.next){
            for(Node node1 = node.next; node1!=null; node1=node1.next) {
                if(node.info.name.compareTo(node1.info.name) > 0){
                    Person temp = node.info;
                    node.info = node1.info;
                    node1.info = temp;
                }
            }
        }
    }
}