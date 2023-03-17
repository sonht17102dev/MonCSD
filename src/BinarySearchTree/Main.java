package BinarySearchTree;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        int [] a = {25,10,30,5,20,10,15};
//        int[] a= {5,3,7,9,8,11,6,20,19,37,25,21,15,12};
//        int[] a = {33,52,25,12,27,39,34,48,65,60,78,72,90};
        int[] a= {34,17,25,66,50,71,68,94};
        BinarySearchTree bst = new BinarySearchTree();
        bst.insertMany(a);

        System.out.println("\nPre-order traverse:");
        bst.preOrder(bst.root);
        System.out.println();
//        bst.delete(bst.root,65);
//        int value = sc.nextInt();
//        bst.visit(bst.find(33));
        System.out.println();
        System.out.println(bst.largest());
        System.out.println(bst.smallest());
        System.out.println("\nIn-order traverse:");
        bst.inOrder(bst.root);
        System.out.println("\nPost-order traverse:");
        bst.postOrder(bst.root);

        System.out.println("\nSearch:");

        bst.search(bst.root, 70);
    }
}
