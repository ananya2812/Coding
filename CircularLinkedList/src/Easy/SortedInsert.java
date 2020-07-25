package Easy;

/*
 * Write a function to insert a new value in a sorted Circular Linked List (CLL)
 */
public class SortedInsert {

  public static void main(String[] args) {
    LinkedList list = new LinkedList();
    int arr[] = new int[] {12, 56, 2, 11, 1, 90};
    Node temp = null;

    for (int i = 0; i < 6; i++) {
      temp = new Node(arr[i]);
      list.sortedInsert(temp);
    }

    list.printList();
  }

  static class Node {
    int data;
    Node next;

    Node(int d) {
      data = d;
      next = null;
    }
  }

  static class LinkedList {
    Node head;

    LinkedList() {
      head = null;
    }

    void printList() {
      if (head != null) {
        Node temp = head;
        do {
          System.out.print(temp.data + " ");
          temp = temp.next;
        } while (temp != head);
      }
    }

    void sortedInsert(Node newNode) {
      Node currNode = head;
      // List is empty
      if (null == currNode) {
        newNode.next = newNode;
        head = newNode;
        return;
      } // New Node is to be inserted at beginning
      else if (currNode.data > newNode.data) {
        while (currNode.next != head) {
          currNode = currNode.next;
        }
        currNode.next = newNode;
        newNode.next = head;
        head = newNode;
        return;
      } // New Node is to be inserted after some node
      else {
        while (currNode.next != head && newNode.data > currNode.next.data) {
          currNode = currNode.next;
        }
        newNode.next = currNode.next;
        currNode.next = newNode;
      }
    }
  }
}
