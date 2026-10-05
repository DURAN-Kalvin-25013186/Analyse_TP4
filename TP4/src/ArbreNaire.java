import java.util.ArrayList;
import java.util.List;

public class ArbreNaire<T> {

    private static class Node<T> {

        T element;

        List<Node<T>> children;

        Node(T element) {
            this.element = element;
            this.children = new ArrayList<>();
        }
    }

    private Node<T> root;

    private int size;


    public ArbreNaire() {
        root = null;
        size = 0;
    }


    public void setRoot(T element) {

        if (root == null) {
            root = new Node<>(element);
            size++;
        } else {
            root.element = element;
        }
    }


    public void addChild(T element) {

        if (root == null) {
            return;
        }

        root.children.add(new Node<>(element));
        size++;
    }


    public void addChild(
            String parentElement,
            T element) {

        Node<T> parent = findNode(root, parentElement);

        if (parent != null) {
            parent.children.add(new Node<>(element));
            size++;
        }
    }


    private Node<T> findNode(
            Node<T> node,
            String parentElement) {

        if (node == null) {
            return null;
        }

        if (node.element.equals(parentElement)) {
            return node;
        }

        for (Node<T> child : node.children) {

            Node<T> result =
                    findNode(child, parentElement);

            if (result != null) {
                return result;
            }
        }

        return null;
    }


    public void preorder() {
        preorder(root);
    }


    private void preorder(Node<T> node) {

        if (node == null) {
            return;
        }

        System.out.print(node.element + " ");

        for (Node<T> child : node.children) {
            preorder(child);
        }
    }


    @Override
    public String toString() {

        StringBuilder result =
                new StringBuilder();

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

        for (Node<T> child : node.children) {
            preorderToString(child, result);
        }
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
}