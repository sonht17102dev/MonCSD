package Lab3;

public class LinkedList {
	class Node {
	    int info;
	    Node next;
	    Node() {}
	    Node(int x, Node p) {info=x;next=p;}
	    Node(int x) {this(x,null);}
	}
	Node head, tail;
	public LinkedList() {
		head = tail = null;
	}
	// kiem tra Linkedlist co trong ko
	boolean isEmpty() {
		if(head == null)
			return true;
		return false;
	}
	// ham xoa tat ca cac phan tu trong linkedlist
	void clear() {
		head = tail = null;
	}
	// ham tra ve so luong phan tu trong list
	int length(){
		Node current = head;
		int length = 0;
		while (current != null) {
			length++;
			current = current.next;
		}
		return length;
	}
	//Hàm hiển thị giá trị info của node p
    void visit(Node p) {
    	System.out.print("\n " + p.info);
    }
    
 // Hàm thêm  một phần tử vào cuối danh sách
    void addTail(int x) {
    	Node node = new Node(x);
    	if(isEmpty()) {
    		head = tail = node;
    	} else {
    		tail.next = node;
    		tail = node;
    	}
    }
    
    // Hàm thêm  một phần tử vào đầu danh sách
    void addHead(int x){
    	Node node =  new Node(x);
    	if (isEmpty()) {
			head  = tail = node;
		} else {
			node.next = head;
			head = node;
		}
    }
    // Hàm thêm nhiều phần tử vào cuối danh sách
    void addManyTail(int [] a){
    	for (int i = 0; i < a.length; i++) {
			addTail(a[i]);
		}
    }
    // Hàm thêm nhiều phần tử vào đầu danh sách
    void addManyHead(int [] a){
    	for (int i = 0; i < a.length; i++) {
			addHead(a[i]);
		}
    }
    
    // Hàm thêm phần tử vào vị trí pos
    public void addPosition(int x, int pos) throws NullPointerException{
    	try {
			if(pos < 0 || pos > length()) {
				throw new NullPointerException();
			} else if(pos == 0) {
				addHead(x);
				return;
			} else if(pos == length()) {
				addTail(x);
				return;
			} else {
				int i=0;
				Node currentNode = head;
				while (currentNode != null && i < pos - 1) {
					i++;
					currentNode = currentNode.next;
				}
				Node newNode = new Node(x);
				newNode.next = currentNode.next;
				currentNode.next = newNode;
			}
				
		} catch (NullPointerException e) {
			// TODO: handle exception
			System.out.println("\n Cannot add in position " + pos );
		}
    }
 // Hàm delete tại head
    void deleteFromHead(){
    	if(isEmpty()) {
    		System.out.println("List is Empty");
    		return;
    	}
    	head = head.next;
    }
 // Hàm delete tại tail
    void deleteFromTail(){
    	if(isEmpty()) {
    		System.out.println("List is empty");
    		return;
    	}
    	if(head.next == null)
    		deleteFromHead();
    	else {
    		Node preLast = head;
    		while (preLast.next != tail) {
				preLast = preLast.next;
			}
    		preLast.next = null;
    		tail = preLast;
    	}
    }
 // Ham delete tai vi tri position
    void deleteIndex(int pos){
    	
    }
    
    // Ham delete tai vi tri co gia tri x
    void deleteNode(int x){

    }
    
 // Ham add Node vao danh sach da dc sap xep
    void addSorted(int x){
    	
    }
    //Ham sort type BUbble
    void sortBubble(){
    
    }
  //Ham sort type Selection
    void selectSort() {
    	
    }
    // Ham sort  type Insert
    void insertSort() {
    	
    }
    
    // Ham them 1 phan tu vao linkedlist da sap xep
    void sortedInsert(Node newnode) {
    	
    }
 // Hàm Duyệt danh sách
    void traverse(){
    	Node node = head;
    	while (node != null) {
			System.out.print(" " + node.info);
			node = node.next;
		}
    }
    
 // Hàm tìm kiếm phần tử có giá trị lớn hơn x,
    // nếu tìm thấy thì hiển thị chỉ số của phần tử ra màn hình,
    // giả sử phần tử đầu tiên có chỉ số là 0;
    void search(int x){
    	
    }
    
 // Hàm tìm kiếm phần tử có giá trị bằng x
    // trả về chỉ số của phần tử đó
    public int find(int x) {
    	return 0;
    }
}
