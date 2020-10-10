package Basic;

import java.lang.reflect.Array;

public class Queue<T> {

  private static final Integer SPECIAL_EMPTY_VALUE = -1;
  private static int MAX_SIZE = 40;

  private int headIndex = SPECIAL_EMPTY_VALUE;
  private int tailIndex = SPECIAL_EMPTY_VALUE;
  private T[] elements;

  public static void main(String[] args) throws QueueOverflowException, QueueUnderflowException {
    MAX_SIZE = 4;
    Queue<Integer> queue = new Queue<>(Integer.class);

    System.out.println("Queue full?: " + queue.isFull());
    System.out.println("Queue empty?: " + queue.isEmpty());

    queue.enqueue(1);
    queue.enqueue(2);
    queue.enqueue(3);

    System.out.println("Queue full?: " + queue.isFull());
    System.out.println("Queue empty?: " + queue.isEmpty());

    queue.enqueue(4);
    System.out.println("Queue full?: " + queue.isFull());
    System.out.println("Queue empty?: " + queue.isEmpty());

    System.out.println("Queue peek: " + queue.peek());

    int data = queue.dequeue();
    System.out.println("Dequeued element: " + data);

    System.out.println("Peek : " + queue.peek());

    data = queue.dequeue();
    System.out.println("Dequeued element: " + data);
    System.out.println("Peek : " + queue.peek());

    try {
      queue.enqueue(4);
      queue.enqueue(5);
      queue.enqueue(6);
    } catch (QueueOverflowException soe) {
      System.out.println("Queue is full! No room available.");
    }

    try {
      queue.dequeue();
      queue.dequeue();
      queue.dequeue();
      queue.dequeue();
      queue.dequeue();
      queue.dequeue();
    } catch (QueueUnderflowException sue) {
      System.out.println("Queue is empty! No elements available.");
    }
  }

  public Queue(Class<T> clazz, int size) {
    this.elements = (T[]) Array.newInstance(clazz, size);
  }

  public Queue(Class<T> clazz) {
    this(clazz, MAX_SIZE);
  }

  public void enqueue(T data) throws QueueOverflowException {
    if (isFull()) {
      return;
    }
    tailIndex = (tailIndex + 1) % elements.length;
    elements[tailIndex] = data;
    // When list was initially empty
    if (headIndex == SPECIAL_EMPTY_VALUE) {
      headIndex = tailIndex;
    }
  }

  public boolean offer(T data) {
    if (isFull()) {
      return false;
    }
    try {
      enqueue(data);
    } catch (QueueOverflowException qoe) {
      // Ignore, this should never happen, we've checked
      // for a full queue already.
    }

    return true;
  }

  public T dequeue() throws QueueUnderflowException {
    if (isEmpty()) {
      throw new QueueUnderflowException();
    }
    T data = elements[headIndex];
    // Only 1 element
    if (headIndex == tailIndex) {
      headIndex = SPECIAL_EMPTY_VALUE;
    } else {
      headIndex = (headIndex + 1) % elements.length;
    }
    return data;
  }

  public T peek() throws QueueUnderflowException {
    if (isEmpty()) {
      throw new QueueUnderflowException();
    }
    return elements[headIndex];
  }

  public boolean isEmpty() {
    return (headIndex == SPECIAL_EMPTY_VALUE);
  }

  public boolean isFull() {
    int nextIndex = (tailIndex + 1) % elements.length;
    return (headIndex == nextIndex);
  }

  public static class QueueOverflowException extends Exception {

  }

  public static class QueueUnderflowException extends Exception {

  }
}
