import java.util.LinkedList;
import java.util.Queue;

class StackUsingQueues {
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    // Push operation — add element onto stack
    void push(int data) {
        // Step 1: Add element to q2
        q2.add(data);
        System.out.println("Pushed: " + data);

        // Step 2: Move all elements from q1 → q2
        while (!q1.isEmpty()) {
            q2.add(q1.remove());
        }

        // Step 3: Swap q1 and q2
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }

    // Pop operation — remove top element
    void pop() {
        if (q1.isEmpty()) {
            System.out.println("Stack is empty!");
            return;
        }
        int removed = q1.remove();
        System.out.println("Popped: " + removed);
    }

    // Peek operation — view top element
    void peek() {
        if (q1.isEmpty()) {
            System.out.println("Stack is empty!");
            return;
        }
        System.out.println("Top element: " + q1.peek());
    }

    // Display stack elements
    void display() {
        if (q1.isEmpty()) {
            System.out.println("Stack is empty!");
            return;
        }

        System.out.println("Stack elements (Top → Bottom):");
        for (int x : q1) {
            System.out.println(x);
        }
    }
}

// Main class to test the stack
public class main {
    public static void main(String[] args) {
        StackUsingQueues stack = new StackUsingQueues();

        // Push elements
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);

        stack.display();

        // Peek top
        stack.peek();

        // Pop elements
        stack.pop();
        stack.pop();

        stack.display();

        stack.peek();
    }
}
