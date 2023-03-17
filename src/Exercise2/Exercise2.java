package Exercise2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Exercise2 {
    // Hàm nhập ma trận a từ bàn phím
    static void input(int [][] b, int n){
        Scanner sc = new Scanner(System.in);
//        b = new int[][]{
//                {0,1,1,0,1},
//                {1,0,1,0,0},
//                {1,1,0,1,0},
//                {0,0,1,0,0},
//                {1,0,0,0,0}
//        };
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("Nhập vào đỉnh b[%d][%d]: ", i, j);
                b[i][j] = sc.nextInt();
                sc.nextLine();
            }
        }
    }

    public static void main(String [] args) {
//        Graph g = new Graph();
//        int n=5;
//        int [][] b = new int [n][n];
//        input(b,n);
//        g.setData(b);
//        g.dispAdj();
//        boolean[] isVisited = new boolean[n];
//        g.breadth(1,isVisited, true);
//        System.out.println("Is G is connected? " + g.isConnected());
//        System.out.println("Degree of the vertex A in G is " + g.degree(0));
//        System.out.println();
        Graph g = new Graph();
        int n = 5;
        int[][] b = new int[][]{
                {0,1,1,0,1},
                {1,0,1,0,0},
                {1,1,0,1,0},
                {0,0,1,0,0},
                {1,0,0,0,0}
        };
//        int [][] b = new int[n][n];
        boolean[] isVisited = new boolean[n];
//        input(b, n);
        g.setData(b);
        g.dispAdj();
        System.out.println("\n");
        g.breadth(1, isVisited, true);
//        g.breadth(1);
        System.out.println("\nIs G is connected? " + g.isConnected() + "\n");
        System.out.println("Degree of the vertex A in G is " + g.degree(0));
        System.out.println();
    }
}
// xây dựng lớp queue cso tên là MyQueue để phục vụ cho duyệt đồ thị theo BFS

class MyQueue {
    LinkedList<Integer> t;
    MyQueue() {t = new LinkedList<Integer>();}
    boolean isEmpty() {return(t.isEmpty());}
    void enqueue(int x) {t.add(x);}
    int dequeue() {return(t.removeFirst());}
}
// Lớp Graph
class Graph {
    int [][] a; int n;
//    int[] adj = new int[100];
    boolean[] visited = new boolean[n];
    Graph() {a=null;n=0;}
    void clear() {a=null;n=0;}
    void setData(int [][] b) {
        n=b.length;
        a = new int[n][n];
        int i,j;
        for(i=0;i<n;i++)
            for(j=0;j<n;j++)
                a[i][j] = b[i][j];
    }

    void dispAdj() {
        int i,j;
        System.out.println("\nThe adjacency matrix:");
        for(i=0;i<n;i++) {
            System.out.println();
            for(j=0;j<n;j++)
                System.out.printf("%5d",a[i][j]);
        }
    }

    void visit(int i) {System.out.print(i+" ");}
// Hàm duyệt theo BFS bắt đầu tại đỉnh k bằng cách sử dụng MyQueue,
// mỗi khi lấy 1 đỉnh ra khỏi  queue thì hiển thị luôn (duyệt) đỉnh đó ra màn hình

    boolean[] breadth(int k, boolean[] isVisited, boolean isDisplay) {
        MyQueue q = new MyQueue();
        if(isDisplay)
            System.out.printf("%5d",k);
        isVisited[k] = true;
        for (int i = 0; i < n; i++) {
            if (isVisited[i]==true) continue;
            else {
                if (a[k][i] == 1) {
                    q.enqueue(i);
                    isVisited[i]=true;
                }
            }
        }

        while (!q.isEmpty()){
            int x = q.dequeue();
            if(isDisplay) breadth(x,isVisited, true);
            else breadth(x,isVisited, false);
        }
        return isVisited;
    }

    // Hàm kiểm tra tính liên thông của đồ thị
    boolean isConnected() {
        boolean[] cb = new boolean[5];
        for (int i = 0; i < cb.length; i++) {
            cb[i]=true;
        }
        for (int i = 0; i < n; i++) {
            boolean[] isVisited = new boolean[n];
            if(!Arrays.equals(breadth(i,isVisited,false),cb))
                return false;
        }
        return true;
    }

    // Hàm tính bậc của đỉnh k
    int degree(int k) {
        int count = 0;
        for (int i = 0; i < 5; i++) {
            if (a[k][i]==1) count++;
        }

        return count;
    }
}