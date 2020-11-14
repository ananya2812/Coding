package Hard;

import java.util.Stack;

/*
 * Design a Data Structure SpecialStack that supports all the stack operations like push(), pop(),
 * isEmpty(), isFull() and an additional operation getMin() which should return minimum element from
 * the SpecialStack. All these operations of SpecialStack must be O(1). To implement SpecialStack,
 * you should only use standard Stack data structure and no other data structure like arrays, list,
 * .. etc.
 */
public class MinElement {

  public static void main(String[] args) {
    MyStack s = new MyStack();
    s.push(3);
    s.push(5);
    s.getMin();
    s.push(2);
    s.push(1);
    s.getMin();
    s.pop();
    s.getMin();
    s.pop();
    s.peek();
  }

  static class MyStack {
    Stack<Integer> s;
    Integer minEle;

    MyStack() {
      s = new Stack<Integer>();
    }

    public void push(Integer data) {
      if (s.isEmpty()) {
        s.add(data);
        minEle = data;
        return;
      }
      if (data >= minEle) {
        s.add(data);
      } else {
        s.add(2 * data - minEle);
        minEle = data;
      }

    }

    public void pop() {
      if (s.isEmpty()) {
        System.out.println("Stack is empty");
        return;
      }
      Integer data = s.pop();
      if (data < minEle) {
        System.out.println("Popped Element: " + minEle);
        minEle = 2 * minEle - data;
      } else {
        System.out.println("Popped Element: " + data);
      }
    }

    public void getMin() {
      if (s.isEmpty()) {
        System.out.println("Stack is Empty");
        return;
      }
      System.out.println("Minimum element is " + minEle);
    }

    public void peek() {
      if (s.isEmpty()) {
        System.out.println("Stack is Empty");
        return;
      }
      System.out.println("Top element is " + s.peek());
    }

  }

}
