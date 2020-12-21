
public class LinearSearch {

  public static void main(String[] args) {
    int[] list = {1, 10, 9, 3, 2, 5};
    int searchIndex = search(list, 99);
    System.out.println((searchIndex == -1) ? "No Result" : searchIndex);
  }

  private static int search(int[] list, int num) {
    for (int i = 0; i < list.length; i++) {
      if (list[i] == num) {
        return i;
      }
    }
    return -1;
  }
}
