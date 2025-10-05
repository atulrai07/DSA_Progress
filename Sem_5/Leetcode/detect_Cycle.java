import java.util.HashMap;

public class detect_Cycle {
    Node head;
    static class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static Boolean findCycle(Node head){
        Node temp = head;
        HashMap<Node,Boolean> visited = new HashMap<>();
        while (temp != null) {
            if(visited.containsKey(temp)){
                return true;
            }
            else{
                visited.put(temp,true);
                temp = temp.next;
            }
            
        }
        return false;
    }

    public static void main(String[] args){
        Node head = new Node(3);
        head.next = new Node(2);
        head.next.next = new Node(0);
        head.next.next.next = new Node(-4);

        System.out.print(findCycle(head));
    }
}
