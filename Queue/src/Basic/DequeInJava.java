package Basic;

import java.util.ArrayDeque;
import java.util.Deque;

public class DequeInJava {

  public static void main(String[] args) {
    Deque<String> deque = new ArrayDeque<>();

    deque.add("Element 1 (Tail)");
    deque.addFirst("Element 2 (Head)");
    deque.addLast("Element 3 (Tail)");
    deque.push("Element 4 (Head)");
    // Add at the last
    deque.offer("Element 5 (Tail)");
    // Add at the first
    deque.offerFirst("Element 6 (Head)");

    System.out.println(deque + "\n");

    deque.removeFirst();
    deque.removeLast();
    System.out.println("Deque after removing " + "first and last: " + deque);
  }
}
