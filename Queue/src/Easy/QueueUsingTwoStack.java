package Easy;

import java.util.Stack;
import Basic.Queue.QueueOverflowException;
import Basic.Queue.QueueUnderflowException;

public class QueueUsingTwoStack<T> {

  public static void main(String[] args) throws QueueOverflowException, QueueUnderflowException {
    QueueUsingTwoStack<Integer> queue = new QueueUsingTwoStack<Integer>();

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


    int data = queue.dequeue();
    System.out.println("Dequeued element: " + data);


    data = queue.dequeue();
    System.out.println("Dequeued element: " + data);

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

  public Stack<T> forwardStack = new Stack<T>();
  public Stack<T> reverseStack = new Stack<T>();

  QueueUsingTwoStack() {

  }

  public void enqueue(T data) throws QueueOverflowException {
    if (isFull()) {
      throw new QueueOverflowException();
    }
    try {
      if (forwardStack.isEmpty()) {
        while (!reverseStack.isEmpty()) {
          forwardStack.push(reverseStack.pop());
        }
      }
      forwardStack.push(data);
    } catch (Exception e) {
      throw new QueueOverflowException();
    }
  }

  public T dequeue() throws QueueUnderflowException {
    if (isEmpty()) {
      throw new QueueUnderflowException();
    }
    try {
      if (reverseStack.isEmpty()) {
        while (!forwardStack.isEmpty()) {
          reverseStack.push(forwardStack.pop());
        }
      }
      return reverseStack.pop();
    } catch (Exception e) {
      throw new QueueUnderflowException();
    }
  }

  public Boolean isFull() {
    return (forwardStack.size() == forwardStack.capacity())
        || (reverseStack.size() == reverseStack.capacity());
  }

  public Boolean isEmpty() {
    return forwardStack.isEmpty() && reverseStack.isEmpty();
  }
}
