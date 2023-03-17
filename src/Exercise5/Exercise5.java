package Exercise5;

import java.util.Scanner;

public class Exercise5 {
    static int [] a;
    static String [] b;
    static float[] c;
    static float[] d;
    static float[] e;
    static Scanner sc = new Scanner(System.in);

    // Hàm nhập thông tin của các sinh viên từ bàn phím lưu vào mảng a,b,c,d,e,
    // sinh viên thứ i sẽ có ID, name, grad1, grad2, grad3 lần lượt là b[i],c[i],d[i],e[i], f[i]

    static void input() {
        System.out.print("Nhập vào số lượng phần tử: ");
        int n = sc.nextInt(); sc.nextLine();
        a= new int[n];
        b= new String[n];
        c = new float[n];
        d = new float[n];
        e = new float[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            b[i] = sc.next();
            c[i] = sc.nextInt();
            d[i] = sc.nextInt();
            e[i] = sc.nextInt();
            sc.nextLine();
        }
    }

    public static void main(String args[]) {

        int choice, x;
        Node p;

        int n=20;

        input();
        HashTable t = new HashTable();

        System.out.println("  1. Nhập ");
        System.out.println("  2. Hiển thị");
        System.out.println("  3. Tìm kiếm theo ID");
        System.out.println("  0. thoát\n");

        while(true) {
            System.out.println("Nhập vào chức năng 1/2/3:");
            choice = sc.nextInt();
            if(choice==0) {
                System.out.println(" Thoát!");
                break;
            }
            switch(choice) {
                case 1:
                    t. addArray(a,b,c,d,e);
                    break;
                case 2:
                    t.traverse();
                    break;
                case 3: System.out.print("\n Nhập ID cần tìm kiếm: ");
                    x = sc.nextInt();
                    p = t.search(x);
                    if(p!=null)
                        System.out.println(" " + p);
                    else
                        System.out.println(x + " Không tìm thấy");
                    break;
            }
        }
    }

}
