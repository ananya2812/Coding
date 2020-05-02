/*
 * Date : 2-May-2017 Write a function rotate(ar[], d, n) that rotates arr[] of size n by d elements.
 * 
 * Difficulty : Easy
 * 
 */
public class ArrayRotation3 {

  public static void main(String[] args) {
    int arr[] = {1, 2, 3, 4, 5, 6, 7};
    printArray(arr);
    rotate(arr, 2);
    printArray(arr);
  }

  private static void printArray(int arr[]) {
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println("");
  }

  private static void rotate(int arr[], int d) {
    printArray(arr);
    reverseArr(arr, 0, d - 1);
    printArray(arr);
    reverseArr(arr, d, arr.length - 1);
    printArray(arr);
    reverseArr(arr, 0, arr.length - 1);
  }

  private static void reverseArr(int arr[], int start, int end) {
    int temp;
    for (int i = start, j = end; i < j; i++, j--) {
      temp = arr[i];
      arr[i] = arr[j];
      arr[j] = temp;
    }

  }

}
