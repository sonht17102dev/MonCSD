package SortNangCao;
import java.util.Scanner;
public class RadixSort {

    public static int [] radixSort(int[] A) {
        int i,
                m = A[0],
                exp = 1,
                n = A.length;
        int[] B = new int[10000];
        for (i = 1; i < n; i++) {   //tìm số lớn nhất trong dãy
            if (A[i] > m) {
                m = A[i];
            }
        }
        while (m / exp > 0) {
            int[] bucket = new int[10];
            for (i = 0; i < n; i++) //đếm phân bố các số từ 0..9
                bucket[(A[i] / exp) % 10]++;
            for (i = 1; i < 10; i++)
                bucket[i] += bucket[i - 1];
            for (i = n - 1; i >= 0; i--)
                B[bucket[(A[i] / exp) % 10]--] = A[i];
            for (i = 0; i < n; i++)
                A[i] = B[i];
            exp *= 10;
        }
        return A;
    }

    public static void nhap() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Radix Sort Test\n");
        int n, i;
        System.out.println("Enter number of integer elements");
        n = scan.nextInt();
        int arr[] = new int[n];
        System.out.println("\nEnter " + n + " integer elements");
        for (i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }

        radixSort(arr);

        System.out.println("\nElements after sorting ");
        for (i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public long main(int[] A) {
        long startTime1 = System.nanoTime();
        RadixSort radixSort = new RadixSort();
        radixSort.radixSort(A);
        long endTime1 = System.nanoTime();
        long totalTime1 = endTime1 - startTime1;
        return totalTime1;
    }

    public static void main(String[] args) {
        nhap();
    }
}
