package gfg14May;

/*
 * Given a Linked List and a number n, write a function that returns the value at the n’th node from
 * the end of the Linked List. For example, if the input is A->B->C->D below list and n = 3, then
 * output is “B”
 */
public class NNodeFromEnd2 {

  public static void main(String[] args) {
    LinkedList<Integer> ll = new LinkedList<Integer>();
    ll.addNodes(20);
    ll.addNodes(4);
    ll.addNodes(15);
    ll.addNodes(35);
    getNNodeFromEnd(ll.getHead(), 4);
  }

  public static void getNNodeFromEnd(Node<Integer> head, int n) {
    Node<Integer> main_ptr = head;
    Node<Integer> ref_ptr = head;

    int count = 0;
    if (head != null) {
      while (count < n) { 
        if (ref_ptr == null) {
          System.out.println(n + " is greater than the no " + " of nodes in the list");
          return;
        }
        ref_ptr = ref_ptr.next;
        count++;
      }
      System.out.println(ref_ptr.getData());
      while (ref_ptr != null) {
        main_ptr = main_ptr.next;
        ref_ptr = ref_ptr.next;
      }
      System.out.println("Node no. " + n + " from last is " + main_ptr.data);
    }
  }

}
