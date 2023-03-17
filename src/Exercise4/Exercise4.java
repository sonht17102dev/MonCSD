package Exercise4;

import java.util.Scanner;

class EffSort {
    int [] a;
    int n;

    void display(int[] a) {
        int i;
        for(i=0;i<a.length;i++)
            System.out.print("  " + a[i]);
        System.out.println();
    }
    void sort(int[] arr){
        heapify(arr);
        for (int i = n; i > 0; i--) {
            swap(arr, 0 ,i);
            n = n - 1;
            maxHeap(arr,0);
        }
    }
    void heapify(int[] arr){
        n = arr.length - 1;
        for (int i = n/2; i >= 0 ; i--) {
            maxHeap(arr,i);
        }
    }
    void maxHeap(int[] arr, int i){
        int left = 2 * i;
        int right = 2 * i + 1;
        int max = i;
        if (left <= n && arr[left] > arr[i]) {
            max = left;
        }
        if (right <= n && arr[right] > arr[max]) {
            max = right;
        }

        if (max != i) {
            swap(arr, i, max);
            maxHeap(arr, max);
        }
    }
    //==================================================
  /*Sap xep bang HEAP: Heap la cay nhi phan gan day duoc cai dat bang
    mang mot chieu voi cac nut tren heap co noi dung nho hon nut goc
    va cac nhanh cay con cung la cac heap
  */

    void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
//==================================================
public class Exercise4{
    public static void main(String args[]){
        int [] b = {7,3,5,9,11,8,6,15,10,12,14};
        EffSort t = new EffSort();
        t.sort(b);
        t.display(b);
        System.out.println();
    }
}
