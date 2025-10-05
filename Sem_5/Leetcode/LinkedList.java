package Leetcode;
class LinkedList {

    Node head;

    static class Node {
        int data;
        Node next;
        
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Function to delete the kth node
    public static void deleteKthNode(int k, Node head) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        // If head is to be deleted
        if (k == 1) {
            head = head.next;
            return;
        }

        Node temp = head;
        int count = 1;

        // Traverse until kth node
        while (temp != null && count < k-1) {
            temp = temp.next;
            count++;
        }

        // If k is greater than number of nodes
        if (temp == null) {
            System.out.println("Position exceeds list length.");
            return;
        }

        // Delete kth node using prev and next
        temp.next = temp.next.next;
    }


    // Print the linked list
    public static void printList(Node head) {
        Node tnode = head;
        while (tnode != null) {
            System.out.print(tnode.data + " ");
            tnode = tnode.next;
        }
        System.out.println();
    }

    // Driver code
    public static void main(String[] args) {
        // Create linked list: {1,2,3,4,5,6}
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);

        System.out.println("Original List:");
        printList(head);
        
        int k = 2;
        deleteKthNode(k,head);
        
        System.out.println("After deleting " + k + "-th node from end:");
        printList(head);
    }
}
