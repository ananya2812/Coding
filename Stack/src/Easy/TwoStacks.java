package Easy;

/*
 * Create a data structure twoStacks that represents two stacks. Implementation of twoStacks should
 * use only one array, i.e., both stacks should use the same array for storing elements. Following
 * functions must be supported by twoStacks. push1(int x) –> pushes x to first stack push2(int x) –>
 * pushes x to second stack
 * 
 * pop1() –> pops an element from first stack and return the popped element pop2() –> pops an
 * element from second stack and return the popped element
 * 
 * Implementation of twoStack should be space efficient.
 */
public class TwoStacks {

  int size;
  int a[];
  int top1, top2;

  TwoStacks(int size) {
    this.size = size;
    a = new int[size];
    top1 = -1;
    top2 = size;
  }

  public void push1(int data) {
    if (isFull()) {
      System.out.println("Stack Overflow");
      return;
    }
    a[++top1] = data;
  }

  public void push2(int data) {
    if (isFull()) {
      System.out.println("Stack Overflow");
      return;
    }
    a[--top2] = data;
  }

  public int pop1() {
    if (isEmpty()) {
      System.out.println("Stack Underflow");
      return -1;
    }
    int data = a[top1];
    top1--;
    return data;
  }
  
  public int pop2() {
    if (isEmpty()) {
      System.out.println("Stack Underflow");
      return -1;
    }
    int data = a[top2];
    top2++;
    return data;
  }

  public boolean isFull() {
    if (top1 == size || top2 == 0 || top1 + 1 == top2) {
      return true;
    } else {
      return false;
    }
  }

  public boolean isEmpty() {
    if (top1 <= -1 || top2 >= size) {
      return true;
    } else {
      return false;
    }
  }

  public static void main(String args[]) {
    TwoStacks ts = new TwoStacks(5);
    ts.push1(5);
    ts.push2(10);
    ts.push2(15);
    ts.push1(11);
    ts.push2(7);
    System.out.println("Popped element from" + " stack1 is " + ts.pop1());
    ts.push2(40);
    System.out.println("Popped element from" + " stack2 is " + ts.pop2());
  }
}
