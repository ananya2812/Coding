package Medium;

import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

/*
 * Implement a LRU Cache
 */
public class LRUCache {

  private Deque<Integer> doublyQueue;
  private HashSet<Integer> hashSet;

  private int cacheSize;

  public LRUCache(int cacheSize) {
    this.doublyQueue = new LinkedList<Integer>();
    this.hashSet = new HashSet<Integer>();
    this.cacheSize = cacheSize;
  }

  public void get(int data) {
    if (!hashSet.contains(data)) {
      if (doublyQueue.size() == cacheSize) {
        Integer removedData = doublyQueue.removeLast();
        hashSet.remove(removedData);
      }
    } else {
      doublyQueue.remove(data);
    }
    doublyQueue.push(data);
    hashSet.add(data);
  }

  public void display() {
    Iterator<Integer> it = doublyQueue.iterator();
    while (it.hasNext()) {
      System.out.println(it.next() + " ");
    }
  }

  public static void main(String[] args) {
    LRUCache cache = new LRUCache(4);
    cache.get(1);
    cache.get(2);
    cache.get(3);
    cache.get(1);
    cache.get(4);
    cache.get(5);
    cache.get(2);
    cache.get(2);
    cache.get(1);
    cache.display();
  }

}
