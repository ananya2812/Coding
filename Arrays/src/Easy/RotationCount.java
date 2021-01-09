package Easy;

/*
 * Consider an array of distinct numbers sorted in increasing order. The array has been rotated
 * (clockwise) k number of times. Given such an array, find the value of k.
 */
public class RotationCount {

  public static void main(String[] args) {
    int arr[] = {15, 18, 2, 3, 6, 12};
    int n = arr.length;
    System.out.println(countRotations(arr, 0, n - 1));
  }

  private static int countRotations(int[] arr, int l, int h) {
    if (l > h) {
      return -1;
    }
    int mid = (l + h) / 2;
    if (mid < h && arr[mid + 1] < arr[mid]) {
      return mid + 1;
    }
    if (mid > l && arr[mid - 1] > arr[mid]) {
      return mid;
    }

    if (arr[h] > arr[mid]) {
      return countRotations(arr, l, mid - 1);
    }
    return countRotations(arr, mid + 1, h);
  }
}
