package Easy;

/*
 * Given two Binary Trees, write a function that returns true if two trees are mirror of each other,
 * else false.
 */
public class CheckIfTwoTreeAreMirror {

  public static void main(String[] args) {
    Node<Integer> a = new Node<>(1);
    Node<Integer> b = new Node<>(1);
    a.left = new Node<>(2);
    a.right = new Node<>(3);
    a.left.left = new Node<>(4);
    a.left.right = new Node<>(5);

    b.left = new Node<>(3);
    b.right = new Node<>(2);
    b.right.left = new Node<>(5);
    b.right.right = new Node<>(4);

    if (areMirror(a, b)) {
      System.out.println("Yes");
    } else {
      System.out.println("No");
    }

  }

  private static Boolean areMirror(Node<Integer> a, Node<Integer> b) {
    if (a == null && b == null) {
      return true;
    }
    if (a == null || b == null) {
      return false;
    }

    return (a.data == b.data) && areMirror(a.left, b.right) && areMirror(a.right, b.left);
  }
}
