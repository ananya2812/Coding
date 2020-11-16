package Hard;

import java.util.Arrays;
import java.util.Stack;

/*
 * The stock span problem is a financial problem where we have a series of n daily price quotes for
 * a stock and we need to calculate span of stock’s price for all n days. The span Si of the stock’s
 * price on a given day i is defined as the maximum number of consecutive days just before the given
 * day, for which the price of the stock on the current day is less than or equal to its price on
 * the given day.
 * 
 * For example, if an array of 7 days prices is given as {100, 80, 60, 70, 60, 75, 85}, then the
 * span values for corresponding 7 days are {1, 1, 1, 2, 1, 4, 6}
 */
public class StockSpan {

  public static void main(String[] args) {
    int price[] = {10, 4, 5, 90, 120, 80};
    int n = price.length;
    int stockSpan[] = new int[n];

    calculateSpan(price, n, stockSpan);

    printArray(stockSpan);
  }

  static void printArray(int arr[]) {
    System.out.print(Arrays.toString(arr));
  }

  static void calculateSpan(int[] price, int n, int[] stockSpan) {
    Stack<Integer> spanStack = new Stack<>();
    spanStack.push(0);
    stockSpan[0] = 1;

    for (int i = 1; i < n; i++) {

      while (!spanStack.isEmpty() && price[spanStack.peek()] <= price[i]) {
        spanStack.pop();
      }

      stockSpan[i] = (spanStack.isEmpty()) ? (i + 1) : (i - spanStack.peek());
      
      spanStack.push(i);
    }
  }


}
