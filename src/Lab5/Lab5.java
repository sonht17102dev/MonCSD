package Lab5;

import java.util.EmptyStackException;

public class Lab5 {
    public static void main(String[] args) {
        int x = 8;
        MyStack t = new MyStack();
        t.convertToBinary(x);
    }
}
// Lớp Node chứa thông tin và hoạt động của 1 phần tử (nút) trong stack
class Node {
    int info;
    Node next;
    Node(int x, Node p) {
        info = x;
        next = p;
    }
}
// Xây dựng Stack
class MyStack {
    Node head;
    MyStack() {
        head = null;
    }
    boolean isEmpty() {
        return (head == null);
    }
    // Hàm đẩy 1 phần tử vào stack
    void push(int x) {
        head = new Node(x,head);
    }
    // Hàm lấy 1 phần tử ra khỏi stack
    int pop() {
        if(isEmpty()) throw new EmptyStackException();
        int x = head.info;
        head = head.next;
        return x;
    }
    // Hàm thuật toán chuyển đổi 1 số nguyên ở hệ đếm thập phân sang nhị phân ( Ta chia liên tiếp số nguyên đó cho 2 đến bao giờ //thương bằng 0 thì dừng lại, kết quả của phép chuyển đổi là phần dư của các phép chia theo thứ tự ngược lại)
    void convertToBinary(int x) {
        MyStack stack = new MyStack();
        if(x==0) return;
        stack.push(x%2);
        convertToBinary(x/2);
        while (!stack.isEmpty())
            System.out.print(stack.pop());
    }
}
