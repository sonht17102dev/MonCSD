package SortNangCao;

public class MergeSort {
    // Merge hai mảng con của arr[].
    // Mảng con thứ nhất là arr[l..m]
    // Mảng con thứ hai là arr[m+1..r]
    void merge(int[] arr, int left, int mid, int right){
        // Tìm kích thước của 2 mảng con để merged
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Tạo mảng tạm
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];
        //Copy dữ liệu vào mảng tạm
        for (int i = 0; i < n1; i++)
            leftArray[i] = arr[left + i];
        for (int j = 0; j < n2; j++)
            rightArray[j] = arr[mid + 1 + j];

        // Merge các mảng tạm lại
        // Chỉ mục ban đầu của 2 mảng con
        int i = 0, j=0;

        // Chỉ mục ban đầu của mảng phụ được hợp nhất
        int k = left;
        while (i < n1 && j < n2){
            if(leftArray[i] <= rightArray[j]){
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }
        // Sao chép các phần tử còn lại của left[] nếu có
        while (i<n1){
            arr[k] = leftArray[i];
            i++;
            k++;
        }
        // Sao chép các phần tử còn lại của right[] nếu có
        while (j < n2) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }

    void sort(int[] arr, int left, int right){
        if(left < right){
            // Tìm điểm chính giữa
            int mid = (left + right) / 2;
            // Hàm đệ quy tiếp tục chia đôi
            sort(arr,left,mid);
            sort(arr,mid + 1, right);

            merge(arr, left,mid,right);
            printArray(arr);
        }
    }
    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String args[]) {
        int arr[] = { 25, 30, 45, 6, 11, 90, 15 ,4};

        System.out.println("Mảng ban đầu:");
        printArray(arr);

        MergeSort ob = new MergeSort();
        ob.sort(arr, 0, arr.length - 1);

        System.out.println("Mảng sau khi sắp xếp:");
        printArray(arr);
    }
}
