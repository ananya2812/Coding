package Easy;

/*
 * Given a singly linked list, we have to convert it into circular linked list.
 */
public class ConvertSingleToCircular {

  public static void main(String args[]) {
    Node head = null;

    // Using push() function to
    // convert singly linked list
    // 17.22.13.14.15
    head = push(head, 15);
    head = push(head, 14);
    head = push(head, 13);
    head = push(head, 22);
    head = push(head, 17);
    System.out.print("Display Single list: \n");
    printSingleList(head);

    circular(head);
    System.out.print("Display list: \n");
    displayList(head);
  }

  static class Node {
    int data;
    Node next;

    Node(int data, Node next) {
      this.data = data;
      this.next = next;
    }

    Node() {}
  }

  private static Node push(Node head, int data) {
    if (null == head) {
      return new Node(data, head);
    } else {
      Node newNode = new Node(data, null);
      Node temp = head;
      while (temp.next != null) {
        temp = temp.next;
      }
      temp.next = newNode;
      return head;
    }
  }

  private static void circular(Node head) {
    Node temp = head;
    while (temp.next != null) {
      temp = temp.next;
    }
    temp.next = head;
  }

  private static void displayList(Node head) {
    Node temp = head;
    do {
      System.out.println(temp.data);
      temp = temp.next;
    } while (temp != head);
  }

  private static void printSingleList(Node head) {
    Node temp = head;
    while (temp != null) {
      System.out.println(temp.data);
      temp = temp.next;
    }
  }
}
