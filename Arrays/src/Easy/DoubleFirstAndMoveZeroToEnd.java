package Easy;

/*
 * For a given array of n integers and assume that ‘0’ as an invalid number and all other as a valid
 * number. Convert the array in such a way that if both current and next element is same then double
 * current value and replace the next number with 0. After the modification, rearrange the array
 * such that all 0’s shifted to the end.
 */
public class DoubleFirstAndMoveZeroToEnd {

  public static void main(String[] args) {
    int arr[] = {0, 2, 2, 2, 0, 6, 6, 0, 0, 8};
    int n = arr.length;

    System.out.print("Original array: ");
    printArray(arr, n);

    modifyAndRearrangeArr(arr, n);

    System.out.print("Modified array: ");
    printArray(arr, n);
  }

  public static void printArray(int arr[], int n) {
    for (int i = 0; i < n; i++)
      System.out.print(arr[i] + " ");
    System.out.println();
  }

  public static void modifyAndRearrangeArr(int[] arr, int n) {
    for (int i = 0; i < n - 1; i++) {
      if (arr[i] != 0 && arr[i] == arr[i + 1]) {
        arr[i] = 2 * arr[i];
        arr[i + 1] = 0;
      }
    }
    pushZerosToEnd(arr, n);
  }

  private static void pushZerosToEnd(int[] arr, int n) {
    int nonZeroCount = 0;
    for (int i = 0; i < n; i++) {
      if (arr[i] != 0) {
        swap(arr, i, nonZeroCount);
        nonZeroCount++;
      }
    }
  }

  public static void swap(int arr[], int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

}
