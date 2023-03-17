package Recursion;

import Stack_Queue.MyStack;

public class Recursion {
    //phương thức đệ quy trả về n! (n giai thừa).
    public static int factorial(int n) {
        if(n == 0)
            return 1;
        return n * factorial(n-1);
    }
    /**
     * Tim uoc so chung lon nhat (USCLN)
     */
    static int uscln(int a, int b) {
        if (b == 0) return a;
        return uscln(b, a % b);
    }
    /**
     * Tim boi so chung nho nhat (BSCNN)
     */
    static int bscnn(int a, int b) {
        return (a * b) / uscln(a, b);
    }
    // phương thức đệ quy tính tổng các số từ 1 tới n:
    public static int sum(int n) {
        if(n == 0)
            return 0;
        return n + sum(n-1);
    }

    //phương thức đệ quy trả về tổng các số lẻ từ 1 tới n.
    public static int sumOdd(int n) {
        if (n == 1)
            return 1;
        if (n % 2 == 0)
            return sumOdd(n - 1);
        else
            return n + sumOdd(n - 1);
    }
    //phương thức đệ quy tính tổng các phần tử của mảng.
    public static int sumOfArray(int[] arr, int n) {
        if (n == 1)
            return arr[0];
        return arr[n-1] + sumOfArray(arr, n-1);
    }
    // Tính day so Fibonaci
    public static long fibonaci(int n) {
        if(n < 0) return -1;
        if (n==0 || n==1)
            return n;
        return fibonaci(n - 1) + fibonaci(n - 2); // gọi đệ quy nhi phan
    }
    // Thap Ha Noi
    public static void thapHaNoi(int n, char dau, char cuoi, char trungGian) {
        if(n==1){
            System.out.println(String.format("Chuyen dia %d tu %s sang %s",n,dau,cuoi));
        } else {
            thapHaNoi(n-1, dau, trungGian,cuoi);
            System.out.println(String.format("Chuyen dia %d tu %s sang %s",n,dau,cuoi));
            thapHaNoi(n-1, trungGian, cuoi, dau);
        }
    }
    // Tính tổ hợp chập K của N
    public static int combine(int n, int k) {
        if (k > n)
            return 0;
        else if (k == 0 || k == n)
            return 1;
        else
            return (combine(n - 1, k) + combine(n - 1, k - 1)); // Binary Recursion
    }
    // Ham so Ackermann
    public static int ackermann(int x, int y) {
        if (x == 0) {
            return (y + 1);
        } else {
            if (y == 0) {
                return ackermann(x - 1, 1);
            } else {
                return ackermann(x - 1, ackermann(x, y - 1)); // Nested Recursion
            }
        }
    }
    // Nhập một số nguyên dương n bất kỳ.
    // Kiểm tra số đó là chẵn hay lẻ bằng đệ quy.
    public static boolean isEven(int n) {
        if (n == 0)
            return true;
        else if (n == 1)
            return false;
        else
            return isOdd(n - 1);
    }

    public static boolean isOdd(int n) {
        if (n == 0)
            return false;
        else if (n == 1)
            return true;
        else
            return isEven(n - 1);
    }
    // Tim kiem nhi phan dung de quy
    static int binarySearch(int[] a, int left, int right, int x){
        if(left <= right){
            int mid = left + (right - left) / 2;
            if(a[mid] == x) return mid;
            else if (x > a[mid])
                return binarySearch(a, mid + 1, right,x);
            else return binarySearch(a, left, mid - 1,x);
        }
        return -1;
    }
    // Chuyen so thap phan thanh nhi phan dung de quy
    static void convertToBinary(int x) {
        MyStack stack = new MyStack();
        if(x==0) return;
        stack.push(x%2);
        convertToBinary(x/2);
        while (!stack.isEmpty())
            System.out.print(stack.pop());
    }
    public static void main(String[] args) {
        // giai thua n
        System.out.println("Giai thua cua 5: "+factorial(5));
        // tong tu 1 den n
        System.out.println("Tong tu 1 den 3: " + sum(3));
        // Tổng các số lẻ từ 1 tới n.
        System.out.println("tổng các số lẻ từ 1 tới 5 : " + sumOdd(5));
        // Tính tổng các phần tử của mảng.
        int[] a = {5,3,2};
        System.out.println("Tính tổng các phần tử của mảng : " + sumOfArray(a,3));
        System.out.println(String.format("%50s"," ").replace(" ","-"));
        thapHaNoi(3, 'A', 'C', 'B');
        System.out.println();
        System.out.println("combine(10, 2) = " + combine(10, 2)); // 45
        System.out.println();
        System.out.println("ackerman(3, 2) = " + ackermann(3, 2));
        System.out.println();
        System.out.println("isOdd(5) = " + isOdd(5)); // true
        System.out.println();
        for (int i = 0; i < 10; i++) {
//            System.out.printf("fibonaci(%d) = %d",i,fibonaci(i));
            System.out.print(fibonaci(i) + " ");
        }
        System.out.println();
        System.out.println(String.format("%50s"," ").replace(" ","-"));
        int[] b = {11,21,32,33,54,64,65,79,91,93};
        System.out.printf("BinarySearch(%d): %d\n",91,binarySearch(b,0,b.length - 1, 91));
        System.out.println(String.format("%50s"," ").replace(" ","-"));
        convertToBinary(5);
        System.out.println();
        System.out.println("ước chung lớn nhất của 6 và 15 là " + uscln(6,15));
        System.out.println(" bội chung nhỏ nhất của 4 và 6 là " + bscnn(4,6));
    }
}
