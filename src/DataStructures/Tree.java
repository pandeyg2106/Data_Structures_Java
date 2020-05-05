package DataStructures;

public class Tree {

    private class Node {
        private int value;
        private Node leftChild;
        private Node rightChild;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node = " + value;
        }
    }

    private Node root;

    public void insert(int value) {
        //Declaring a new node to add.
        var newNode = new Node(value);
        if (root == null) {
            root = new Node(value);
            return;
        }
        var current = root;
        while (true) {
            if (value < current.value) {
                if (current.leftChild == null) {
                    current.leftChild = newNode;
                    break;
                }
                current = current.leftChild;
            } else {
                if (current.rightChild == null) {
                    current.rightChild = newNode;
                    break;
                }
                current = current.rightChild;
            }
        }
    }

    public boolean find(int value) {
        var current = root;
        while (current != null) {
            if (value < current.value)
                current = current.leftChild;
            else if (value > current.value)
                current = current.rightChild;
            else
                return true;
        }
        return false;
    }

    public void traversePreOrder() {
        traversePreOrder(root);
    }

    private void traversePreOrder(Node root) {
        //Root -> Left -> Right
        if (root == null)     //This is the base condition.
            return;
        System.out.println(root.value);
        traversePreOrder(root.leftChild);
        traversePreOrder(root.rightChild);
    }

    public void traverseInOrder() {
        traverseInorder(root);
    }

    private void traverseInorder(Node root) {
        //Left -> Root -> Right
        if (root == null)
            return;
        traverseInorder(root.leftChild);
        System.out.println(root.value);
        traverseInorder(root.rightChild);
    }

    public void traversePostOrder() {
        traversePostOrder(root);
    }

    private void traversePostOrder(Node root) {
        //Left -> Right -> Node
        if (root == null)
            return;
        traversePostOrder(root.leftChild);
        traversePostOrder(root.rightChild);
        System.out.println(root.value);
    }

    public int height() {
        return height(root);
    }

    private int height(Node root) {
        if (root == null)
            return -1;
        if (root.leftChild == null && root.rightChild == null)
            return 0;
        return 1 + Math.max(height(root.leftChild), height(root.rightChild));
    }

    public int minimumValue() {
        if (root == null)
            throw new IllegalStateException();
        var current = root;
        var last = current;
        while (current != null) {
            last = current;
            current = current.leftChild;
        }
        return last.value;
    }

    private int minimumValue(Node root) {
        if (root.leftChild == null && root.rightChild == null)
            return root.value;
        int left = minimumValue(root.leftChild);
        var right = minimumValue(root.rightChild);

        return Math.min(left, right);
    }

    public boolean equals(Tree other) {
        if (other == null)
            return false;
        return equals(root, other.root);
    }

    private boolean equals(Node first, Node second) {
        if (first == null && second == null)
            return true;
        if (first != null && second != null) {
            return first.value == second.value
                    && equals(first.leftChild, second.leftChild)
                    && equals(first.rightChild, second.rightChild);
        }
        return false;
    }

    public boolean isBinarySearchTree() {
        return isBinarySearchTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBinarySearchTree(Node root, int min, int max) {
        if (root == null)
            return true;
        if (root.value < min || root.value > max)
            return false;

        return isBinarySearchTree(root.leftChild, min, root.value - 1)
                && isBinarySearchTree(root.rightChild, root.value + 1, max);
    }

    public void printNodesAtDistance(int distance) {
        printNodesAtDistance(root, distance);
    }

    private void printNodesAtDistance(Node root, int distance) {
        if (root == null)
            return;
        if (distance == 0) {
            System.out.println(root.value);
            return;
        }
        printNodesAtDistance(root.leftChild, distance - 1);
        printNodesAtDistance(root.rightChild, distance - 1);
    }

    public int getSize() {
        return getSize(root);
    }

    private int getSize(Node root) {
        if (root == null)
            return 0;
        if (root.leftChild == null && root.rightChild == null)
            return 1;
        return 1 + getSize(root.leftChild) + getSize(root.rightChild);
    }

    public int countLeaves() {
        return countLeaves(root);
    }

    private int countLeaves(Node root) {
        if (root == null)
            return 0;
        if (root.leftChild == null && root.rightChild == null)
            return 1;
        return countLeaves(root.leftChild) + countLeaves(root.rightChild);
    }

    public int max() {
        if (root == null) {
            throw new IllegalStateException();
        }
        return max(root);
    }

    private int max(Node root) {
        if (root.rightChild == null)
            return root.value;
        return max(root.rightChild);
    }

    public boolean contains(int value) {
        return contains(root, value);
    }

    private boolean contains(Node root, int value) {
        if (root == null)
            return false;
        if (root.value == value)
            return true;
        return contains(root.leftChild, value) || contains(root.rightChild, value);
    }

    public boolean areSiblings(int a, int b){
        return areSiblings(root, a, b);
    }
    private boolean areSiblings(Node root, int a, int b) {
        if (root == null)
            return false;
        var result = false;
        if (root.leftChild != null || root.rightChild != null) {
            result = (root.leftChild.value == a && root.rightChild.value == b) ||
                    (root.leftChild.value == b && root.rightChild.value == a);
        }
        return result || areSiblings(root.leftChild, a, b) || areSiblings(root.rightChild, a, b);
    }
}
