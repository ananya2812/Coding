package Basic;

import java.util.Iterator;
import java.util.PriorityQueue;

public class PriorityQueueInJava {

  public static void main(String[] args) {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    pq.add(3);
    pq.add(1);
    pq.add(10);
    pq.add(7);
    pq.add(15);

    Iterator iterator = pq.iterator();

    while (iterator.hasNext()) {
      System.out.print(iterator.next() + " ");
    }
    
    System.out.println("\nTop Element: " + pq.peek());

    // Printing the top element and removing it from the PriorityQueue container
    System.out.println("\nPrinting Top element and removing it from Queue: " + pq.poll());
    
    
    System.out.println("\nTop Element: " + pq.peek());

    pq.remove();
    
    System.out.println("\nTop Element: " + pq.peek());
  }
}
