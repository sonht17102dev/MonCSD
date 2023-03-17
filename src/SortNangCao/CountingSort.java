package SortNangCao;
import java.util.Scanner;
public class CountingSort {
//    void sort(char[] arr){
//        int n = arr.length;
//
//        char[] output = new char[n];
//        int count[] = new int[256];
//        for (int i = 0; i < 256; i++) {
//            count[i] = 0;
//        }
//        for (int i = 0; i < n; i++) {
//            count[arr[i]]++;
//        }
//        for (int i = 1; i <= 255 ; i++) {
//            count[i] += count[i-1];
//        }
//        for (int i = n-1; i >=0 ; i--) {
//            output[count[arr[i]] - 1] = arr[i];
//            count[arr[i]]--;
//        }
//        for (int i = 0; i < n; i++) {
//            arr[i] = output[i];
//        }
//    }
    private static final int MAX_RANGE = 1000000;

    public static void sort(int[] arr) {
        int N = arr.length;
        if (N == 0) {
            return;
        }

        int max = arr[0],
                min = arr[0];
        for (int i = 1; i < N; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        int range = max - min + 1;

        if (range > MAX_RANGE) {
            System.out.println("\nError");
            return;
        }

        int[] count = new int[range];
        for (int i = 0; i < N; i++)
            count[arr[i] - min]++;

        for (int i = 1; i < range; i++)
            count[i] += count[i - 1];

        int j = 0;
        for (int i = 0; i < range; i++) {
            while (j < count[i]) {
                arr[j++] = i + min;
            }
        }
    }


    public static void nhap() {
        Scanner scan = new Scanner(System.in);
        int n, i;
        System.out.println("Nhap so phan tu cua mang");
        n = scan.nextInt();
        int arr[] = new int[n];
        System.out.println("\nNhap phan tu thu " + n + " cua mang");
        for (i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }
        sort(arr);
        System.out.println("\nMang sau khi da sap xep la:  ");
        for (i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

    }
    public static void main(String args[]) {
//        CountingSort ob = new CountingSort();
//        char arr[] = { 'g', 'e', 'e', 'k', 's', 'f', 'o',
//                'r', 'g', 'e', 'e', 'k', 's' };
//
//        ob.sort(arr);
//
//        System.out.println("Sorted character array is ");
//        for (int i = 0; i < arr.length; ++i)
//            System.out.print(arr[i] + " ");
        nhap();
    }
}
