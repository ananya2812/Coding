package Medium;

/*
 * A sorted array is rotated at some unknown point, find the minimum element in it.
 */
public class MinimumInSortedRotatedArray {

  public static void main(String[] args) {
    int arr1[] = {5, 6, 1, 2, 3, 4};
    int n1 = arr1.length;
    System.out.println("The minimum element is " + findMin(arr1, 0, n1 - 1));

    int arr2[] = {1, 2, 3, 4};
    int n2 = arr2.length;
    System.out.println("The minimum element is " + findMin(arr2, 0, n2 - 1));

  }

  private static int findMin(int[] arr, int low, int high) {
    if (low > high) {
      return arr[0];
    }
    if (low == high) {
      return arr[low];
    }

    int mid = (low + high) / 2;
    if (mid < high && arr[mid + 1] < arr[mid]) {
      return arr[mid + 1];
    }
    if (low < mid && arr[mid - 1] > arr[mid]) {
      return arr[mid];
    }

    if (arr[high] > arr[mid]) {
      return findMin(arr, low, mid - 1);
    }
    return findMin(arr, mid + 1, high);
  }
}
