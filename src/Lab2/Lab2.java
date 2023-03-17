package Lab2;
import java.util.Scanner;
public class Lab2 {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int n, choice;
        int[] a = {5, 7, 11, 3, 9, 2, 6};
        SimpleSort t = new SimpleSort();
        while (true) {
            System.out.println("\n Choose your option:");
            System.out.println("  1. Display data");
            System.out.println("  2. Selection sort");
            System.out.println("  3. Insertion sort");
            System.out.println("  4. Search");
            System.out.println("  0. Exit\n");
            System.out.print("  Your selection (0 -> 4): ");
            choice = s.nextInt();
            if (choice == 0) {
                System.out.println(" Good bye, have a nice day!");
                break;
            }
            switch (choice) {
                case 1:
                    t.display(a);
                    break;
                case 2:
                    t.selectSort(a);
                    break;
                case 3:
                    t.insertSort(a);
                    break;
                case 4:
                    System.out.print("Nhap value: ");
                    int value = s.nextInt();
                    System.out.printf("Search(%d): %d",value, t.search(a, 11));
                    break;
                default:
                    System.out.println("**Invalid choice. Try again.**");
            }
        }
    }
}
class SimpleSort {
    void display(int[] a) {
        int i;
        for (i = 0; i < a.length; i++)
            System.out.print("  " + a[i]);
        System.out.println();
    }
    //==================================================

    void swap(int[] a, int i, int k) // Swap element at position i with element at position k
    {
        int x;
        x = a[i];
        a[i] = a[k];
        a[k] = x;
    }
    int[] copyArray(int[] a){
        int n = a.length;
        int[] b = new int[n];
        for (int i = 0; i < n; i++) b[i] = a[i];
        return b;
    }
    //==================================================
    void selectSort(int[] a) {
        //lưu giá trị mảng a vào mảng b
        int[] b = copyArray(a);
        //sắp xếp trên mảng b
        int i, j, minIndex;
        for (i = 0; i < b.length - 1; i++) {
            minIndex = i;
            for (j = i+1; j < b.length ; j++) {
                if(b[j] < b[minIndex])
                    minIndex = j;
            }
            swap(b,i,minIndex);
        }
        //hiển thị kết quả sắp xếp
        display(b);
    }

    //==================================================
    void insertSort(int[] a) {
        //sắp xếp mảng b
        int[] b = copyArray(a);
        int i,j, temp;
        for (i = 0; i < b.length; i++) {
            temp = a[i];
            j = i-1;
            while (j>=0 && b[j] > temp){
                b[j+1] = b[j];
                j--;
            }
            b[j+1] = temp;
        }
        //hiển thị kết quả sắp xếp
        display(b);
    }

    //==================================================

    int search(int[] a, int value) {
        int index;
        for (int i = 0; i < a.length; i++) {
            if(a[i] == value){
                index = i;
                return index;
            }
        }
        return  -1;
    }
}