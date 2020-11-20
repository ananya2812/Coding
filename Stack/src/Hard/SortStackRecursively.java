package Hard;

import java.util.ListIterator;
import java.util.Stack;

/*
 * Given a stack, sort it using recursion.
 */
public class SortStackRecursively {

  public static void main(String[] args) {
    Stack<Integer> s = new Stack<>();
    s.push(30);
    s.push(-5);
    s.push(18);
    s.push(14);
    s.push(-3);

    System.out.println("Stack elements before sorting: ");
    printStack(s);

    sortStack(s);

    System.out.println("\nStack elements after sorting:");
    printStack(s);
  }

  static void printStack(Stack<Integer> s) {
    ListIterator<Integer> lt = s.listIterator();

    while (lt.hasNext()) {
      lt.next();
    }

    while (lt.hasPrevious()) {
      System.out.print(lt.previous() + " ");
    }
  }

  private static void sortStack(Stack<Integer> s) {
    if (!s.isEmpty()) {
      Integer temp = s.pop();
      sortStack(s);
      sortedInsert(s, temp);
    }
  }

  private static void sortedInsert(Stack<Integer> s, Integer num) {
    if (s.isEmpty() || num > s.peek()) {
      s.push(num);
      return;
    }
    Integer temp = s.pop();
    sortedInsert(s, num);
    s.push(temp);
  }
}
