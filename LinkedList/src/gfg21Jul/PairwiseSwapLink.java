package gfg21Jul;

/*
 * Pairwise swap elements of a given linked list by changing links Given a singly linked list, write
 * a function to swap elements pairwise. For example, if the linked list is 1->2->3->4->5->6->7 then
 * the function should change it to 2->1->4->3->6->5->7, and if the linked list is 1->2->3->4->5->6
 * then the function should change it to 2->1->4->3->6->5
 */
public class PairwiseSwapLink {

  static LinkedList<Integer> ll;

  public static void main(String[] args) {
    ll = new LinkedList<Integer>();
    ll.addNodes(1);
    ll.addNodes(2);
    ll.addNodes(3);
    ll.addNodes(4);
    ll.addNodes(5);
    ll.addNodes(6);
    ll.printList();
    System.out.println("Pairwise swapping of data ");
    Node<Integer> node = pairwiseSwapLink(ll.head);
    printData(node);

  }

  private static Node<Integer> pairwiseSwapLink(Node<Integer> node) {
    if (node == null || node.next == null) {
      return node;
    }

    // Initialize previous and current pointers
    Node<Integer> prev = node;
    Node<Integer> curr = node.next;

    node = curr; // Change head before proceeding

    // Traverse the list
    while (true) {
      Node<Integer> next = curr.next;
      curr.next = prev; // Change next of current as previous node

      // If next NULL or next is the last node
      if (next == null || next.next == null) {
        prev.next = next;
        break;
      }

      // Change next of previous to next next
      prev.next = next.next;

      // Update previous and curr
      prev = next;
      curr = prev.next;
    }
    return node;
  }

  private static void printData(Node<Integer> node) {
    Node<Integer> currNode = node;
    while (currNode != null) {
      System.out.println(currNode.getData());
      currNode = currNode.getNext();
    }
  }
}
