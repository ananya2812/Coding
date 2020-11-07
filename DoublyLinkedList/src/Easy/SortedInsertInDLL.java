package Easy;

/*
 * Given a sorted doubly linked list and a value to insert, write a function to insert the value in
 * sorted way.
 */
public class SortedInsertInDLL {

  public static void main(String args[]) {
    /* start with the empty doubly linked list */
    Node head = null;

    // insert the following nodes in sorted way
    Node new_node = new Node(8);
    head = sortedInsert(head, new_node);
    new_node = new Node(5);
    head = sortedInsert(head, new_node);
    new_node = new Node(3);
    head = sortedInsert(head, new_node);
    new_node = new Node(10);
    head = sortedInsert(head, new_node);
    new_node = new Node(12);
    head = sortedInsert(head, new_node);
    new_node = new Node(9);
    head = sortedInsert(head, new_node);

    System.out.println("Created Doubly Linked List");
    printList(head);
  }

  static void printList(Node head) {
    while (head != null) {
      System.out.print(head.data + " ");
      head = head.next;
    }
  }

  // a sorted doubly linked list
  static Node sortedInsert(Node head, Node newNode) {
    // Insert in Empty List
    if (null == head) {
      newNode.prev = newNode;
      return newNode;
    }

    // Insertion at Beginning
    if (head.data > newNode.data) {
      newNode.next = head;
      head.prev = newNode;
      return newNode;
    }

    // Insert at any other Position
    Node currNode = head;
    while (currNode.next != null && currNode.next.data < newNode.data) {
      currNode = currNode.next;
    }

    newNode.next = currNode.next;
    if (null != currNode.next) {
      currNode.next.prev = newNode;
    }
    currNode.next = newNode;
    newNode.prev = currNode;
    return head;
  }
}


// Node of a doubly linked list
class Node {
  int data;
  Node next, prev;

  Node(int data) {
    this.data = data;
    this.next = null;
    this.prev = null;
  }
}

