package Easy;

import java.util.LinkedHashSet;
import java.util.Set;

/*
 * First In First Out (FIFO) page replacement algorithm
 */
public class FIFO {

  public static void main(String args[]) {
    int pages[] = {7, 0, 1, 2, 0, 3, 0, 4, 2, 3, 0, 3, 2};
    int capacity = 4;
    System.out.println(pageFaults(pages, pages.length, capacity));
  }

  static int pageFaults(int pages[], int n, int capacity) {
    Set<Integer> queue = new LinkedHashSet<>();
    int pageFault = 0;
    for (int i = 0; i < n; i++) {
      // When there is still space in Queue for adding new element
      if (queue.size() < capacity) {
        queue.add(pages[i]);
        pageFault++;
      } else {
        if (!queue.contains(pages[i])) {
          queue.remove(queue.iterator().next());
          pageFault++;
          queue.add(pages[i]);
        }
      }
    }
    return pageFault;
  }
}
