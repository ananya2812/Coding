package Easy;

/*
 * Find the smallest and second smallest elements in an array
 */
public class SmallestAndSecondSmallestElement {

  public static void main(String[] args) {
    int arr[] = {12, 13, 1, 10, 34, 1};
    print2Smallest(arr);
  }

  private static void print2Smallest(int[] arr) {
    int smallest = Integer.MAX_VALUE, secSmallest = Integer.MAX_VALUE;

    for (int i = 0; i < arr.length; i++) {
      if (arr[i] < smallest) {
        secSmallest = smallest;
        smallest = arr[i];
      } else if (arr[i] < secSmallest && arr[i] != smallest) {
        secSmallest = arr[i];
      }
    }

    System.out
        .println("Smallest Element: " + smallest + " Second Smallest Element: " + secSmallest);
  }
}
