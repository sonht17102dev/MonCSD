package Lab3;

public class Main {

	public static void main(String[] args) {
//		MyList t = new MyList();
		LinkedList linkedList = new LinkedList();
		int[] a = { 7, 2, 9, 8, 6, 3 };
		linkedList.addManyTail(a);
		System.out.println("\n Traverse:");
		linkedList.traverse();
		//linkedList.deleteFromHead();
		linkedList.addPosition(4, -2);
		System.out.println("\n Traverse:");
		linkedList.traverse();
		
//		t.traverse();
//		t.insertionSort(t.head);
//		System.out.println("\n Sorted:");
//		t.traverse();
//		t.sortedInsert(new Node(4));
//		System.out.println("\n Insert new node in Sorted List:");
//		t.traverse();
//		t.addMany(a);
//		t.addTail(6);
//		t.traverse();
//		t.sort();
//	    t.insertionSort(t.head);
//		System.out.println();
//	    t.addSorted(-2);
//		System.out.println();
//	    t.traverse();
//	        t.addSorted(20);
//	        t.deleteFromTail();
//	        t.addPos(23,8);
//	        t.deleteNode(7);
//	        t.deleteNode(2);

//	        t.traverse();
//	        t.addTail(4);
//	        t.deleteFromTail();
//		System.out.println();
//	        System.out.println("\n Search:");
//	        t.search(8);
//		System.out.println();
//	        t.traverse();
//		System.out.println(t.find(4));
	}

}
