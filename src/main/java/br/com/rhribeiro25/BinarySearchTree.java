package br.com.rhribeiro25;
/**
 * Represents a Binary Search Tree (BST) with insertion and in-order traversal functionalities.
 */
public class BinarySearchTree {
    static class Node {
        int value;
        Node left, right;

        Node(int value) {
            this.value = value;
            left = right = null;
        }
    }

    private Node root;

    /**
     * Inserts a value into the binary search tree.
     *
     * @param value the value to insert
     */
    public void insert(int value) {
        root = insertRecursively(root, value);
    }

    private Node insertRecursively(Node node, int value) {
        if (node == null) {
            return new Node(value);
        }
        if (value < node.value) {
            node.left = insertRecursively(node.left, value);
        } else if (value > node.value) {
            node.right = insertRecursively(node.right, value);
        }
        return node;
    }

    /**
     * Performs an in-order traversal of the tree (Left, Root, Right).
     * Prints the tree's values in ascending order.
     */
    public void inOrderTraversal() {
        inOrderRecursively(root);
    }

    private void inOrderRecursively(Node node) {
        if (node != null) {
            inOrderRecursively(node.left);
            System.out.print(node.value + " ");
            inOrderRecursively(node.right);
        }
    }
    public static void main(String[] args) {
        // Binary Search Tree Example
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);
        bst.insert(60);
        bst.insert(80);

        System.out.println("In-order traversal of Binary Search Tree:");
        bst.inOrderTraversal();
    }
}

/*
 * Problem: Binary Search Tree (BST)
 *
 * A Binary Search Tree (BST) is a data structure in which each node has at most two children,
 * referred to as the left and right child. For every node:
 * - The left child’s value is less than the parent node's value.
 * - The right child’s value is greater than the parent node's value.
 *
 * The key property of a BST is that it allows for efficient searching, insertion, and deletion of nodes.
 *
 * **Operations**:
 * 1. **Insertion**: Insert a node into the BST. The new node should be placed such that the tree maintains its BST property.
 * 2. **Searching**: Search for a value in the BST. This can be done efficiently by leveraging the BST property, starting from the root and navigating left or right as needed.
 * 3. **Deletion**: Delete a node from the BST. Deletion can be more complex, as it depends on whether the node has 0, 1, or 2 children.
 *
 * **Time Complexity**:
 * - **Search**: O(h), where h is the height of the tree. In the best case, the tree is balanced, so the height is O(log n). In the worst case, the tree is skewed, so the height can be O(n).
 * - **Insertion**: O(h) because, like search, we may need to traverse down to the leaf level to insert the new node.
 * - **Deletion**: O(h) because we may need to adjust the tree structure when deleting a node with children.
 *
 * **Space Complexity**:
 * - The space complexity is O(n) for storing n nodes in the tree.
 *
 * Example:
 * Consider the following sequence of node insertions: [50, 30, 20, 40, 70, 60, 80]
 * The resulting BST would look like this:
 *          50
 *        /    \
 *      30      70
 *     /  \    /  \
 *    20  40  60   80
 *
 * In this tree, 50 is the root, 30 and 70 are its children, and so on.
 *
 * Time complexity for search, insertion, and deletion is O(h), where h is the height of the tree.
 *
 * **Use Cases**:
 * - Binary Search Trees are used in searching algorithms, databases, and various applications where efficient search, insertion, and deletion operations are required.
 */

