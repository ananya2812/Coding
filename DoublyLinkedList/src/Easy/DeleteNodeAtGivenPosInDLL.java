package Easy;

public class DeleteNodeAtGivenPosInDLL {

  static Node head = null;

  public static void main(String[] args) {
    push(2);
    push(5);
    push(4);
    push(8);
    push(10);

    System.out.println("Doubly linked list before deletion:");
    printList();

    int n = 1;

    // delete node at the given position 'n'
    deleteNodeAtGivenPos(n);
    System.out.println("Doubly linked list after deletion:");
    printList();
  }

  static void deleteNodeAtGivenPos(int n) {
    /* if list in NULL or invalid position is given */
    if (head == null || n <= 0) {
      return;
    }

    // Removing 1st node
    if (n == 1) {
      head = head.next;
      head.prev = null;
      return;
    }
    int pos = 2;
    Node currNode = head.next;
    while (null != currNode && pos != n) {
      pos++;
      currNode = currNode.next;
    }

    // Position not found
    if (null == currNode) {
      return;
    }

    currNode.prev.next = currNode.next;
    if (currNode.next != null) {
      currNode.next.prev = currNode.prev;
    }

  }

  static void push(int data) {
    Node new_node = new Node(data);
    new_node.next = head;
    if (head != null) {
      head.prev = new_node;
    }
    head = new_node;
  }

  static void printList() {
    if (head == null)
      System.out.print("Doubly Linked list empty");

    Node currNode = head;
    while (currNode != null) {
      System.out.print(currNode.data + " ");
      currNode = currNode.next;
    }
    System.out.println();
  }
}


