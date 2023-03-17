package Lab3;
// Lớp Node chứa thông tin và hoạt động của mỗi node

class Node {
    int info;
    Node next;
    Node() {}
    Node(int x, Node p) {info=x;next=p;}
    Node(int x) {this(x,null);}
}

// Xây dựng lớp Mylist của danh sách liên kết
class MyList {
    Node head, tail;
    Node sorted;
    MyList() {head=tail=null;}
    boolean isEmpty() {return(head==null);}
    void clear() {head=tail=null;}
    //Hàm hiển thị giá trị info của node p
    void visit(Node p) {
        System.out.print(p.info + "  ");
    }

    // Hàm thêm  một phần tử vào cuối danh sách
    void addTail(int x) {
        Node node = new Node(x);
        if(isEmpty())
            head = tail = node;
        else {
            tail.next = node;
            tail = node;
        }

    }
    void addHead(int x){
        Node node = new Node(x);
        if(isEmpty()) head = tail =node;
        else {
            node.next = head;
            head =node;
        }
    }
    // Hàm thêm nhiều phần tử vào cuối danh sách
    void addMany(int [] a){
        for (int i = 0; i < a.length; i++) {
            addTail(a[i]);
        }
    }
    public void addPos(int x, int pos) throws NullPointerException{
        try {
        	if(pos < 0 || pos > length())
        		return;
        	else if (pos == 0) {
        		addHead(x);
        		return;
        	} else if (pos == length()) {
        		addTail(x);
        		return;
        	}
        	int i=0;
        	Node current = head;
        	while (current != null && i < pos - 1){
        		i++;
        		current = current.next;
        	}
        	Node newNode = new Node(x);
        	newNode.next = current.next;
        	current.next = newNode;
		} catch (Exception e) {
			System.out.println("\n Cannot add in position " + pos);
		}
    }
    // Hàm delete tại head
    void deleteFromHead(){
        head = head.next;
    }
    // Hàm delete tại tail
    void deleteFromTail(){
        if(isEmpty()){
            System.out.println("List is empty!");
            return;
        }
        if(head.next == null)
            deleteFromHead();
        else {
            Node preLast = head;
            while (preLast.next != tail)
                preLast = preLast.next;
            preLast.next = null;
            tail = preLast;
        }
    }
    // Ham delete tai vi tri position
    void deleteIndex(int pos){
        if(pos < 0 && pos > length())
            return;
        else if (pos == 0) {
            deleteFromHead();
            return;
        } else if (pos == length() - 1) {
            deleteFromTail();
            return;
        }
        int index = 0;
        Node current = head;
        Node prev = null;
        while (current != null && index < pos){
            prev = current;
            current = current.next;
        }
        prev.next = current.next;
    }

    // Ham delete tai vi tri co gia tri x
    void deleteNode(int x){
        Node current = head;
        Node prev = null;
        if(head.info == x){
            deleteFromHead();
            return;
        }
        if(tail.info == x){
            deleteFromTail();
            return;
        }
        while (current != null && current.info != x){
            prev = current;
            current = current.next;
        }
        if(current == null)
            return;
        else
            prev.next = current.next;
    }



    // Ham add Node vao danh sach da dc sap xep
    void addSorted(int x){
       Node current = head;
       Node nNode = new Node(x);
       Node prev = null;
       while (current != null && x > current.info){
           prev = current;
           current = current.next;
       }
       nNode.next = current;
       if(prev == null) addHead(x);
       else prev.next = nNode;
    }

    int length(){
        Node node = head;
        int length = 0;
        while (node!=null){
            length++;
            node = node.next;
        }
        return length;
    }
    void sort(){
        for(Node node = head; node!=null; node=node.next){
            for(Node node1 = node.next; node1!=null; node1=node1.next) {
                if(node.info > node1.info) {
                    int temp = node.info;
                    node.info = node1.info;
                    node1.info = temp;
                }
            }
        }
    }
	void insertionSort(Node headref) {
	    // Initialize sorted linked list
	    sorted = null;
	    Node current = headref;
	    // Traverse the given linked list and insert every
	    // node to sorted
	    while (current != null)
	    {
	        // Store next for next iteration
	        Node next = current.next;
	        // insert current in sorted linked list
	        sortedInsert(current);
	        // Update current
	        current = next;
	    }
	    // Update head_ref to point to sorted linked list
	    head = sorted;
	}

    /*
     * function to insert a new_node in a list. Note that
     * this function expects a pointer to head_ref as this
     * can modify the head of the input linked list
     * (similar to push())
     */
    void sortedInsert(Node newnode) {
        /* Special case for the head end */
        if (sorted == null || sorted.info >= newnode.info) {
            newnode.next = sorted;
            sorted = newnode;
        } else {
            Node current = sorted;
            /* Locate the node before the point of insertion */
            while (current.next != null && current.next.info < newnode.info)
                current = current.next;

            newnode.next = current.next;
            current.next = newnode;
        }
    }

    // Hàm Duyệt danh sách
    void traverse(){
        Node node = head;
        while (node!= null){
            visit(node);
            node = node.next;
        }
    }

    // Hàm tìm kiếm phần tử có giá trị lớn hơn x,
    // nếu tìm thấy thì hiển thị chỉ số của phần tử ra màn hình,
    // giả sử phần tử đầu tiên có chỉ số là 0;
    void search(int x){
        int index = 0;
        Node node = head;
        while (node != null && node.info < x){
            index++;
            node = node.next;
        }
        System.out.printf("Search(%d): %d",x,index);
    }
    // Hàm tìm kiếm phần tử có giá trị bằng x
    // trả về chỉ số của phần tử đó
    public int find(int x) {
        int pos = 0;
        Node current = head;
        while (current != null) {
            if (current.info == x) {
                return pos;
            }
            current = current.next;
            pos++;
        }
        return -1;
    }
}

