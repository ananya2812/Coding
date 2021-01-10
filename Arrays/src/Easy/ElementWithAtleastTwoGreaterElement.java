package Easy;

/*
 * Given an array of n distinct elements, the task is to find all elements in array which have
 * at-least two greater elements than themselves.
 */
public class ElementWithAtleastTwoGreaterElement {

  public static void main(String args[]) {
    int arr[] = {2, -6, 3, 5, 1};
    int n = arr.length;
    findElements(arr, n);
  }

  private static void findElements(int[] arr, int arrLength) {

    int maxElement = arr[0];
    int secMaxElement = Integer.MIN_VALUE;

    for (int i = 1; i < arrLength; i++) {
      if (arr[i] > maxElement) {
        secMaxElement = maxElement;
        maxElement = arr[i];
      } else if (arr[i] > secMaxElement) {
        secMaxElement = arr[i];
      }
    }

    for (int i = 0; i < arrLength; i++) {
      if (arr[i] < secMaxElement) {
        System.out.print(arr[i] + ",");
      }
    }
  }
}
