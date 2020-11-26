package Easy;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Implement stack using only given queue data structure.
 */
public class StackUsingSingleStack {

  Queue<Integer> queue;

  StackUsingSingleStack() {
    this.queue = new LinkedList<Integer>();
  }

  public void push(int data) {
    int sizeBeforeInsert = queue.size();
    queue.add(data);
    for (int i = 0; i < sizeBeforeInsert; i++) {
      queue.add(queue.remove());
    }
  }

  public void pop() {
    if (queue.isEmpty()) {
      System.out.println("Queue is Empty");
      return;
    }
    queue.remove();
  }

  public Integer top() {
    if (queue.isEmpty()) {
      System.out.println("Queue is Empty");
      return -1;
    }
    return queue.peek();
  }

  public static void main(String[] args) {
    StackUsingSingleStack s = new StackUsingSingleStack();
    s.push(10);
    s.push(20);
    System.out.println("Top element :" + s.top());
    s.pop();
    s.push(30);
    s.pop();
    System.out.println("Top element :" + s.top());
  }
}


