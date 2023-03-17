package Stack_Queue;

public class MyQueue {
    Node head;
    Node tail;

    public MyQueue(){
        head = tail = null;
    }
    public boolean isEmpty() {
        return (head == null);
    }
    void enQueue(int x){
        Node node = new Node(x);
        if(isEmpty()){
            head = tail = node;
        } else {
            tail.next = node;
            tail = tail.next;
        }
    }

    int deQueue() throws Exception {
        if(head == null){
            throw new Exception();
        }
        int x = head.info;
        head = head.next;
        if(head == null)
            tail = null;
        return x;
    }
    int peek() throws Exception{
        if(isEmpty()) throw new Exception();
        return head.info;
    }
    void print(){
        Node node = head;
        while (node != null){
            System.out.print(" " + node.info);
            node = node.next;
        }
    }
    // Driver code
    public static void main(String[] args) throws Exception {
        Queue queue = new Queue(1000);
        MyQueue q = new MyQueue();

        int[] a = {3,31,53,2,5,11};
        for (int i = 0; i < a.length; i++) {
            q.enQueue(a[i]);
        }
        q.print();
        q.deQueue();
        q.deQueue();
        System.out.println();
        System.out.println(q.peek());
        System.out.println();
        q.print();
//        System.out.println(q.deQueue() + " dequeued from queue\n");
//        System.out.println("Front item is " + q.front());
//        System.out.println("Rear item is " + queue.rear());

//        for (int i = 0; i < a.length; i++) {
//            queue.enqueue(a[i]);
//        }
//        System.out.println(queue.dequeue() + " dequeued from queue\n");
//        System.out.println("Front item is " + queue.front());
//        System.out.println("Rear item is " + queue.rear());
    }

}
class Queue {
    int front, rear, size;
    int capacity;
    int array[];

    public Queue(int capacity) {
        this.capacity = capacity;
        front = this.size = 0;
        rear = capacity - 1;
        array = new int[this.capacity];
    }

    // Queue is full when size becomes
    // equal to the capacity
    boolean isFull(Queue queue) {
        return (queue.size == queue.capacity);
    }

    // Queue is empty when size is 0
    boolean isEmpty(Queue queue) {
        return (queue.size == 0);
    }

    // Method to add an item to the queue.
    // It changes rear and size
    void enqueue(int item)
    {
        if (isFull(this))
            return;
        this.rear = (this.rear + 1)
                % this.capacity;
        this.array[this.rear] = item;
        this.size = this.size + 1;
        System.out.println(item
                + " enqueued to queue");
    }

    // Method to remove an item from queue.
    // It changes front and size
    int dequeue()
    {
        if (isEmpty(this))
            return Integer.MIN_VALUE;

        int item = this.array[this.front];
        this.front = (this.front + 1)
                % this.capacity;
        this.size = this.size - 1;
        return item;
    }

    // Method to get front of queue
    int front()
    {
        if (isEmpty(this))
            return Integer.MIN_VALUE;

        return this.array[this.front];
    }

    // Method to get rear of queue
    int rear()
    {
        if (isEmpty(this))
            return Integer.MIN_VALUE;

        return this.array[this.rear];
    }
}
//class Queue {
//    int front, rear, capacity;
//    int queue[];
//
//    Queue(int c) {
//        front = rear = 0;
//        capacity = c;
//        queue = new int[capacity];
//    }
//
//    void queueEnqueue(int data) {
//        if (capacity == rear) {
//            System.out.printf("\nQueue is full\n");
//            return;
//        }
//
//        else {
//            queue[rear] = data;
//            rear++;
//        }
//        return;
//    }
//
//    void queueDequeue() {
//        if (front == rear) {
//            System.out.printf("\nQueue is empty\n");
//            return;
//        }
//        else {
//            for (int i = 0; i < rear - 1; i++) {
//                queue[i] = queue[i + 1];
//            }
//
//            if (rear < capacity)
//                queue[rear] = 0;
//
//            rear--;
//        }
//        return;
//    }
//
//    void queueDisplay() {
//        int i;
//        if (front == rear) {
//            System.out.printf("\nQueue is Empty\n");
//            return;
//        }

//        for (i = front; i < rear; i++) {
//            System.out.printf(" %d <-- ", queue[i]);
//        }
//        return;
//    }
//
//    // print front of queue
//    void queueFront() {
//        if (front == rear) {
//            System.out.printf("\nQueue is Empty\n");
//            return;
//        }
//        System.out.printf("\nFront Element is: %d", queue[front]);
//        return;
//    }
//}