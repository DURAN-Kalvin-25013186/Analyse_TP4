public class ArbreTest {

    public static void main(String[] args) {


        System.out.println("===== ARBRE BINAIRE =====");

        Arbre<Integer> arbre = new Arbre<>();

        arbre.setRoot(10);

        System.out.println("Root : " + arbre.root());
        System.out.println("Size : " + arbre.size());
        System.out.println("Empty : " + arbre.isEmpty());

        System.out.println();


        System.out.println("===== EXPRESSION ARITHMETIQUE =====");

        ArbreExpression expression =
                new ArbreExpression();

        System.out.println("Expression : ((5 + 2) * 8)");

        System.out.print("Parcours préfixe : ");
        expression.preorder();

        System.out.println();

        System.out.println("toString : " + expression);

        System.out.println();

        System.out.println("===== ARBRE N-AIRE =====");

        ArbreNaire<String> arbreNAire =
                new ArbreNaire<>();

        arbreNAire.setRoot("A");

        System.out.println("Root : "
                + arbreNAire.root());

        System.out.println("Size : "
                + arbreNAire.size());

        System.out.println();
    }
}