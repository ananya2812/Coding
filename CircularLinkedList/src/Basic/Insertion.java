package Basic;

/*
 * A node can be added in three ways:
 * 
 * Insertion in an empty list , Insertion at the beginning of the list, Insertion at the end of the
 * list, Insertion in between the nodes
 */
public class Insertion {

  public static void main(String[] args) {
    Node last = null;

    last = addToEmpty(last, 6);
    last = addToEmpty(last, 6);
    last = addBegin(last, 4);
    last = addBegin(last, 2);
    last = addEnd(last, 8);
    last = addEnd(last, 12);
    last = addAfter(last, 10, 8);

    traverse(last);
  }

  static Node addAfter(Node last, int data, int item) {
    if (null == last) {
      return null;
    }
    Node p = last.next;
    do {
      if (p.data == item) {
        Node newNode = new Node(data, p.next);
        p.next = newNode;
        if (p == last) {
          last = newNode;
        }
      }
      p = p.next;
    } while (p != last.next);
    return last;

  }

  private static Node addToEmpty(Node last, int data) {
    if (null != last) {
      return last;
    } else {
      Node T = new Node(data, last);
      T.next = T;
      return T;
    }
  }

  private static Node addBegin(Node last, int data) {
    if (last == null) {
      return addToEmpty(last, data);
    }
    Node T = new Node(data, last.next);
    last.next = T;
    return last;
  }

  static Node addEnd(Node last, int data) {
    if (last == null) {
      return addToEmpty(last, data);
    }
    Node T = new Node(data, last.next);
    last.next = T;
    last = T;
    return last;
  }

  static void traverse(Node last) {
    if (null != last) {
      Node temp = last.next;
      do {
        System.out.println(temp.data);
        temp = temp.next;
      } while (temp != last.next);
    } else {
      System.out.println("List is empty.");
      return;
    }
  }

  static class Node {
    int data;
    Node next;

    Node() {}

    Node(int data, Node next) {
      this.data = data;
      this.next = next;
    }
  }
}
