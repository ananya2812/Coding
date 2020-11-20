package Easy;

import java.util.Stack;

/*
 * Given a string str, we need to print reverse of individual words.
 */
public class ReversoWordUsingStack {

  public static void main(String[] args) {
    String str = "Hello World";
    reverseWords(str);
  }

  private static void reverseWords(String str) {
    Stack<Character> revStack = new Stack<>();
    for (int i = 0; i < str.length(); i++) {
      if (str.charAt(i) != ' ') {
        revStack.push(str.charAt(i));
      } else {
        while (!revStack.isEmpty()) {
          System.out.print(revStack.pop());
        }
        System.out.print(" ");
      }
    }

    while (!revStack.isEmpty()) {
      System.out.print(revStack.pop());
    }
  }
}
