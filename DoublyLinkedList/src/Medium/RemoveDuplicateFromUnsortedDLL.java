package Medium;

import java.util.HashSet;
import java.util.Set;

/*
 * Remove duplicates from an unsorted doubly linked list
 * 
 * Given an unsorted doubly linked list containing n nodes. The problem is to remove duplicate nodes
 * from the given list.
 */
public class RemoveDuplicateFromUnsortedDLL {

  public static void main(String args[]) {
    Node head = null;

    head = push(head, 12);
    head = push(head, 12);
    head = push(head, 10);
    head = push(head, 4);
    head = push(head, 8);
    head = push(head, 4);
    head = push(head, 6);
    head = push(head, 4);
    head = push(head, 4);
    head = push(head, 8);

    System.out.print("Original Doubly linked list:\n");
    printList(head);

    /* remove duplicate nodes */
    head = removeDuplicates(head);

    System.out.print("\nDoubly linked list after" + " removing duplicates:\n");
    printList(head);
  }

  static Node removeDuplicates(Node head) {
    if (null == head || null == head.next) {
      return head;
    }
    Node currNode = head;
    Set<Integer> dataSet = new HashSet<>();
    while (currNode != null) {
      if (dataSet.contains(currNode.data)) {
        currNode.prev.next = currNode.next;
        if (currNode.next != null) {
          currNode.next.prev = currNode.prev;
        }
      } else {
        dataSet.add(currNode.data);
      }
      currNode = currNode.next;
    }
    return head;
  }

  static Node push(Node head_ref, int data) {
    Node newNode = new Node(data);
    newNode.next = (head_ref);
    if ((head_ref) != null) {
      (head_ref).prev = newNode;
    }
    (head_ref) = newNode;
    return head_ref;
  }


  static void printList(Node head) {
    if (head == null) {
      System.out.print("Doubly Linked list empty");
    }
    while (head != null) {
      System.out.print(head.data + " ");
      head = head.next;
    }
  }

  static class Node {
    int data;
    Node next, prev;

    Node(int data) {
      this.data = data;
      this.next = null;
      this.prev = null;
    }
  }
}
