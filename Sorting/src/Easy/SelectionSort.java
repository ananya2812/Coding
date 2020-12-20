package Easy;

public class SelectionSort {

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
    for (int i = 0; i < arr.length - 1; i++) {
      for (int j = i + 1; j < arr.length; j++) {
        if (arr[j] < arr[i]) {
          swap(arr, i, j);
        }
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
      System.out.print(arr[i]+", ");
    }
    System.out.println();
  }
}
