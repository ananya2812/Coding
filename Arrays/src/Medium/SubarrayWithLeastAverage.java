package Medium;

/*
 * Given an array arr[] of size n and integer k such that k <= n. Examples :
 * 
 * Input: arr[] = {3, 7, 90, 20, 10, 50, 40}, k = 3 Output: Subarray between indexes 3 and 5 The
 * subarray {20, 10, 50} has the least average among all subarrays of size 3.
 */
public class SubarrayWithLeastAverage {

  static int arr[] = new int[] {3, 7, 90, 20, 10, 50, 40};

  public static void main(String[] args) {
    int k = 3;
    findMinAvgSubarray(arr.length, k);
  }

  private static void findMinAvgSubarray(int n, int k) {
    int currSum = 0, minSum = 0;
    int minStartIndex = 0;

    for (int i = 0; i < k; i++) {
      currSum += arr[i];
    }

    minSum = currSum;

    for (int i = k; i < n; i++) {
      currSum = currSum + arr[i] - arr[i - k];
      if (currSum < minSum) {
        minSum = currSum;
        minStartIndex = i - k + 1;
      }
    }
    System.out.println("Start Index: " + minStartIndex + " End Index: " + (minStartIndex + k - 1));
  }


}
