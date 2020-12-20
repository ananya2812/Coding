package Easy;

public class BubbleSort {

  public static void main(String[] args) {
    int arr[] = {10, 5, 2, 1, 3, 7};
    System.out.println("Array Before Sorting");
    printArr(arr);
    sortArr(arr);
    System.out.println("Array After Sorting");
    sortArr(arr);
    printArr(arr);
  }

  private static void sortArr(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      boolean swapped = false;
      for (int j = arr.length - 1; j > i; j--) {
        if (arr[j] < arr[j - 1]) {
          swap(arr, j, j - 1);
          swapped = true;
        }
      }
      if (!swapped) {
        break;
      }
    }
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
