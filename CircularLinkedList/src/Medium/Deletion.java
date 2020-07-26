package Medium;

public class Deletion {

  static class Node {
    int data;
    Node next;

    Node(int data, Node next) {
      this.data = data;
      this.next = next;
    }

    Node() {}
  };

  static Node push(Node head, int data) {
    Node newNode = new Node(data, head);
    if (head != null) {
      Node temp = head;
      while (temp.next != head) {
        temp = temp.next;
      }
      temp.next = newNode;
    } else {
      newNode.next = newNode;
    }
    head = newNode;
    return head;
  }

  static void printList(Node head) {
    Node temp = head;
    if (head != null) {
      do {
        System.out.printf("%d ", temp.data);
        temp = temp.next;
      } while (temp != head);
    }

    System.out.printf("\n");
  }


  static Node deleteNode(Node head, int key) {
    // Case: List is empty
    if (head == null) {
      return null;
    }

    // Case: Only 1 node and the key is present
    if (head.next == head && head.data == key) {
      head = null;
      return head;
    }

    // Find the required node
    Node curr = head, prev = null;
    while (curr.data != key) {
      // Case: Node Not found
      if (curr.next == head) {
        System.out.println("Given node is not found" + " in the list!!!");
        return head;
      }
      prev = curr;
      curr = curr.next;
    }

    // Case: Delete head node
    if (curr == head) {
      prev = head;
      while (prev.next != head) {
        prev = prev.next;
      }
      head = curr.next;
      prev.next = curr.next;
    }

    // Case: Delete any other node
    else {
      prev.next = curr.next;
    }
    return head;
  }

  public static void main(String args[]) {
    Node head = null;
    head = push(head, 2);
    head = push(head, 5);
    head = push(head, 7);
    head = push(head, 8);
    head = push(head, 10);

    System.out.printf("List Before Deletion: ");
    printList(head);
    head = deleteNode(head, 10);

    System.out.printf("List After Deletion: ");
    printList(head);
  }
}


