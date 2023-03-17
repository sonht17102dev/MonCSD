package Stack_Queue;

import java.util.EmptyStackException;

public class MyStack {
    Node head;
    public MyStack (){
        head = null;
    }
    public boolean isEmpty(){
        return head == null;
    }
    public void push(int x){
        head = new Node(x,head);
    }
    public int pop(){
        if(isEmpty()){
            System.out.println("Stack Empty");
            return 0;
        }
        int x = head.info;
        head = head.next;
        return x;
    }
    public int peek(){
        if(isEmpty()){
            System.out.println("Stack Empty");
            return 0;
        }
        return head.info;
    }
    void print(){
        Node node = head;
        while (node != null){
            System.out.print(" " + node.info);
            node = node.next;
        }
    }

    public static void main(String[] args) {
        int[] x = {3,4,2,5,6,1,9};
        MyStack s = new MyStack();
        Stack t = new Stack();
//        for (int i = 0; i < x.length; i++)
//            s.push(x[i]);
//        System.out.println();
//        System.out.println(s.pop() + " Popped from stack");
//        System.out.println("Top element is : " + s.peek());
//
//        System.out.print("Elements present in stack : ");
//        s.print();

        for (int i = 0; i < x.length; i++) {
            t.push(x[i]);
        }
        System.out.println(t.pop() + " Popped from stack");
        System.out.println("Top element is :" + t.peek());
        System.out.print("Elements present in stack : ");
        t.print();
    }
}
class Stack {
    static final int MAX = 10;
    int top;
    int[] a = new int[MAX];
    Stack (){
        top = -1;
    }
    boolean isEmpty(){
        return top<0;
    }
    void push(int x){
        a[++top] = x;
    }
    int pop(){
        if(isEmpty()){
            System.out.println("Stack Empty");
            return 0;
        }
        int x = a[top--];
        return x;
    }
    int peek(){
        if(isEmpty()){
            System.out.println("Stack Empty");
            return 0;
        }
        int x = a[top];
        return x;
    }
    void print(){
        for(int i = top; i> -1; i--){
            System.out.print(" " + a[i]);
        }
    }

}

//class Stack {
//    private int maxSize;
//    private char[] stackArray;
//    private int top;
//    public Stack(int max) {
//        maxSize = max;
//        stackArray = new char[maxSize];
//        top = -1;
//    }
//
//    public void push(char j) {
//        if (top >= maxSize - 1) {
//            System.out.println("StackOverFlow");
//            return;
//        }
//        stackArray[++top] = j;
//    }
//
//    public char pop() {
//        if (isEmpty()) {
//            System.out.println("IndexOutOfBound");
//            return 0;
//        }
//        return stackArray[top--];
//    }
//
//    public char peek() {
//        return stackArray[top];
//    }
//
//    public boolean isEmpty() {
//        return (top == -1);
//    }
//}