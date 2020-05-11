package Basic;

import Basic.Stack.StackOverflowException;
import Basic.Stack.StackUnderflowException;

public class Main {

  public static void main(String[] args) {
    Stack<Integer> stack = new Stack<>();
    try {
      stack.push(1);
      stack.push(2);
      stack.push(3);

      System.out.println("Stack size: " + stack.getSize());
      System.out.println("Stack full?: " + stack.isFull());
      System.out.println("Stack empty?: " + stack.isEmpty());

      stack.push(4);
      System.out.println("Stack size: " + stack.getSize());
      System.out.println("Stack full?: " + stack.isFull());
      System.out.println("Stack empty?: " + stack.isEmpty());

      System.out.println("Stack peek: " + stack.peek());

      int data = stack.pop();
      System.out.println("Popped element: " + data);

      System.out.println("Peek again: " + stack.peek());
      stack.push(4);
      stack.push(5);
      stack.pop();
    } catch (StackOverflowException soe) {
      System.out.println("Stack is full! No room available.");
    } catch (StackUnderflowException sue) {
      System.out.println("Stack is empty! No elements available.");
    } catch (Exception e) {
      System.out.println("Unknown Exception Thrown");
    }
    
    System.out.println("Stack size: " + stack.getSize());

  }

}
