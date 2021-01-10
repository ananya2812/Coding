package Hard;

import java.util.Arrays;

/*
 * Given a sorted array of positive integers, rearrange the array alternately i.e first element
 * should be maximum value, second minimum value, third second max, fourth second min and so on.
 */
public class RearrangeArrayMaximumMinimumForm {

  public static void main(String[] args) {
    int arr[] = new int[] {1, 2, 3, 4, 5, 6};

    System.out.println("Original Array ");
    System.out.println(Arrays.toString(arr));

    rearrangeOptimal(arr, arr.length);

    System.out.println("Modified Array ");
    System.out.println(Arrays.toString(arr));
  }

  private static void rearrange(int[] arr, int arrLength) {
    int minIndex = 0, maxIndex = arrLength - 1;
    int[] tempArr = arr.clone();
    for (int i = 0; i < arrLength; i++) {
      if (i % 2 == 0) {
        arr[i] = tempArr[maxIndex];
        maxIndex--;
      } else {
        arr[i] = tempArr[minIndex];
        minIndex++;
      }
    }
  }

  private static void rearrangeOptimal(int[] arr, int arrLength) {
    int minIndex = 0;
    int maxIndex = arrLength - 1;
    int maxElement = arr[maxIndex] + 1;

    for (int i = 0; i < arrLength; i++) {
      if (i % 2 == 0) {
        arr[i] = arr[i] + (arr[maxIndex] % maxElement) * maxElement;
        maxIndex--;
      } else {
        arr[i] = arr[i] + (arr[minIndex] % maxElement) * maxElement;
        minIndex++;
      }
    }

    for (int i = 0; i < arrLength; i++) {
      arr[i] = arr[i] / maxElement;
    }
  }
}
