public class ArbreTest {

    public static void main(String[] args) {

        Arbre<String> arbre = new Arbre<>();

        Position<String> root = arbre.addRoot("-");

        Position<String> multiplication1 =
                arbre.addLeft(root, "*");

        Position<String> addition1 =
                arbre.addLeft(multiplication1, "+");

        arbre.addLeft(addition1, "2");
        arbre.addRight(addition1, "3");

        arbre.addRight(multiplication1, "5");

        Position<String> subtraction2 =
                arbre.addRight(root, "-");

        arbre.addLeft(subtraction2, "9");

        Position<String> multiplication2 =
                arbre.addRight(subtraction2, "*");

        Position<String> addition2 =
                arbre.addLeft(multiplication2, "+");

        arbre.addRight(multiplication2, "3");

        arbre.addLeft(addition2, "1");

        Position<String> addition3 =
                arbre.addRight(addition2, "+");

        arbre.addLeft(addition3, "3");
        arbre.addRight(addition3, "4");

        System.out.println(
                "(2 + 3) * 5 - (9 - (1 + (3 + 4)) * 3)"
        );

        System.out.print("Préfixe : ");
        arbre.preorder();

        System.out.println();

        System.out.print("Infixe : ");
        arbre.inorder();

        System.out.println();

        System.out.print("Suffixe : ");
        arbre.postorder();

        System.out.println();

        System.out.println("toString : " + arbre);
    }
}