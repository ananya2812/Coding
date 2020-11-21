package Basic;

public class CircularQueue {

  private int size, front, rear;

  private int queue[];

  CircularQueue(int size) {
    this.size = size;
    queue = new int[size];
    front = rear = -1;
  }

  public void enQueue(int data) {
    if (isFull()) {
      System.out.println("Queue is Full");
      return;
    }
    // Empty Queue
    if (front == -1) {
      front = 0;
      rear = 0;
    } else if (rear == size - 1) {
      rear = 0;
    } else {
      rear++;
    }
    queue[rear] = data;
  }

  public int deQueue() {
    if (isEmpty()) {
      System.out.println("Queue is Empty");
      return -1;
    }
    int deletedNum = queue[front];
    // Only 1 element
    if (front == rear) {
      front = -1;
      rear = -1;
    } else if (front == size - 1) {
      front = 0;
    } else {
      front++;
    }
    return deletedNum;
  }

  public boolean isFull() {
    return ((front == rear + 1) || (front == 0 && rear == size - 1));
  }

  public boolean isEmpty() {
    return (front == -1);
  }

  public void displayQueue() {

    if (isEmpty()) {
      System.out.print("Queue is Empty");
      return;
    }

    // When rear is greater then front.
    System.out.print("Elements in the " + "circular queue are: ");

    if (rear >= front) {
      for (int i = front; i <= rear; i++) {
        System.out.print(queue[i] + " ");
      }
      System.out.println();
    }

    // If Front is greater than rear
    else {
      for (int i = front; i < size; i++) {
        System.out.print(queue[i] + " ");
      }

      for (int i = 0; i <= rear; i++) {
        System.out.print(queue[i] + " ");
      }
      System.out.println();
    }
  }

  public static void main(String[] args) {
    CircularQueue q = new CircularQueue(5);

    q.enQueue(14);
    q.enQueue(22);
    q.enQueue(13);
    q.enQueue(-6);

    q.displayQueue();

    int x = q.deQueue();

    if (x != -1) {
      System.out.print("Deleted value = ");
      System.out.println(x);
    }

    x = q.deQueue();

    if (x != -1) {
      System.out.print("Deleted value = ");
      System.out.println(x);
    }

    q.displayQueue();

    q.enQueue(9);
    q.enQueue(20);
    q.enQueue(5);

    q.displayQueue();

    q.enQueue(20);
  }
}
