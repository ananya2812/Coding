package Hard;

import java.util.HashMap;
import java.util.Map;

/*
 * You are given a Double Link List with one pointer of each node pointing to the next node just
 * like in a single link list. The second pointer however CAN point to any node in the list and not
 * just the previous node. Now write a program to duplicate this list. That is, write a program
 * which will create a copy of this list.
 */
public class CloneLinkedListWithNextAndRandomPointer {

  public static void main(String[] args) {
    // Pushing data in the linked list.
    LinkedList list = new LinkedList(5);
    list.push(4);
    list.push(3);
    list.push(2);
    list.push(1);

    // Setting up random references.
    list.head.random = list.head.next.next;
    list.head.next.random = list.head.next.next.next;
    list.head.next.next.random = list.head.next.next.next.next;
    list.head.next.next.next.random = list.head.next.next.next.next.next;
    list.head.next.next.next.next.random = list.head.next;

    // Making a clone of the original linked list.
    LinkedList clone = list.clone();

    // Print the original and cloned linked list.
    System.out.println("Original linked list");
    list.print();
    System.out.println("\nCloned linked list");
    clone.print();
  }

}


class LinkedList {

  Node head;

  LinkedList(int data) {
    this.head = new Node(data);
  }

  public void push(int data) {
    Node newNode = new Node(data);
    newNode.next = this.head;
    this.head = newNode;
  }

  public void pushToEnd(int data) {
    Node newNode = new Node(data);
    if (this.head == null) {
      push(data);
      return;
    }
    Node curr = this.head;
    while (curr.next != null) {
      curr = curr.next;
    }
    curr.next = newNode;
  }

  void print() {
    Node currNode = this.head;
    while (currNode != null) {
      Node random = currNode.random;
      int randomData = (random != null) ? random.data : -1;
      System.out.println("Data = " + currNode.data + ", Random data = " + randomData);
      currNode = currNode.next;
    }
  }

  public LinkedList clone() {
    Node origListCurr = this.head;

    // Creating the new nodes
    while (origListCurr != null) {
      Node temp = origListCurr.next;
      origListCurr.next = new Node(origListCurr.data);
      origListCurr.next.next = temp;
      origListCurr = temp;
    }

    origListCurr = this.head;

    // Setting random of cloned List
    while (origListCurr != null) {
      if (origListCurr.random != null) {
        origListCurr.next.random = origListCurr.random.next;
      }
      origListCurr = origListCurr.next.next;
    }

    origListCurr = this.head;
    Node cloneCurr = this.head.next;
    Node cloneHead = this.head.next;

    // Restoring two lists
    while (origListCurr != null && cloneCurr != null) {
      origListCurr.next = origListCurr.next.next;
      cloneCurr.next = (cloneCurr.next != null) ? cloneCurr.next.next : cloneCurr.next;
      origListCurr = origListCurr.next;
      cloneCurr = cloneCurr.next;
    }

    return new LinkedList(cloneHead.data);

  }

  public LinkedList clone2() {
    LinkedList cloneList = new LinkedList(this.head.data);
    Node origListCurr = this.head.next;

    Map<Node, Node> origNodeRandomPtrMap = new HashMap<>();
    origNodeRandomPtrMap.put(this.head, this.head.random);

    // Creating Linked List with next link
    while (origListCurr != null) {
      cloneList.pushToEnd(origListCurr.data);
      origNodeRandomPtrMap.put(origListCurr, origListCurr.next);
      origListCurr = origListCurr.next;
    }

    Node cloneListCurr = cloneList.head;
    origListCurr = this.head;

    while (origListCurr != null) {
      Node tempNext = origListCurr.next;
      origListCurr.next = cloneListCurr;
      cloneListCurr.random = origListCurr;
      cloneListCurr = cloneListCurr.next;
      origListCurr = tempNext;
    }

    cloneListCurr = cloneList.head;
    while (cloneListCurr != null) {
      if (cloneListCurr.random.random != null) {
        cloneListCurr.random = cloneListCurr.random.random.next;
      } else {
        cloneListCurr.random = null;
      }
      cloneListCurr = cloneListCurr.next;
    }

    // Restoring Original List
    origListCurr = this.head;
    while (origListCurr != null) {
      origListCurr.next = origNodeRandomPtrMap.get(origListCurr);
      origListCurr = origListCurr.next;
    }

    return cloneList;
  }

  class Node {
    int data;
    Node next;
    Node random;

    Node(int data) {
      this.data = data;
      this.next = null;
      this.random = null;
    }
  }
}


