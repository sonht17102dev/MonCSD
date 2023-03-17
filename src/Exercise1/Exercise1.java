package Exercise1;

import BinarySearchTree.TreeNode;

import java.util.Random;
import java.util.Scanner;

public class Exercise1 {
    // Nhập các phần tử trong mảng a;

    static void input(int [] a, int n){
//        Random r = new Random();
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < a.length; i++) {
            a[i]=sc.nextInt();
        }
    }

    public static void main(String [] args) {
        BTree t = new BTree();

        int n=7;

//        int [] a = new int[n];
        int [] a = {25,10,30,5,20,15};
//        int[] a = {52,33,25,12,27,39,34,48,65,60,78,72,90};
//        input (a,n);
        t.insertMany(a);
        System.out.println("\nPre-order traverse:");
        t.preOrder(t.root);
        System.out.println("\nIn-order traverse:");
        t.inOrder(t.root);

        System.out.println("\nSearch:");

        t.search(t.root, 10);

        System.out.println();
//        BTree t = new BTree();
//
//        int n = 10;
//        int [] a = {25,10,30,5,20,10,15};
//        int x = 10;
////        input (a,n);
//        t.root = t.insertMany(t.root,a);
//        System.out.println("\nPre-order traverse:");
//        t.preOrder(t.root);
//        System.out.println("\nIn-order traverse:");
//        t.inOrder(t.root);
//
//        System.out.println("\nSearch:");
////        Scanner sc = new Scanner(System.in);
////        int x = sc.nextInt();
//        t.search(t.root, x);
//
//        System.out.println();
    }
}
// Lớp Node để khai báo các thuộc tính và các hoạt động tại mỗi nút của cây

class Node {
    int info;
    Node left,right;
    Node(int x) {
        info=x;
        left=right=null;
    }
    void insert(int x){
        if(x >= this.info){
            if(this.right == null)
                this.right = new Node(x);
            else
                this.right.insert(x);
        }else{
            if(this.left == null)
                this.left = new Node(x);
            else
                this.left.insert(x);
        }
    }
//    public void insert(int data){
//        if(data >= this.info){
//            if(this.right == null)
//                this.right = new Node(data);
//            else this.right.insert(data);
//        } else {
//            if(this.left == null)
//                this.left = new Node(data);
//            else this.left.insert(data);
//        }
//    }
}

//  xây dựng lớp cây nhị phân tìm kiếm
class BTree {
    Node root;
    BTree() {root=null;}
    boolean isEmpty() {return(root==null);}

    // Duyệt cây để tìm kiếm nút có giá trị >x,
    // nếu thấy hiển thị giá trị ra màn hình,
    // sau đó lại tìm tiếp cho đến khi nào duyệt hết các nút //trong cây
    void search(Node p, int x){
        if (p == null) return;

        search(p.left,x);
        if (p.info > x) visit(p);
        search(p.right,x);
    }

    // Chèn thêm 1 nút vào trong cây
    void insert(int x){
        if(root == null)
            root = new Node(x);
        else root.insert(x);
    }

    // Insert mảng a các số nguyên vào trong cây, trong hàm này sẽ gọi tới hàm insert(...)  nhiều lần

    void insertMany(int[] a){
        for (int i = 0; i < a.length; i++) {
            insert(a[i]);
        }
    }
    void visit(Node p) {
        System.out.print(p.info + " ");
    }

    // Duyệt theo thứ tự pre Order
    void preOrder(Node p) {
        if(p==null) return;
        visit(p);
        preOrder(p.left);
        preOrder(p.right);
    }

    // Duyệt theo thứ tự In Order
    void inOrder(Node p){
        if(p==null) return;
        inOrder(p.left);
        visit(p);
        inOrder(p.right);
    }
}



