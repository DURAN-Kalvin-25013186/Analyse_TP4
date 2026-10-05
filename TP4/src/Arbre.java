public class Arbre<T> {

	private static class Node<T> {

        T element;
        Node<T> left;
        Node<T> right;

        Node(T element) {
            this.element = element;
            this.left = null;
            this.right = null;
        }

        Node(T element, Node<T> left, Node<T> right) {
            this.element = element;
            this.left = left;
            this.right = right;
        }
    }

    private Node<T> root;

    private int size;


    public Arbre() {
        root = null;
        size = 0;
    }


    public boolean isEmpty() {
        return root == null;
    }


    public int size() {
        return size;
    }


    public T root() {
        if (root == null) {
            return null;
        }

        return root.element;
    }


    public void setRoot(T element) {
        if (root == null) {
            root = new Node<>(element);
            size++;
        } else {
            root.element = element;
        }
    }


    public void addLeft(Node<T> parent, T element) {
        if (parent == null) {
            return;
        }

        if (parent.left == null) {
            parent.left = new Node<>(element);
            size++;
        }
    }


    public void addRight(Node<T> parent, T element) {
        if (parent == null) {
            return;
        }

        if (parent.right == null) {
            parent.right = new Node<>(element);
            size++;
        }
    }


    public void preorder() {
        preorder(root);
    }


    private void preorder(Node<T> node) {

        if (node == null) {
            return;
        }

        System.out.print(node.element + " ");

        preorder(node.left);

        preorder(node.right);
    }


    @Override
    public String toString() {

        StringBuilder result = new StringBuilder();

        preorderToString(root, result);

        return result.toString().trim();
    }


    private void preorderToString(
            Node<T> node,
            StringBuilder result) {

        if (node == null) {
            return;
        }

        if (result.length() > 0) {
            result.append(" ");
        }

        result.append(node.element);

        preorderToString(node.left, result);
        preorderToString(node.right, result);
    }
}