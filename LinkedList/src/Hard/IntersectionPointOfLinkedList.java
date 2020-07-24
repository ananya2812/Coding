package Hard;

import Hard.LinkedList.Node;

/*
 * There are two singly linked lists in a system. By some programming error, the end node of one of
 * the linked list got linked to the second list, forming an inverted Y shaped list. Write a program
 * to get the point where two linked list merge.
 */
public class IntersectionPointOfLinkedList {

  public static void main(String[] args) {

    LinkedList list = new LinkedList();

    // creating first linked list
    list.head1 = new Node(3);
    list.head1.next = new Node(6);
    list.head1.next.next = new Node(9);
    list.head1.next.next.next = new Node(15);
    list.head1.next.next.next.next = new Node(30);

    // creating second linked list
    list.head2 = new Node(10);
    list.head2.next = new Node(15);
    list.head2.next.next = new Node(30);
    list.getNode();
  }

}


class LinkedList {

  static Node head1, head2;

  static class Node {
    int data;
    Node next;

    Node(int d) {
      data = d;
      next = null;
    }
  }

  public void printList(Node head) {
    System.out.println("Printing List");
    while (head != null) {
      System.out.println(head.data);
      head = head.next;
    }
  }

  public void getNode() {
    int count1 = getCount(head1);
    int count2 = getCount(head2);
    int d;
    if (count1 > count2) {
      d = count1 - count2;
      System.out.println("Intersection : " + getIntesectionNode(d, head1, head2));
    } else {
      d = count2 - count1;
      System.out.println("Intersection : " + getIntesectionNode(d, head2, head1));
    }
  }

  private int getIntesectionNode(int d, Node head1, Node head2) {
    for (int i = 0; i < d; i++) {
      if (head1 == null) {
        return -1;
      }
      head1 = head1.next;
    }
    while (head1 != null && head2 != null) {
      if (head1.data == head2.data) {
        return head1.data;
      }
      head1 = head1.next;
      head2 = head2.next;
    }
    return -1;
  }

  public int getCount(Node head) {
    int count = 0;
    while (head != null) {
      count++;
      head = head.next;
    }
    return count;
  }
}

