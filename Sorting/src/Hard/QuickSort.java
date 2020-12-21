package Hard;

public class QuickSort {

  public static void main(String[] args) {
    int arr[] = {10, 5, 2, 1};
    System.out.println("Array Before Sorting");
    printArr(arr);
    sortArr(arr, 0, arr.length - 1);
    System.out.println("Array After Sorting");
    printArr(arr);
  }

  private static void sortArr(int[] arr, int low, int high) {
    if (low >= high) {
      return;
    }
    int pivotIndex = partition(arr, low, high);
    sortArr(arr, low, pivotIndex - 1);
    sortArr(arr, pivotIndex + 1, high);
  }

  private static int partition(int[] arr, int low, int high) {
    int pivot = arr[low];
    int l = low;
    int h = high;
    while (l < h) {
      while (arr[l] <= pivot && l < h) {
        l++;
      }
      while (arr[h] > pivot) {
        h--;
      }
      if (l < h) {
        swap(arr, l, h);
      }
    }
    swap(arr, low, h);
    return h;
  }

  private static void swap(int[] arr, int index1, int index2) {
    int temp = arr[index1];
    arr[index1] = arr[index2];
    arr[index2] = temp;
  }

  private static void printArr(int[] arr) {
    System.out.println();
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + ", ");
    }
    System.out.println();
  }
}
