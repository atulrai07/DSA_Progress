import java.util.*;

// Huffman Tree Node
class Node implements Comparable<Node> {
    char ch;
    int freq;
    Node left, right;

    Node(char ch, int freq) {
        this.ch = ch;
        this.freq = freq;
    }

    Node(char ch, int freq, Node left, Node right) {
        this.ch = ch;
        this.freq = freq;
        this.left = left;
        this.right = right;
    }

    public int compareTo(Node other) {
        return this.freq - other.freq;
    }

    // Check if the node is a leaf
    public boolean isLeaf() {
        return this.left == null && this.right == null;
    }
}

public class HuffmanCoding {

    // Function to build the Huffman Tree and print codes
    public static void buildHuffmanTree(char[] chars, int[] freqs) {
        PriorityQueue<Node> pq = new PriorityQueue<>();

        // Step 1: Create leaf nodes for each character
        for (int i = 0; i < chars.length; i++) {
            pq.offer(new Node(chars[i], freqs[i]));
        }

        // Step 2: Build the Huffman Tree
        while (pq.size() > 1) {
            Node left = pq.poll();
            Node right = pq.poll();
            Node merged = new Node('-', left.freq + right.freq, left, right);
            pq.offer(merged);
        }

        // Root of the tree
        Node root = pq.poll();

        // Step 3: Traverse and print Huffman Codes
        System.out.println("Character\tFrequency\tHuffman Code");
        printCodes(root, "");
    }

    // Recursive function to print codes
    private static void printCodes(Node node, String code) {
        if (node == null) return;

        if (node.isLeaf()) {
            System.out.println(node.ch + "\t\t" + node.freq + "\t\t" + code);
            return;
        }

        printCodes(node.left, code + "0");
        printCodes(node.right, code + "1");
    }

    // Driver Code
    public static void main(String[] args) {
        char[] characters = { 'a', 'b', 'c', 'd', 'e', 'f' };
        int[] frequencies = { 5, 9, 12, 13, 16, 45 };

        buildHuffmanTree(characters, frequencies);
    }
}
