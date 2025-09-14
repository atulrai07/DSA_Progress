class Node {
    int val;
    Node next;
    Node(int val) {
        this.val = val;
        this.next = null;
    }
}

public class LinkedListMiddle {
    public Node middleNode(Node head) {
        // Step 1: find length
        int length = 0;
        Node temp = head;
        while (temp != null) {
            length++;
            temp = temp.next;
        }

        // Step 2: find middle index
        int middleIndex = (length / 2); // (length/2) already gives the second middle in even case

        // Step 3: move head to middleIndex
        temp = head;
        for (int i = 0; i < middleIndex; i++) {
            temp = temp.next;
        }

        return temp; // return middle node
    }

        public static void main(String[] args) {
        // Create a linked list: 1->2->3->4->5
        LinkedListMiddle solution = new LinkedListMiddle();
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        // Find middle node
        Node middle = solution.middleNode(head);
        System.out.println("Middle node value: " + middle.val);

        // Test with even number of nodes: 1->2->3->4->5->6
        head.next.next.next.next.next = new Node(6);
        middle = solution.middleNode(head);
        System.out.println("Middle node value (even case): " + middle.val);
    }
}
