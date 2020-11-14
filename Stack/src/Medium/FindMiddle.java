package Medium;

/*
 * How to implement a stack which will support following operations in O(1) time complexity?
 * 
 * 1)push() which adds an element to the top of stack. 2)pop() which removes an element from top of
 * stack. 3)findMiddle() which will return middle element of the stack. 4) deleteMiddle() which will
 * delete the middle element.
 * 
 * Push and pop are standard stack operations.
 * 
 */
public class FindMiddle {

  public static void main(String args[]) {
    myStack ob = new myStack(0);
    ob.push(ob, 11);
    ob.push(ob, 22);
    ob.push(ob, 33);
    ob.push(ob, 44);
    ob.push(ob, 55);
    ob.push(ob, 66);
    ob.push(ob, 77);

    System.out.println("Item popped is " + ob.pop(ob));
    System.out.println("Item popped is " + ob.pop(ob));
    System.out.println("Middle Element is " + ob.findMiddle(ob));
  }
}


class myStack {

  DLLNode head;
  DLLNode mid;
  int count;

  myStack(int count) {
    this.count = 0;
  }

  public void push(myStack ob, int newData) {
    DLLNode newNode = new DLLNode(newData);
    newNode.next = ob.head;
    if (ob.head != null) {
      ob.head.prev = newNode;
    }
    ob.count++;
    if (ob.count == 1) {
      ob.mid = newNode;
    } else {
      if (ob.count % 2 != 0) {
        ob.mid = ob.mid.prev;
      }
    }
    ob.head = newNode;
  }

  public int pop(myStack ob) {
    if (0 == ob.count) {
      System.out.println("Empty Stack");
      return -1;
    }

    int data = ob.head.data;
    ob.head = ob.head.next;
    if (ob.head != null) {
      ob.head.prev = null;
    }
    ob.count--;
    if (ob.count % 2 == 0) {
      ob.mid = ob.mid.next;
    }
    return data;
  }

  public int findMiddle(myStack ob) {
    if (ob.count == 0) {
      System.out.println("Stack is Empty");
      return -1;
    }
    return ob.mid.data;
  }

}


class DLLNode {
  int data;
  DLLNode next;
  DLLNode prev;

  DLLNode(int data) {
    this.data = data;
  }
}
