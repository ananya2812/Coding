package Basic;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import Basic.Stack.StackOverflowException;
import Basic.Stack.StackUnderflowException;

public class MatchParenthesis {

  private static final Map<Character, Character> parenthesisMap = new HashMap<>();
  private static final Set<Character> openingParanthesis = new HashSet<>();

  static {
    parenthesisMap.put('}', '{');
    parenthesisMap.put(')', '(');
    parenthesisMap.put(']', '[');
    openingParanthesis.addAll(parenthesisMap.values());
  }

  public static void main(String[] args) {
    System.out.println(
        String.format("Has matching parens %s? : %s", "(abcd)", hasMatchingParens("(abcd)")));
    System.out.println(
        String.format("Has matching parens %s? : %s", "{{{{}}", hasMatchingParens("{{{{}}")));
    System.out.println(
        String.format("Has matching parens %s? : %s", "{{{{}}})", hasMatchingParens("{{{{}}})")));
    System.out.println(
        String.format("Has matching parens %s? : %s", "{{{}}}()", hasMatchingParens("{{{}}}()")));
    System.out.println(
        String.format("Has matching parens %s? : %s", "{{{}}]()", hasMatchingParens("{{{}}]()")));
    System.out.println(String.format("Has matching parens %s? : %s", "{{}}([]){}{}{}{}{[[[[]]]]}",
        hasMatchingParens("{{}}([]){}{}{}{}{[[[[]]]]}")));
    System.out.println(
        String.format("Has matching parens %s? : %s", "[({)}]", hasMatchingParens("[({)}]")));
  }

  private static boolean hasMatchingParens(String input) {
    Stack<Character> processingStack = new Stack<>();
    try {
      for (int i = 0; i < input.length(); i++) {
        Character ch = input.charAt(i);
        if (openingParanthesis.contains(ch)) {
          processingStack.push(ch);
        }

        if (parenthesisMap.containsKey(ch)) {
          Character topElement = processingStack.pop();
          if (topElement != parenthesisMap.get(ch)) {
            return false;
          }
        }
      }
      return processingStack.isEmpty();
    } catch (StackOverflowException e) {
      System.out.println("Stack Overflow Exception");
    } catch (StackUnderflowException e) {
      System.out.println("Stack Underflow Exception");
    }
    return false;
  }

}
