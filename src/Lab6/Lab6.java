package Lab6;
import java.util.Scanner;
public class Lab6 {
    public static void main(String[] args) {
        Queen t = new Queen();
        t.init();
        t.test(1);
        System.out.println();
    }
}
// Lớp Queen gồm có các thuộc tính: n là số con hậu cần đặt, a là mảng kiểm tra trên các hàng, b và c là mảng kiểm tra trên các đường chéo. a[i]=true nếu như cột i còn trống, a[i]=false nếu cột i đã đặt 1 con hậu
class Queen {
    int n, count;
    boolean a[], b[], c[];
    int x[];
    int[][] board;
    Scanner in ;
    Queen() {
        x = new int[20];
        a = new boolean[20];
        b = new boolean[40];
        c = new boolean[40];
        in = new Scanner(System.in);
    }
    //Hàm khởi tạo
    void init() {
        int i;
        System.out.print(" n = ");
        n = in .nextInt();
        count = 0;
        for (i = 1; i <= n; i++) a[i] = true;
        for (i = 1; i <= 2 * n; i++) b[i] = true;
        for (i = 1; i <= 2 * n; i++) c[i] = true;
    }
    //Hàm hiển thị phương án
    void result() {
        int i;
        board = new int[n+1][n+1];
        System.out.printf("\n%3d: \n", ++count);
        for (i = 1; i <= n; i++) 
            System.out.printf("Quan hau duoc dat tai vi tri hang %d cot %d\n",i,x[i]);
        for (int j = 1; j <= n; j++) {
            board[j][x[j]] = 1;
        }
        for (int j = 1; j <= n; j++) {
            for (int k = 1; k <= n; k++) {

                System.out.print(board[j][k] + " ");
            }
            System.out.println();
        }

    }
    // Hàm thuật toán tìm nghiệm theo thuật toán quay lui
    void test(int i) {
        for (int j = 1; j <= n; j++) {
            if(a[j] && b[i+j] && c[i-j+n]){
                x[i] = j;
                a[j] = b[i+j] = c[i-j+n] = false;
                if(i == n) result();
                else test(i+1);

                a[j] = b[i+j] = c[i-j+n] = true;
            }
        }
    }
}