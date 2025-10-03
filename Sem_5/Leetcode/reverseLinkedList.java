public class reverseLinkedList {
    Node head;

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node reverse(Node head) {
        Node curr = head;
        Node nxt = null; // Initialize nxt to null
        Node prev = null;

        while (curr != null) {
            nxt = curr.next; // Save the next node
            curr.next = prev; // Reverse the link
            prev = curr; // Move prev to current
            curr = nxt; // Move curr to next
        }

        return prev; // Return the new head
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        // Reverse the linked list and update the head
        head = reverse(head);

        // Print the reversed linked list
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }
}