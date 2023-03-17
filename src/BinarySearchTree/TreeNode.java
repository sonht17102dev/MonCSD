package BinarySearchTree;

public class TreeNode {
    int data;
    TreeNode leftChild;
    TreeNode rightChild;
    TreeNode(int x){
        this.data = x;
    }
    public void insert(int data){
        if(data >= this.data){
            if(rightChild == null)
                rightChild = new TreeNode(data);
            else
                rightChild.insert(data);
        } else {
            if(leftChild == null)
                leftChild = new TreeNode(data);
            else
                leftChild.insert(data);
        }
    }
    public TreeNode find(int data){
        if(this.data == data)
            return this;
        if(data < this.data && leftChild != null)
            return leftChild.find(data);
        if(rightChild != null)
            return rightChild.find(data);
        return null;
    }
    public int smallest(){
        if(this.leftChild == null)
            return this.data;
        return this.leftChild.smallest();
    }
    public int largest(){
        if(this.rightChild == null)
            return this.data;
        return this.rightChild.largest();
    }

//    public void delete(){
//        this.isDeleted = true;
//    }
}
