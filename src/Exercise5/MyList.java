package Exercise5;

public class MyList {

    Node head,tail;
    MyList() {head=tail=null;}
    boolean isEmpty()
    {return(head==null);
    }
    void clear() {head=tail=null;}

    // add vào đuôi linked list
    void add(int xID, String name, float grad1, float grad2, float grad3){
        Node node = new Node(xID,name,grad1,grad2,grad3,null);
        if(head == null){
            head = tail = node;
            return;
        }
        tail.next = node;
        tail = node;
    }

    // Hàm duyệt inked list
    void traverse() {
        if (isEmpty()) {
            System.out.println("The list is empty");
            return;
        }
        Node current = head;
        while (current!=null) {
            System.out.print(current);
            current = current.next;
        }
        System.out.println();
    }

    // Tìm kiếm theo ID
    Node search(int xID) {
        Node current = head;
        while (current!=null) {
            if(current.ID == xID) return current;
            current = current.next;
        }
        return null;
    }

    // Delete theo ID
    void delete(int xID) {
        if(head==null) return;
        if (head == tail && head.ID == xID){
            clear();
            return;
        }
        Node prev = null;
        Node current = head;
        while (current!=null) {
            if(current.ID==xID) {
                if (prev == null) {
                    head = head.next;
                    return;
                } else {
                    prev.next = current.next;
                    return;
                }
            };
            prev = current;
            current = current.next;
        }
    }

}

