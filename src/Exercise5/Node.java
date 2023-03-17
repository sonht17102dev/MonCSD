package Exercise5;

public class Node {

    int ID;

    String name;

    float grad1,grad2,grad3;

// Khai báo biến next

    Node next;

// Hàm khởi tạo không có tham số

    Node() {}

// Hàm khởi tạo để set các giá trị cho các biến

    public Node(int ID, String name, float grad1, float grad2, float grad3, Node next) {
        this.ID = ID;
        this.name = name;
        this.grad1 = grad1;
        this.grad2 = grad2;
        this.grad3 = grad3;
        this.next = next;
    }

    @Override
    public String toString() {
        return String.format("{%d %s %f %f %f} ",ID, name, grad1, grad2, grad3);
    }
}

