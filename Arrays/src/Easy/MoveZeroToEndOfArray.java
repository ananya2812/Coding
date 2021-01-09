package Easy;

/*
 * Given an array of random numbers, Push all the zero’s of a given array to the end of the array.
 * For example, if the given arrays is {1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0}, it should be changed to
 * {1, 9, 8, 4, 2, 7, 6, 0, 0, 0, 0}. The order of all other elements should be same. Expected time
 * complexity is O(n) and extra space is O(1).
 */
public class MoveZeroToEndOfArray {

  public static void main(String[] args) {
    int arr[] = {1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0};
    int n = arr.length;
    pushZerosToEnd(arr, n);
    System.out.println("Array after pushing zeros to the back: ");
    for (int i = 0; i < n; i++)
      System.out.print(arr[i] + " ");
  }

  private static void pushZerosToEnd(int[] arr, int n) {
    int count = 0;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] != 0) {
        swapElement(arr, i, count);
        count++;
      }
    }
  }

  private static void swapElement(int[] arr, int a, int b) {
    int temp = arr[a];
    arr[a] = arr[b];
    arr[b] = temp;
  }
}
