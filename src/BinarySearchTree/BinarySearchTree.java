package BinarySearchTree;

public class BinarySearchTree {
    TreeNode root;

    void insert(int data){
        if(root != null)
            root.insert(data);
        else
            root = new TreeNode(data);
    }
    TreeNode find(int x){
        if(root != null)
            return root.find(x);
        return null;
    }
    void insertMany(int[] a){
        for (int i = 0; i < a.length; i++) {
            insert(a[i]);
        }
    }
    void visit(TreeNode p) {
        System.out.print(p.data + " ");
    }

    // Duyệt theo thứ tự pre Order
    void preOrder(TreeNode p) {
        if(p==null) return;
        visit(p);
        preOrder(p.leftChild);
        preOrder(p.rightChild);
    }
    void inOrder(TreeNode p){
        if(p== null) return;
        inOrder(p.leftChild);
        visit(p);
        inOrder(p.rightChild);
    }
    void postOrder(TreeNode p){
        if(p == null) return;
        postOrder(p.leftChild);
        postOrder(p.rightChild);
        visit(p);
    }

    public int smallest(){
        if(this.root == null)
            return root.data;
        else
            return root.smallest();
    }
    public int largest(){
        if(this.root != null)
            return root.largest();
        return root.data;
    }


    // Duyệt cây để tìm kiếm nút có giá trị >x,
    // nếu thấy hiển thị giá trị ra màn hình,
    // sau đó lại tìm tiếp cho đến khi nào duyệt hết các nút //trong cây
    void search(TreeNode p, int x){
        if (p == null)
            return;
        search(p.leftChild,x);
        if (p.data > x) visit(p);
        search(p.rightChild,x);
    }
    public TreeNode delete(TreeNode root, Integer data){
        if(root == null)
            return null;
        if(data < root.data){
            root.leftChild = delete(root.leftChild,data);
        } else if (data > root.data) {
            root.rightChild = delete(root.rightChild,data);
            delete(root.rightChild,data);
        } else {
            //TH1: xoa node la
            if(root.leftChild == null && root.rightChild == null)
                return null;
            //TH2: xoa node co 1 node con : ben trai
            if(root.leftChild != null && root.rightChild == null)
                return root.leftChild;
            //TH2: xoa node co 1 node con : ben phai
            if(root.leftChild == null && root.rightChild != null)
                return root.rightChild;
            //TH3: xoa node co 2 node con
            // tim node trai cung cua cay con ben phai
            TreeNode leftModeNode = findMinLeft(root.rightChild);
            root.data = leftModeNode.data;
            root.rightChild = delete(root.rightChild, leftModeNode.data);
        }
        return root;
    }
    public TreeNode findMinLeft(TreeNode root){
        if(root == null)
            return null;
        TreeNode leftMostNode = root;
        while (leftMostNode.leftChild != null)
            leftMostNode = leftMostNode.leftChild;
        return leftMostNode;
    }
//    public void delete(int data){
//        TreeNode toDel = find(data);
//        toDel.delete();
//    }
}
