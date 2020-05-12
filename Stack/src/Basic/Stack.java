package Basic;

public class Stack<T> {

  private static int MAX_SIZE = 40;
  private Element<T> top;
  private int size = 0;

  public void push(T data) throws StackOverflowException {
    if (size == MAX_SIZE) {
      throw new StackOverflowException();
    }
    Element<T> newData = new Element<T>(data, top);
    top = newData;
    size++;
  }

  public T pop() throws StackUnderflowException {
    if (size == 0) {
      throw new StackUnderflowException();
    }
    T topData = top.getData();
    top = top.getNext();
    size--;
    return topData;
  }

  public T peek() throws StackUnderflowException {
    if (size == 0) {
      throw new StackUnderflowException();
    }
    return top.getData();
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public boolean isFull() {
    return size == MAX_SIZE;
  }

  public int getSize() {
    return size;
  }
  
  public class Element<T> {
    private T data;
    private Element<T> next;

    public T getData() {
      return data;
    }

    public void setData(T data) {
      this.data = data;
    }

    public Element<T> getNext() {
      return next;
    }

    public void setNext(Element<T> next) {
      this.next = next;
    }

    public Element(T data, Element<T> next) {
      super();
      this.data = data;
      this.next = next;
    }

  }

  public static class StackOverflowException extends Exception {

  }

  public static class StackUnderflowException extends Exception {

  }

}
