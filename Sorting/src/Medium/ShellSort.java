package Medium;

public class ShellSort {

  public static void main(String[] args) {
    int arr[] = {10, 5, 2, 1};
    System.out.println("Array Before Sorting");
    printArr(arr);
    sortArr(arr);
    System.out.println("Array After Sorting");
    printArr(arr);
  }

  private static void sortArr(int[] arr) {
    int increment = arr.length / 2;
    while (increment > 0) {
      for (int startIndex = 0; startIndex < increment; startIndex++) {
        insertionSort(arr, startIndex, increment);
      }
      increment = increment / 2;
    }
  }


  private static void insertionSort(int[] arr, int startIndex, int increment) {
    for (int i = startIndex; i < arr.length; i = i + increment) {
      for (int j = Math.min(i + increment, arr.length - 1); j - increment >= 0; j = j - increment) {
        if (arr[j] < arr[j - increment]) {
          swap(arr, j, j - increment);
        } else {
          break;
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
      System.out.print(arr[i] + ", ");
    }
    System.out.println();
  }
}
