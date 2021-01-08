package Easy;
/*
 * Date : 2-May-2017 Given an array, cyclically rotate the array clockwise by one.
 * 
 * Difficulty : Easy
 * 
 */
public class ArrayRotationCyclic {

  public static void main(String[] args) {
    int arr[] = {1, 2, 3, 4, 5};
    printArray(arr);
    rotateCyclic(arr);
    printArray(arr);
  }

  private static void printArray(int arr[]) {
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println("");
  }

  private static void rotateCyclic(int[] arr) {
    int temp = arr[arr.length - 1];
    int i;
    for (i = arr.length - 1; i > 0; i--) {
      arr[i] = arr[i - 1];
    }
    arr[0] = temp;
  }
}
