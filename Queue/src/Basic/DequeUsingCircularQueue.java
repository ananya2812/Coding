package Basic;

public class DequeUsingCircularQueue {

  int arr[];
  int size;
  int front;
  int rear;

  DequeUsingCircularQueue(int size) {
    this.size = size;
    arr = new int[size];
    front = -1;
    rear = 0;
  }

  private boolean isEmpty() {
    return (front == -1);
  }

  private boolean isFull() {
    return ((front == 0 && rear == size - 1) || (rear + 1 == front));
  }

  private void insertrear(int data) {
    if (isFull()) {
      System.out.println("Queue is Full");
      return;
    }
    // Queue is Empty
    if (front == -1) {
      front = 0;
      rear = 0;
    } else if (rear == size - 1) {
      rear = 0;
    } else {
      rear++;
    }
    arr[rear] = data;
  }

  private void insertfront(int data) {
    if (isFull()) {
      System.out.println("Queue is Full");
      return;
    }
    // Queue is Empty
    if (front == -1) {
      front = 0;
      rear = 0;
    } else if (front == 0) {
      front = size - 1;
    } else {
      front--;
    }
    arr[front] = data;
  }

  private void deleterear() {
    if (isEmpty()) {
      System.out.println("Queue is Empty");
      return;
    }
    // Only 1 element
    if (front == rear) {
      front = -1;
      rear = -1;
    } else if (rear == 0) {
      rear = size - 1;
    } else {
      rear--;
    }
  }

  private void deletefront() {
    if (isEmpty()) {
      System.out.println("Queue is Empty");
      return;
    }
    // Only 1 element
    if (front == rear) {
      front = -1;
      rear = -1;
    } else if (front == size - 1) {
      front = 0;
    } else {
      front++;
    }
  }

  private int getRear() {
    return arr[rear];
  }

  private int getFront() {
    return arr[front];
  }

  public static void main(String[] args) {

    DequeUsingCircularQueue dq = new DequeUsingCircularQueue(5);

    System.out.println("Insert element at rear end  : 5 ");
    dq.insertrear(5);

    System.out.println("insert element at rear end : 10 ");
    dq.insertrear(10);

    System.out.println("get rear element : " + dq.getRear());

    dq.deleterear();
    System.out.println("After delete rear element new rear become : " + dq.getRear());

    System.out.println("inserting element at front end : 15");
    dq.insertfront(15);

    System.out.println("get front element: " + dq.getFront());

    dq.deletefront();

    System.out.println("After delete front element new front become : " + +dq.getFront());

  }
}

