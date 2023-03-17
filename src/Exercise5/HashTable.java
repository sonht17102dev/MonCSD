package Exercise5;

public class HashTable {

    MyList [] a;
    int M;

    HashTable(){
        M = 10;
        a = new MyList[M];
        for(int i=0;i<M;i++)
            a[i] = new MyList();
    }

    boolean isEmpty(){
        boolean empty = true;
        for(int i=0;i<M;i++)
            if(!a[i].isEmpty()) {
                empty=false;
                break;
            }
        return(empty);
    }

    void clear(){
        for(int i=0;i<M;i++)
            a[i].head = a[i].tail = null;
    }

    // Hàm add 1 sinh viên vào Hash tabe
    void add(int x, String name, float grad1, float grad2, float grad3 ){
        int i = x % M;
        a[i].add( x, name,grad1, grad2,  grad3);
    }

    // Hàm duyệt các phần tử trong Hash table
    void traverse() {
        for (int i = 0; i < M; i++) {
            System.out.printf("Linked list at %d: ",i);
            a[i].traverse();
        }
    }

    // Tìm kiếm theo ID
    Node search(int x){
        for (int i = 0; i < M; i++) {
            Node n = a[i].search(x);
            if(n!=null) return n;
        }
        return null;
    }

/*Hàm addArray sẽ add  (mảng ) các sinh viên vào Hash Table, hàm này sẽ gọi tới hàm add(…) n lần
Thông tin của các sinh viên lưu ở mảng b,c,d,e,f sẽ add vào Hash Table.
Trong đó, sinh viên thứ i sẽ có ID, name, grad1, grad2, grad3 lần lượt là b[i],c[i],d[i],e[i], f[i] */

    void addArray(int [] a, String [] b, float[] c, float[] d, float[ ] e){
        for (int i = 0; i < a.length; i++) {
            add(a[i],b[i],c[i],d[i],e[i]);
        }
    }

}

