package Medium;

/*
 * An array contains both positive and negative numbers in random order. Rearrange the array
 * elements so that positive and negative numbers are placed alternatively. Number of positive and
 * negative numbers need not be equal. If there are more positive numbers they appear at the end of
 * the array. If there are more negative numbers, they too appear in the end of the array.
 * 
 * For example, if the input array is [-1, 2, -3, 4, 5, 6, -7, 8, 9], then the output should be [9,
 * -7, 8, -3, 5, -1, 2, 4, 6]
 */
public class RearrangePositiveAndNegativeNumber {

  public static void main(String[] args) {
    int arr[] = {-1, 2, -3, 4, 5, 6, -7, 8, 9};
    int n = arr.length;
    rearrange(arr, n);
    System.out.println("Array after rearranging: ");
    printArray(arr, n);
  }

  public static void rearrange(int arr[], int n) {

    // Partitioning Negative and Positive Numbers
    int negCount = -1;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] < 0) {
        negCount++;
        swap(arr, i, negCount);
      }
    }

    // Rearranging the Array
    int neg = 0, pos = negCount + 1;
    while (neg < pos && pos < n && arr[neg] < 0) {
      swap(arr, neg, pos);
      neg += 2;
      pos++;
    }
  }

  public static void swap(int arr[], int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  public static void printArray(int arr[], int n) {
    for (int i = 0; i < n; i++) {
      System.out.print(arr[i] + ",");
    }
  }
}
