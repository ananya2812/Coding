package Easy;

import java.util.Stack;

public class QueueUsingStack {

  static class Queue {

    Stack<Integer> stack1;
    Stack<Integer> stack2;
  }

  static void push(Stack<Integer> top, int data) {
    top.push(data);
  }

  public static void enQueue(Queue q, int data) {
    push(q.stack1, data);
  }

  public static int deQueue(Queue q) {

    if (q.stack1.isEmpty() && q.stack2.isEmpty()) {
      System.out.println("Q is empty");
      return -1;
    }

    if (q.stack2.isEmpty()) {
      while (!q.stack1.isEmpty()) {
        q.stack2.push(q.stack1.pop());
      }
    }
    return q.stack2.pop();
  }

  public static void main(String args[]) {
    /* Create a queue with items 1 2 3 */
    Queue q = new Queue();
    q.stack1 = new Stack<>();
    q.stack2 = new Stack<>();
    enQueue(q, 1);
    enQueue(q, 2);
    enQueue(q, 3);

    /* Dequeue items */
    System.out.print(deQueue(q) + " ");
    System.out.print(deQueue(q) + " ");
    System.out.println(deQueue(q) + " ");
  }
}
