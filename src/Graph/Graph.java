package Graph;//package Graph;

// Java implementation of the approach
import java.util.*;

class MyQueue {
    LinkedList<Integer> t;
    MyQueue() {t = new LinkedList<Integer>();}
    boolean isEmpty() {return(t.isEmpty());}
    void enqueue(int x) {t.add(x);}
    int dequeue() {return(t.removeFirst());}
}

class Graph1{
    private int V;
    private LinkedList<Integer> adjacent[];
    Graph1(){}
    Graph1(int v)
    {
        V = v;
        adjacent = new LinkedList[v];
        for (int i=0; i<v; ++i)
            adjacent[i] = new LinkedList();
    }
    void addEdge(int v,int w)
    {
        adjacent[v].add(w);
    }
     void addVertex(Vertex[] vertices, char label, int index){
        Vertex vertex = new Vertex(label, false);
        vertices[index] = vertex;
    }
     void addEdge(boolean[][] matrix, int x, int y){
        matrix[x][y] = true;
        matrix[y][x] = true;
    }
     void visit(Vertex vertex){
        System.out.print(vertex.label + " ");
         System.out.println();
    }
     void DFS(Vertex[] vertices, boolean[][] matrix, int index){
        vertices[index].visited = true;
        visit(vertices[index]);
        for (int i = 0; i < vertices.length; i++) {
            if(matrix[index][i] && vertices[i].visited == false)
                DFS(vertices,matrix, i);
        }
    }
    void BFS(Vertex[] vertices, boolean[][] matrix, int index){
         MyQueue q = new MyQueue();
         q.enqueue(index);
         vertices[index].visited = true;
         visit(vertices[index]);
         while (!q.isEmpty()){
             int v = q.dequeue();
             System.out.print(v);
             for (int i = 0; i < vertices.length; i++) {
                 if(!vertices[i].visited){
                     q.enqueue(i);
                     vertices[i].visited = true;
                 }
             }
         }
    }

}
//0 1
//0 2
//0 4
//0 9
//1 3
//2 5
//2 6
//2 8
//4 7
//5 6
//7 8
class Vertex{
    char label;
    boolean visited;
    public Vertex(char label, boolean visited){
        this.label = label;
        this.visited = visited;
    }
}
class Graph{
    public static void main(String[] args) {
//        int soDinh;
//        char tenDinh;
//        Graph1 g = new Graph1();
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Nhap so dinh: ");
//        soDinh = sc.nextInt();
//        Vertex[] vertices = new Vertex[soDinh];
//        boolean [][] matrix = new boolean[soDinh][soDinh];
//        for (int i = 0; i < soDinh; i++) {
//            System.out.println("Nhap ten dinh: ");
//            tenDinh = sc.next().charAt(0);
//            g.addVertex(vertices, tenDinh,i);
//        }
//
//        for (int i = 0; ; i++) {
//            int x;
//            System.out.println("nhap hoanh do, tung do(-1 de ket thuc): ");
//            x = sc.nextInt();
//            if(x<0) break;
//
//            int y = sc.nextInt();
//            g.addEdge(matrix, x, y);
//        }
//
//        System.out.println("Duyet do thi theo chieu sau : ");
//        g.DFS(vertices, matrix, 0);
//        System.out.println("Duyet do thi theo chieu rong : ");
//        g.BFS(vertices, matrix, 0);
    }
}

