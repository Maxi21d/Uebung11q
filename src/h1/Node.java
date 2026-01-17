package h1;

public class Node {
    private Node next;
    public Node(Node next) {
        setNext(next);
    }

    // Setter:
    public void setNext(Node next) {
        this.next = next;
    }
    // Getter:
    public Node getNext() {
        return next;
    }

}
