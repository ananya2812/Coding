package Medium;

/*
 * There are n people standing in a circle waiting to be executed. The counting out begins at some
 * point in the circle and proceeds around the circle in a fixed direction. In each step, a certain
 * number of people are skipped and the next person is executed. The elimination proceeds around the
 * circle (which is becoming smaller and smaller as the executed people are removed), until only the
 * last person remains, who is given freedom. Given the total number of persons n and a number m
 * which indicates that m-1 persons are skipped and m-th person is killed in circle. The task is to
 * choose the place in the initial circle so that you are the last one remaining and so survive.
 * 
 * Input : Length of circle : n = 4 Count to choose next : m = 2 Output : 1
 * 
 */
public class JosephCircle {

  public static void main(String args[]) {
    int n = 1, m = 3;
    getJosephusPosition(m, n);
  }

  private static void getJosephusPosition(int m, int n) {
    // Create a Circular Linked List
    Node head = new Node(1, null);
    Node prev = head;
    for (int i = 2; i <= n; i++) {
      Node newNode = new Node(i, null);
      prev.next = newNode;
      prev = newNode;
    }
    prev.next = head;

    // Delete every mth node until there is one node
    Node curr = head, prevToCurr = null;
    while (curr.next != curr) {
      int count = 1;
      while (count != m) {
        count++;
        prevToCurr = curr;
        curr = curr.next;
      }
      prevToCurr.next = curr.next;
      curr = curr.next;
    }
    System.out.println(curr.data);
  }

  static class Node {
    public int data;
    public Node next;

    Node(int data, Node next) {
      this.data = data;
      this.next = next;
    }

    Node() {}
  }
}
