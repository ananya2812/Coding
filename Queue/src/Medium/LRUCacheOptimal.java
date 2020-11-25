package Medium;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Set;

public class LRUCacheOptimal {

  Set<Integer> cache;
  int cacheSize;

  LRUCacheOptimal(int cacheSize) {
    cache = new LinkedHashSet<>(cacheSize);
    this.cacheSize = cacheSize;
  }

  public void get(Integer data) {
    if (!cache.contains(data)) {
      if (cache.size() == cacheSize) {
        cache.remove(cache.iterator().next());
      }
    } else {
      cache.remove(data);
    }
    cache.add(data);
  }

  public void display() {
    LinkedList<Integer> list = new LinkedList<>(cache);
    Iterator<Integer> itr = list.descendingIterator();

    while (itr.hasNext()) {
      System.out.print(itr.next() + " ");
    }
  }

  public static void main(String[] args) {
    LRUCacheOptimal ca = new LRUCacheOptimal(4);
    ca.get(1);
    ca.get(2);
    ca.get(3);
    ca.get(1);
    ca.get(4);
    ca.get(5);
    ca.display();
  }
}
