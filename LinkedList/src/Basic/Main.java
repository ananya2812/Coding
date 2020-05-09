package Basic;

public class Main {

  public static void main(String[] args) {
    LinkedList<Integer> n = new LinkedList<Integer>();
    n.addNodes(2);
    n.addNodes(4);
    n.printNodes();
    n.deleteLinkedList();
    n.printNodes();
  }
}
