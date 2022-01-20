package low;

public class BST {

    class Node {
        Integer data;
        Node left, right;

        Node(Integer data) {
            this.data = data;
            left = right = null;
        }
    }

    Node root;

    public void add(Integer value) {
        root = addNode(root, value);
    }

    private Node addNode(Node current, Integer value) {
        // If node is empty, create a new node and return
        if (current == null)
            return new Node(value);

        // If root is there, check where it needs to be put and call recursive method
        if (current.data > value)
            current.left = addNode(current.left, value);
        else if (current.data < value)
            current.right = addNode(current.right, value);
        else
            // If value is already present
            return current;

        return current;
    }

    public void inOrder() {
        inOrder(root);
        System.out.println();
    }

    private void inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }
    }

    public void preOrder() {
        preOrder(root);
        System.out.println();
    }

    private void preOrder(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public void postOrder(){
        postOrder(root);
        System.out.println();
    }

    private void postOrder(Node root) {
        if(root != null){
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data + " ");
        }
    }

    public static void main(String[] args) {
        BST tree = new BST();

        tree.add(10);
        tree.add(9);
        tree.add(8);
        tree.add(6);
        tree.add(15);
        tree.add(5);
        tree.add(7);

        tree.inOrder();

        tree.preOrder();

        tree.postOrder();

    }

}
