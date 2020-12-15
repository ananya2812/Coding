package Easy;

import java.util.LinkedList;
import java.util.*;

/*
 * Given a queue, write a function to reverse it.
 */
public class ReverseQueue {

  static Queue<Integer> queue;

  static void printQueue() {
    while (!queue.isEmpty()) {
      System.out.print(queue.peek() + " ");
      queue.remove();
    }
  }

  static Queue<Integer> reverseQueue1(Queue<Integer> q) {
    Stack<Integer> reverseStack = new Stack<>();
    while (!queue.isEmpty()) {
      reverseStack.push(queue.poll());
    }
    while (!reverseStack.isEmpty()) {
      queue.offer(reverseStack.pop());
    }
    return queue;
  }

  static Queue<Integer> reverseQueue2(Queue<Integer> q) {
    if (queue.isEmpty()) {
      return queue;
    } else {
      int data = queue.poll();
      queue = reverseQueue2(queue);
      queue.offer(data);
      return queue;
    }
  }

  public static void main(String args[]) {
    queue = new LinkedList<Integer>();
    queue.add(56);
    queue.add(27);
    queue.add(30);
    queue.add(45);
    queue.add(85);
    queue.add(92);
    queue.add(58);
    queue.add(80);
    queue.add(90);
    queue.add(100);
    queue = reverseQueue2(queue);
    printQueue();
  }
}
