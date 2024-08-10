package m5k2;

import java.util.Scanner;

class Node {
    char value;
    Node left, right;

    Node(char item) {
        value = item;
        left = right = null;
    }
}

class BinaryTree {
    Node root;

    void addNode(char value) {
        root = addNodeRecursive(root, value);
    }

    Node addNodeRecursive(Node current, char value) {
        if (current == null) {
            return new Node(value);
        }

        if (value < current.value) {
            current.left = addNodeRecursive(current.left, value);
        } else if (value > current.value) {
            current.right = addNodeRecursive(current.right, value);
        }

        return current;
    }

    void preOrderTraversal(Node node) {
        if (node == null) {
            return;
        }

        System.out.print(node.value + " ");
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }

    void inOrderTraversal(Node node) {
        if (node == null) {
            return;
        }

        inOrderTraversal(node.left);
        System.out.print(node.value + " ");
        inOrderTraversal(node.right);
    }

    void postOrderTraversal(Node node) {
        if (node == null) {
            return;
        }

        postOrderTraversal(node.left);
        postOrderTraversal(node.right);
        System.out.print(node.value + " ");
    }
}

public class BinaryTreeProgram {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a combination of characters and numbers: ");
        String input = scanner.nextLine();

        for (char c : input.toCharArray()) {
            tree.addNode(c);
        }

        System.out.println("Pre-order traversal: ");
        tree.preOrderTraversal(tree.root);

        System.out.println("\nIn-order traversal: ");
        tree.inOrderTraversal(tree.root);

        System.out.println("\nPost-order traversal: ");
        tree.postOrderTraversal(tree.root);
    }
}
