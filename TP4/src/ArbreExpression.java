public class ArbreExpression {

    private static class Node {

        String element;
        Node left; 		
        Node right;

        Node(String element) {
            this.element = element;
        }

        Node(String element, Node left, Node right) {
            this.element = element;
            this.left = left;
            this.right = right;
        }
    }

    private Node root;


    public ArbreExpression() {

        Node five = new Node("5");
        Node two = new Node("2");
        Node eight = new Node("8");

        Node plus = new Node("+", five, two);

        root = new Node("*", plus, eight);
    }


    public void preorder() {
        preorder(root);
    }


    private void preorder(Node node) {

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
            Node node,
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