package Medium;

public class MergeSort {

  public static void main(String[] args) {
    int arr[] = {10, 5, 2, 1};
    System.out.println("Array Before Sorting");
    printArr(arr);
    sortArr(arr);
    System.out.println("Array After Sorting");
    printArr(arr);
  }

  private static void sortArr(int[] arr) {
    if (arr.length == 1) {
      return;
    }

    int midIndex = arr.length / 2 + arr.length % 2;
    int[] listFirstHalf = new int[midIndex];
    int[] listSecondHalf = new int[arr.length - midIndex];

    split(arr, listFirstHalf, listSecondHalf);
    sortArr(listFirstHalf);
    sortArr(listSecondHalf);
    merge(arr, listFirstHalf, listSecondHalf);
  }


  private static void split(int[] arr, int[] listFirstHalf, int[] listSecondHalf) {
    int index = 0;
    int secondHalfIndex = listFirstHalf.length;
    for (int element : arr) {
      if (index < listFirstHalf.length) {
        listFirstHalf[index] = element;
      } else {
        listSecondHalf[index - secondHalfIndex] = element;
      }
      index++;
    }
  }

  private static void merge(int[] arr, int[] listFirstHalf, int[] listSecondHalf) {
    int mergeIndex = 0;
    int firstHalfIndex = 0;
    int secondHalfIndex = 0;
    while (firstHalfIndex < listFirstHalf.length && secondHalfIndex < listSecondHalf.length) {
      if (listFirstHalf[firstHalfIndex] < listSecondHalf[secondHalfIndex]) {
        arr[mergeIndex] = listFirstHalf[firstHalfIndex];
        firstHalfIndex++;
      } else {
        arr[mergeIndex] = listSecondHalf[secondHalfIndex];
        secondHalfIndex++;
      }
      mergeIndex++;
    }
    if (firstHalfIndex < listFirstHalf.length) {
      while (mergeIndex < arr.length) {
        arr[mergeIndex++] = listFirstHalf[firstHalfIndex++];
      }
    }

    if (secondHalfIndex < listSecondHalf.length) {
      while (mergeIndex < arr.length) {
        arr[mergeIndex++] = listSecondHalf[secondHalfIndex++];
      }
    }
  }

  private static void printArr(int[] arr) {
    System.out.println();
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + ", ");
    }
    System.out.println();
  }
}
