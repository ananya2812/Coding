package Medium;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
 * Given a Queue consisting of first n natural numbers (in random order). The task is to check
 * whether the given Queue elements can be arranged in increasing order in another Queue using a
 * stack. The operation allowed are: 1. Push and pop elements from the stack 2. Pop (Or enqueue)
 * from the given Queue. 3. Push (Or Dequeue) in the another Queue.
 */
public class SortQueueUsingStack {

  // Driver Code
  public static void main(String args[]) {
    queue.add(5);
    queue.add(1);
    queue.add(2);
    queue.add(3);
    queue.add(4);

    int n = queue.size();

    if (checkSorted(n))
      System.out.print("Yes");
    else
      System.out.print("No");
  }


  static Queue<Integer> queue = new LinkedList<Integer>();

  static boolean checkSorted(int n) {
    int expected = 1;
    Stack<Integer> stack = new Stack<>();

    while (!queue.isEmpty()) {
      int front = queue.poll();
      if (expected == front) {
        expected++;
      } else {
        if (stack.isEmpty()) {
          stack.push(front);
        } else if (!stack.isEmpty() && front > stack.peek()) {
          return false;
        } else {
          stack.push(front);
        }
      }
      while (!stack.isEmpty() && expected == stack.peek()) {
        stack.pop();
        expected++;
      }
    }
    if (stack.isEmpty() && expected - 1 == n) {
      return true;
    }
    return false;
  }


}
