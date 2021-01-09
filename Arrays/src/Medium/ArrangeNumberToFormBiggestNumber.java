package Medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
 * Given an array of numbers, arrange them in a way that yields the largest value. For example, if
 * the given numbers are {54, 546, 548, 60}, the arrangement 6054854654 gives the largest value.
 */
public class ArrangeNumberToFormBiggestNumber {

  public static void main(String[] args) {
    List<String> arr = new ArrayList<>();
    arr.add("54");
    arr.add("546");
    arr.add("548");
    arr.add("60");
    printLargest(arr);
  }

  private static void printLargest(List<String> arr) {
    Collections.sort(arr, new Comparator<String>() {

      @Override
      public int compare(String X, String Y) {
        String XY = X + Y;
        String YX = Y + X;
        // Sort by Descending
        return XY.compareTo(YX) > 0 ? -1 : 1;
      }
    });

    for (String str : arr) {
      System.out.print(str);
    }
  }
}
