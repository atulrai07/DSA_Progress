import java.util.Stack;

public class checkPallindromeLL_Stack {
    Node head;
    static class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static Boolean checkPallindrome(Node head){
        if(head == null || head.next == null){
            return true;
        }
        Node temp = head;
        Stack <Integer> stack = new Stack<>();
        while(temp != null){
            stack.push(temp.data);
            temp = temp.next;
        }
        temp = head;
        while(temp != null){
            if (temp.data != stack.peek()){
                return false;
            }
            stack.pop();
            temp =temp.next;
        }
        return true;
    }

    public static void main(String[] args){
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(2);
        head.next.next.next = new Node(1);

        System.out.print(checkPallindrome(head));
    }
}
