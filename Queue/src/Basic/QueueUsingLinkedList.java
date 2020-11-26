package Basic;

/*
 * Implement Queue Using LinkedList
 */
public class QueueUsingLinkedList {

  class QueueNode {
    int data;
    QueueNode next;

    QueueNode(int data) {
      this.data = data;
      this.next = null;
    }
  }

  QueueNode front = null, rear = null;

  public void enqueue(int data) {
    QueueNode newNode = new QueueNode(data);
    // Adding Node to empty List
    if (null == rear) {
      front = rear = newNode;
      return;
    }

    rear.next = newNode;
    rear = newNode;
  }

  public void dequeue() {
    // When Queue is Empty
    if (null == front) {
      return;
    }

    front = front.next;

    if (null == front) {
      rear = null;
    }
  }

  public static void main(String[] args) {
    QueueUsingLinkedList q = new QueueUsingLinkedList();
    q.enqueue(10);
    q.enqueue(20);
    q.dequeue();
    q.dequeue();
    q.enqueue(30);
    q.enqueue(40);
    q.enqueue(50);
    q.dequeue();
    System.out.println("Queue Front : " + q.front.data);
    System.out.println("Queue Rear : " + q.rear.data);
  }

}
