package Basic;

/*
 * Given a singly linked list and a key, count number of occurrences of given key in linked list.
 * For example, if given linked list is 1->2->1->2->1->3->1 and given key is 1, then output should
 * be 4.
 */
public class CountOfIntInLinkedList {

  public static void main(String[] args) {
    LinkedList<Integer> ll = new LinkedList<Integer>();
    ll.addNodes(20);
    ll.addNodes(4);
    ll.addNodes(20);
    ll.addNodes(20);
    ll.addNodes(135);
    countOfInt(ll.getHead(), 10);
  }

  private static void countOfInt(Node<Integer> ll, int n) {
    Node<Integer> temp = ll;
    int count = 0;
    while (temp != null) {
      if (temp.getData() == n) {
        count++;
      }
      temp = temp.getNext();
    }
    System.out.println("Count of " + n + " in Linked List = " + count);
  }

}
