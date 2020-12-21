
public class BinarySearch {

  public static void main(String[] args) {
    int[] list = {11, 22, 33, 44, 55, 66, 77, 88, 99, 110};
    int searchIndex = search(list, 101);
    System.out.println((searchIndex == -1) ? "No Result" : searchIndex);
  }

  private static int search(int[] list, int num) {
    int min = 0;
    int max = list.length - 1;
    while (min <= max) {
      int mid = min + (max - min) / 2;
      if (list[mid] == num) {
        return mid;
      }
      if (list[mid] > num) {
        max = mid - 1;
      } else {
        min = mid + 1;
      }
    }
    return -1;
  }

}
