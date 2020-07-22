package gfg21Jul;

/*
 * Given a singly linked list, write a function to swap elements pairwise Input :
 * 1->2->3->4->5->6->NULL Output : 2->1->4->3->6->5->NULL
 * 
 * Input : 1->2->3->4->5->NULL Output : 2->1->4->3->5->NULL
 * 
 * Input : 1->NULL Output : 1->NULL
 */
public class PairwiseSwapData {

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
    pairwiseSwapData();
  }

  private static void pairwiseSwapData() {
    Node<Integer> temp = ll.head;
    while (temp != null && temp.next != null) {
      Integer data = temp.getData();
      temp.setData(temp.next.getData());
      temp.next.setData(data);
      temp = temp.next.next;
    }
    ll.printList();
  }
}
