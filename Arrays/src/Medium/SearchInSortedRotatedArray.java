package Medium;

/*
 * Search an element in a sorted and rotated array
 */
public class SearchInSortedRotatedArray {

  public static void main(String args[]) {
    int arr[] = {4, 5, 6, 7, 8, 9, 1, 2, 3};
    int n = arr.length;
    int key = 6;
    int i = search(arr, 0, n - 1, key);
    if (i != -1) {
      System.out.println("Index: " + i);
    } else {
      System.out.println("Key not found");
    }
  }

  private static int search(int[] arr, int l, int h, int key) {
    if (l > h) {
      return -1;
    }
    int mid = (l + h) / 2;
    if (arr[mid] == key) {
      return mid;
    }
    // Left of Mid is Sorted Array
    if (arr[l] <= arr[mid]) {
      if (key <= arr[mid] && key >= arr[l]) {
        return search(arr, l, mid - 1, key);
      } else {
        return search(arr, mid + 1, h, key);
      }
    }
    // Right of Mid is sorted
    if (key >= arr[mid] && key <= arr[h]) {
      return search(arr, mid + 1, h, key);
    } else {
      return search(arr, l, mid - 1, key);
    }

  }

}
