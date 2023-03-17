package Exercise3;
// Lớp EffSort

import java.util.Scanner;

class EffSort {
    int [] a; int n;
    EffSort() {}
    EffSort(int [] b) {
        int i;
        n = b.length;
        a = new int[n];
        for(i=0;i<n;i++) a[i]= b[i];
    }
    void display() {
        int i;
        for(i=0;i<n;i++)
            System.out.print("  " + a[i]);
        System.out.println();
    }
    //--------------------------------------------------
    // Hàm hoán vị
    void swap(int [] a, int i, int k) {
        int x; x=a[i];a[i]=a[k];a[k]=x;
    }
//==================================================
  /*CAI DAT GIAI THUAT QUICKSORT}
    Phương thức partition sẽ phân hoạch danh sách từ low đến up thành 2 phần:
    các nút có nội dung <= a[pivot] nằm bên trái pivot, các nútt có nội dung > a[pivot] nằm bên phải
    Chọn nút trục=a[low], quét 2 đầu, i từ dưới lên, j trên xuống và đổi chỗ các phần tử sai chỗ, khi kết thúc quét thì đổi chỗ cho a[low]
    và a[j], vậy nút trục sẽ chuyển đến vị trí j;*/


    int partition(int low,int up) {// return pivot index
        int pivot = a[up];
        int i = (low - 1);
        for (int j = low; j < up; j++) {
            if(a[j] < pivot){
                i++;
                swap(a,i,j);
            }
        }
        swap(a,i+1, up);
        return i+1;
    }
    // Phương thức quicksort sẽ gọi tới phương thức partition để sắp xếp theo thuật toán quick sort
    void quickSort(int low,int up) {
        if(low<up){
//            display();
            int pi = partition(low,up);
            quickSort(low,pi-1);
            quickSort(pi+1, up);
        }
    }
    //-----------------------------------------------------
    void quickSort() {
        quickSort(0,n-1);
    }
}
//==================================================
public class Exercise3{

    static int [] b;
    static Scanner sc = new Scanner(System.in);

// Phương thức input để nhập giá trị cho mảng b;

    static int[] input(int [] b) {
        System.out.println("Quy trình nhập dữ liệu:");
        System.out.print("Số phần tử của mảng: ");
        int n = sc.nextInt();
        sc.nextLine();
        b = new int[n];
        for (int i = 0; i < n; i++) {
            b[i] = sc.nextInt();
        }
        sc.nextLine();
        return b;
    }
    static void menu() {
        System.out.println("1. Nhập dữ liệu");
        System.out.println("2. Sắp xếp");
        System.out.println("3. Hiển thị giá trị mảng a");
        System.out.println("0. Thoát");
    }
    /*Trong phương thức main phải xây dựng menu
    để gọi tới các phương thức cần thiết như input(b),
    gọi tới phương thức khởi tạo  EffSort(b) và  quickSort();
    display() trong lớp EffSort*/
    public static void main(String args[]) {
        EffSort es = new EffSort();
        int c;
        do {
            menu();
            c = sc.nextInt();
            sc.nextLine();
            switch (c) {
                case 1:
                    b = input(b);
                    es = new EffSort(b);
                    break;
                case 2:
                    es.quickSort();
                    break;
                case 3:
                    es.display();
                    break;
            }
        } while (c!=0);

    }
}
