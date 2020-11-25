package Easy;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Given a Queue Data Structure. Implement Stack Data Structure using this Queue
 * 
 * Making Enqueue Costly
 */
public class StackUsingQueue {
  static Queue<Integer> q1 = new LinkedList<Integer>();
  static Queue<Integer> q2 = new LinkedList<Integer>();

  public void push(int data) {
    q2.add(data);

    while (!q1.isEmpty()) {
      q2.add(q1.peek());
      q1.remove();
    }

    Queue<Integer> q = q1;
    q1 = q2;
    q2 = q;
  }

  public void pop() {
    if (q1.isEmpty()) {
      return;
    }
    q1.remove();
  }

  public Integer top() {
    if (q1.isEmpty()) {
      return -1;
    }
    return q1.peek();
  }

  public static void main(String[] args) {
    StackUsingQueue s = new StackUsingQueue();
    s.push(1);
    s.push(2);
    s.push(3);
    System.out.println(s.top());
    s.pop();
    System.out.println(s.top());
    s.pop();
    System.out.println(s.top());
  }
}
