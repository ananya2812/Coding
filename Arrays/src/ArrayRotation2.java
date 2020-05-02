/*
 * Date : 2-May-2017 Write a function rotate(ar[], d, n) that rotates arr[] of size n by d elements.
 * 
 * Difficulty : Easy
 * 
 */
public class ArrayRotation2 {

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
    int temp[] = new int[d];
    for (int i = 0; i < d; i++) {
      temp[i] = arr[i];
    }
    int j;
    for (j = 0; j < arr.length - d; j++) {
      arr[j] = arr[j + d];
    }
    System.out.println(j);
    for (int i = 0; i < d; i++) {
      arr[j] = temp[i];
      j++;
    }
  }

}
