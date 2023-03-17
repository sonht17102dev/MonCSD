package Lab1;

import java.util.Scanner;

public class Lab1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap n = ");
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = sc.nextInt();
            sc.nextLine();
        }
        SimpleSort s = new SimpleSort(a);
        s.bubbleSort();
    }
}
class SimpleSort {
    int[] a;
    int n;

    SimpleSort() {
    }

    SimpleSort(int[] b) {
        int i;
        n = b.length;
        a = new int[n];
        for (i = 0; i < n; i++) a[i] = b[i];
    }

    void display() {
        int i;
        for (i = 0; i < n; i++)
            System.out.print("  " + a[i]);
        System.out.println();
    }

    //==================================================
// Hàm hoán vị
    void swap(int i, int k) {
        int x;
        x = a[i];
        a[i] = a[k];
        a[k] = x;
    }

    // Hàm sắp xếp bằng thuật toán nổi bọt, sau mỗi bước sắp xếp hãy gọi tới hàm display() để hiển thị giá trị của mảng a ra màn hình
    void bubbleSort() {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - 1; j++) {
                if(a[j] > a[j+1])
                    swap(j+1, j);
            }
            display();
        }
    }
}

