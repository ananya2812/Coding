package Easy;

/*
 * Given an array (or string), the task is to reverse the array/string.
 */
public class ReverseArray {

  public static void main(String args[]) {
    int arr[] = {1, 2, 3, 4, 5};
    printArray(arr);
    reverseArray(arr, 0, 4);
    System.out.print("Reversed array is \n");
    printArray(arr);
  }

  private static void printArray(int[] arr) {
    System.out.println("Printing Array: ");
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + ",");
    }
  }

  private static void reverseArray(int[] arr, int start, int end) {
    while (start <= end) {
      int temp = arr[start];
      arr[start] = arr[end];
      arr[end] = temp;
      start++;
      end--;
    }
  }
}
