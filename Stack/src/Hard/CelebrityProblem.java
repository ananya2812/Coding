package Hard;

import java.util.Stack;

/*
 * In a party of N people, only one person is known to everyone. Such a person may be present in the
 * party, if yes, (s)he doesn’t know anyone in the party. We can only ask questions like “does A
 * know B? “. Find the stranger (celebrity) in the minimum number of questions.
 * 
 * Input: MATRIX = { {0, 0, 1, 0}, {0, 0, 1, 0}, {0, 0, 0, 0}, {0, 0, 1, 0} } Output:id = 2
 * Explanation: The person with ID 2 does not know anyone but everyone knows him
 * 
 * Input: MATRIX = { {0, 0, 1, 0}, {0, 0, 1, 0}, {0, 1, 0, 0}, {0, 0, 1, 0} } Output: No celebrity
 * Explanation: There is no celebrity.
 */
public class CelebrityProblem {

  static int MATRIX[][] = {{0, 0, 1, 0}, {0, 0, 1, 0}, {0, 0, 0, 0}, {0, 0, 1, 0}};

  public static void main(String[] args) {
    int n = 4;
    int result = findCelebrity(n);
    if (result == -1) {
      System.out.println("No Celebrity");
    } else
      System.out.println("Celebrity ID " + result);
  }

  private static int findCelebrity(int n) {
    Stack<Integer> personStack = new Stack<Integer>();
    int celebrity;

    for (int i = 0; i < n; i++) {
      personStack.push(i);
    }
    while (personStack.size() > 1) {
      int person1 = personStack.pop();
      int person2 = personStack.pop();
      if (knows(person1, person2)) {
        personStack.push(person2);
      } else {
        personStack.push(person1);
      }
    }
    if (personStack.empty()) {
      return -1;
    }
    celebrity = personStack.pop();

    for (int i = 0; i < n; i++) {
      if (i != celebrity && knows(celebrity, i) && !knows(i, celebrity)) {
        return -1;
      }
    }
    return celebrity;
  }

  private static int findCelebrityOptimal(int n) {

    int person1 = 0;
    int person2 = n - 1;


    while (person1 < person2) {
      if (knows(person1, person2)) {
        person1++;
      } else {
        person2--;
      }
    }

    for (int i = 0; i < n; i++) {
      if (i != person1 && knows(person1, i) && !knows(i, person1)) {
        return -1;
      }
    }
    return person1;
  }

  private static Boolean knows(int a, int b) {
    return (MATRIX[a][b] == 1);
  }

}
