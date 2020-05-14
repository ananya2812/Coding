package gfg14May;

/*
 * Given a Linked List and a number n, write a function that returns the value at the n’th node from
 * the end of the Linked List. For example, if the input is A->B->C->D below list and n = 3, then
 * output is “B”
 */
public class NNodeFromEnd {

  public static void main(String[] args) {
    LinkedList<Integer> ll = new LinkedList<Integer>();
    ll.addNodes(20);
    ll.addNodes(4);
    ll.addNodes(15);
    ll.addNodes(35);
    int result = getNNodeFromEnd(ll.getHead(), 4);
    System.out.println(result);
  }

  public static Integer getNNodeFromEnd(Node<Integer> head, int N) {
    Node<Integer> temp = head;
    int numOfNodes = countNodes(head);
    if (numOfNodes < N) {
      return 0;
    }
    int pos = numOfNodes - N + 1;
    int currIndex = 1;
    while (temp != null) {
      if (currIndex == pos) {
        return temp.getData();
      }
      temp = temp.getNext();
      currIndex++;
    }
    return 0;
  }

  public static int countNodes(Node<Integer> curr) {
    Node<Integer> temp = curr;
    int count = 0;
    while (temp != null) {
      temp = temp.getNext();
      count++;
    }
    return count;
  }
}
