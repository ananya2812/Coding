package Easy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
 * Given an integer k and a queue of integers, we need to reverse the order of the first k elements
 * of the queue, leaving the other elements in the same relative order.
 */
public class ReverseFirstKElements {

  static Queue<Integer> queue;

  static void reverseQueueFirstKElements(int k) {

    if (queue.isEmpty() || k < 0 || k > queue.size()) {
      return;
    }

    Stack<Integer> reverseStack = new Stack<>();
    for (int i = 0; i < k; i++) {
      reverseStack.push(queue.poll());
    }

    while (!reverseStack.isEmpty()) {
      queue.offer(reverseStack.pop());
    }

    for (int i = 0; i < queue.size() - k; i++) {
      queue.offer(queue.poll());
    }
  }

  static void Print() {
    while (!queue.isEmpty()) {
      System.out.print(queue.poll() + " ");
    }
  }


  public static void main(String args[]) {
    queue = new LinkedList<Integer>();
    queue.add(10);
    queue.add(20);
    queue.add(30);
    queue.add(40);
    queue.add(50);
    queue.add(60);
    queue.add(70);
    queue.add(80);
    queue.add(90);
    queue.add(100);

    int k = 5;
    reverseQueueFirstKElements(k);
    Print();
  }
}
