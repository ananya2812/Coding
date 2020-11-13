package Basic;

public class StackUsingArray {

  static final int MAX = 1000;
  int top;
  int a[] = new int[MAX];

  StackUsingArray() {
    top = -1;
  }

  public void push(int data) throws Exception {
    if (isFull()) {
      throw new Exception("Stack Overflow Exception");
    } else {
      a[++top] = data;
    }
  }

  public int pop() throws Exception {
    if (isEmpty()) {
      throw new Exception("Stack Underflow Exception");
    } else {
      int data = a[top];
      top--;
      return data;
    }
  }

  public int peek() throws Exception {
    if (isEmpty()) {
      throw new Exception("Stack Underflow Exception");
    } else {
      return a[top];
    }
  }

  public boolean isFull() {
    return (top >= MAX - 1);
  }

  public boolean isEmpty() {
    return (top < 0);
  }

  public static void main(String args[]) throws Exception {
    StackUsingArray s = new StackUsingArray();
    s.push(10);
    s.push(20);
    s.push(30);
    System.out.println(s.pop() + " Popped from stack");
  }
}
