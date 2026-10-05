public class Arbre<T> {

    protected static class Node<T> {

        T element;
        Node<T> left;
        Node<T> right;

        Node(T element) {
            this.element = element;
            this.left = null;
            this.right = null;
        }
    }

    private Node<T> root;

    public Arbre() {
        root = null;
    }

    public Position<T> addRoot(T element) {

        if (root != null) {
            return null;
        }

        root = new Node<>(element);

        return new Position<>(root);
    }

    public Position<T> root() {

        if (root == null) {
            return null;
        }

        return new Position<>(root);
    }

    public Position<T> addLeft(
            Position<T> parent,
            T element) {

        if (parent == null) {
            return null;
        }

        if (parent.node.left != null) {
            return null;
        }

        parent.node.left = new Node<>(element);

        return new Position<>(parent.node.left);
    }

    public Position<T> addRight(
            Position<T> parent,
            T element) {

        if (parent == null) {
            return null;
        }

        if (parent.node.right != null) {
            return null;
        }

        parent.node.right = new Node<>(element);

        return new Position<>(parent.node.right);
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

    public void inorder() {
        inorder(root);
    }

    private void inorder(Node<T> node) {

        if (node == null) {
            return;
        }

        inorder(node.left);

        System.out.print(node.element + " ");

        inorder(node.right);
    }

    public void postorder() {
        postorder(root);
    }

    private void postorder(Node<T> node) {

        if (node == null) {
            return;
        }

        postorder(node.left);
        postorder(node.right);

        System.out.print(node.element + " ");
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