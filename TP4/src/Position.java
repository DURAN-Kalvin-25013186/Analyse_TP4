public class Position<T> {

    protected Arbre.Node<T> node;

    protected Position(Arbre.Node<T> node) {
        this.node = node;
    }

    public T element() {
        return node.element;
    }
}
