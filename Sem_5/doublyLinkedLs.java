public class doublyLinkedLs {
    class Node{
        int data;
        Node next;
        Node prev;

        Node(int data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    Node head, tail;

    void insertAtStart(int data){
        Node newNode = new Node(data);
        if (head == null){
            head = tail = newNode;
        }
        else{
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        System.out.println(data + " added at the start of DLL");
    }
    void insertAtEnd(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = tail = newNode;
        }
        else{
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        System.out.println(data + " added at the end");
    }

    void traverse(){
        if (head == null){
            System.out.println("List is empty");
            return; 
        }
        else{
            Node temp = head;
            while(temp != null){
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
        }
    }
    public static void main(String[] args) {
        doublyLinkedLs dll = new doublyLinkedLs();
        dll.insertAtStart(0);
        dll.insertAtEnd(2);
        dll.insertAtEnd(4);
        dll.traverse();
    }
}
