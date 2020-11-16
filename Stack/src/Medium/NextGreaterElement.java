package Medium;

import java.util.Stack;

/*
 * Given an array, print the Next Greater Element (NGE) for every element. The Next greater Element
 * for an element x is the first greater element on the right side of x in array. Elements for which
 * no greater element exist, consider next greater element as -1.
 */
public class NextGreaterElement {

  public static void main(String[] args) {
    //int arr[] = {11, 13, 21, 3};
    int arr[] = {4, 5, 2, 25};
    int n = arr.length;
    printNGE(arr, n);
  }

  private static void printNGE(int[] arr, int n) {
    Stack<Integer> st = new Stack<>();
    st.push(arr[0]);
    for (int i = 1; i < n; i++) {
      Integer next = arr[i];
      while (!st.isEmpty() && next > st.peek()) {
        System.out.println(st.pop() + " --> " + next);
      }
      st.push(next);
    }
    while (!st.isEmpty()) {
      System.out.println(st.pop() + " --> " + -1);
    }
  }
}
