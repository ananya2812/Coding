package Easy;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Given a Queue Data Structure. Implement Stack Data Structure using this Queue
 * 
 * Making Dequeue Costly
 */
public class StackUsingQueue2 {

  static Queue<Integer> q1 = new LinkedList<Integer>();
  static Queue<Integer> q2 = new LinkedList<Integer>();
  int size;

  StackUsingQueue2() {
    size = 0;
  }

  public void push(Integer data) {
    q1.add(data);
    size++;
  }

  public void pop() {
    if (q1.isEmpty()) {
      return;
    }
    while (q1.size() != 1) {
      q2.add(q1.remove());
    }

    q1.remove();
    size--;

    Queue<Integer> q = q1;
    q1 = q2;
    q2 = q;
  }

  public Integer top() {
    if (q1.isEmpty()) {
      return -1;
    }
    while (q1.size() != 1) {
      q2.add(q1.remove());
    }

    int temp = q1.peek();
    q1.remove();
    q2.add(temp);

    Queue<Integer> q = q1;
    q1 = q2;
    q2 = q;

    return temp;
  }

  public static void main(String[] args) {
    StackUsingQueue2 s = new StackUsingQueue2();
    s.push(1);
    s.push(2);
    s.push(3);
    s.push(4);

    System.out.println(s.top());
     s.pop();
     System.out.println(s.top());
     s.pop();
     System.out.println(s.top());
  }
}


