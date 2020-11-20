package Easy;

import java.util.Stack;

/*
 * Given a stack of integers, sort it in descending order using another temporary stack.
 */
public class SortStackUsingTemporaryStack {

  public static void main(String args[]) {
    Stack<Integer> input = new Stack<Integer>();
    input.add(34);
    input.add(3);
    input.add(31);
    input.add(98);
    input.add(92);
    input.add(23);

    // This is the temporary stack
    Stack<Integer> tmpStack = sortstack(input);
    System.out.println("Sorted numbers are:");

    while (!tmpStack.empty()) {
      System.out.print(tmpStack.pop() + " ");
    }
  }

  private static Stack<Integer> sortstack(Stack<Integer> input) {
    Stack<Integer> tempStack = new Stack<>();
    while (!input.isEmpty()) {
      Integer num = input.pop();
      while (!tempStack.isEmpty() && tempStack.peek() > num) {
        input.push(tempStack.pop());
      }
      tempStack.push(num);
    }
    return tempStack;
  }
}
