import java.io.*;
class LinkedList {
    Node head; 
    class Node {
        int data;
        Node next;
        Node(int d) {
            data = d;
            next = null;
        }
    }
    Node getKthFromEnd(int k) {
        Node slow = head;
        Node fast = head;
        for (int i = 0; i < k; ++i) {
            if (fast == null) {
                System.out.println("has less than k nodes.");
                return null;
            }
            fast = fast.next;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public void push(int new_data) {
        Node new_node = new Node(new_data);
        new_node.next = head;
        head = new_node;
    }

    // Main code
    public static void main(String[] args) {
        LinkedList llist = new LinkedList();
        llist.push(20);
        llist.push(4);
        llist.push(15);
        llist.push(35);
        Node kth = llist.getKthFromEnd(3);
        if (kth != null) {
            System.out.println("Kth node from end is: " + kth.data);
        }
    }
}
