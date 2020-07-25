package Basic;

public class Traversal {

  public static void main(String[] args) {
    Node head = null;
    head = push(head, 12);
    head = push(head, 56);
    head = push(head, 2);
    head = push(head, 11);
    System.out.println("Contents of Circular " + "Linked List:");
    printList(head);
  }

  static class Node {
    Node next;
    int data;

    Node() {}

    Node(int data, Node next) {
      this.data = data;
      this.next = next;
    }
  }

  public static Node push(Node headNode, int data) {
    Node newNode = new Node(data, headNode);
    Node tempNode = headNode;
    if (null != headNode) {
      while (tempNode.next != headNode) {
        tempNode = tempNode.next;
      }
      tempNode.next = newNode;
    } else {
      newNode.next = newNode;
    }
    return newNode;
  }

  public static void printList(Node head) {
    if (head != null) {
      Node temp = head;
      do {
        System.out.println(temp.data);
        temp = temp.next;
      } while (head != temp);
    }

  }
}
