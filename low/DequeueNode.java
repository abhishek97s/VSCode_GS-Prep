package low;

public class DequeueNode {

    Node front, rear;
    int size;

    public DequeueNode() {
        front = rear = null;
        size = 0;
    }

    static class Node {
        int val;
        Node next, prev;

        static Node getNode(int data) {
            Node newNode = new Node();
            newNode.val = data;
            newNode.next = newNode.prev = null;
            return newNode;
        }
    }

    boolean isEmpty() {
        return front == null;
    }

    void insertFront(int data) {
        Node newNode = Node.getNode(data);

        if (front == null)
            rear = front = newNode;
        else {
            newNode.next = front;
            front.prev = newNode;
            front = newNode;
        }
        size++;
    }

    void insertRear(int data) {
        Node newNode = Node.getNode(data);

        if (rear == null)
            front = rear = newNode;
        else {
            newNode.prev = rear;
            rear.next = newNode;
            rear = newNode;
        }

        size++;
    }

    void deleteFront() {
        if (isEmpty()) {
            System.out.println("Underflow!!!");
            return;
        }

        front = front.next;
        if (front == null)
            rear = null;
        else
            front.prev = null;

        size -= 1;
        System.out.println("Successfully deleted item from front");
    }

    void deleteRear() {
        if (isEmpty()) {
            System.out.println("Underflow!!!");
            return;
        }

        rear = rear.prev;
        if (rear == null)
            front = null;
        else
            rear.next = null;

        size -= 1;
        System.out.println("Successfully deleted item from rear");
    }

    void display() {
        if (isEmpty()) {
            System.out.println("No element present");
            return;
        }
        Node current = front;
        while ((!isEmpty()) && current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    int size()  {
        return size;
    }

    int peakFront() {
        return front.val;
    }

    int peakRear() {
        return rear.val;
    }

    public static void main(String args[]) {

        DequeueNode s = new DequeueNode();

        s.insertFront(14);
        s.insertFront(10);
        s.insertFront(12);
        s.insertRear(9);
        s.insertRear(6);

        s.display();

        // s.deleteFront();
        // s.display();
        // s.deleteRear();
        // s.display();
        System.out.println("Size of Deque is: "+s.size());

        System.out.println("Item in front is : "+ s.peakFront());
        System.out.println("Item in rear is : "+ s.peakRear());
    }

}
