import java.util.Stack;

/**
 * Created by therk on 1/2/17.
 */
public class Algs {
  public static int threeSumCount(int[] numbers) {
    int count = 0;

    for (int i = 0; i < numbers.length; i++) {
      for (int j = i + 1; j < numbers.length; j++) {
        for (int k = j + 1; k < numbers.length; k++) {

          if (numbers[i] + numbers[j] + numbers[k] == 0) {
            count++;
          }
        }
      }
    }
    return count;
  }

  public static int binarySearch(int[] a, int key) {
    int low = 0;
    int high = a.length - 1;

    while (low <= high) {
      int middle = low + (high - low) / 2;
      int value = a[middle];
      if (value == key) {
        return key;
      }
      if (key < value) {
        high = middle - 1;
      } else if (key > value) {
        low = middle + 1;
      }
    }
    return -1;
  }

  public static double solveArithmeticExpression(String exp) {
    java.util.Stack<Double> values = new java.util.Stack<>();
    java.util.Stack<Character> operators = new java.util.Stack<>();

    for (int i = 0; i < exp.length(); i++) {
      Character c = exp.charAt(i);
      if (c == '(' || c == ' ') {
        // skip
      } else if (c == '+' || c == '-' || c == '*' || c == '/') {
        operators.push(c);
      } else if (isNumber(c)) {
        int numToIndex = i + 1;
        while (numToIndex < exp.length() && isNumber(exp.charAt(numToIndex))) {
          numToIndex++;
        }
        values.push(Double.parseDouble(exp.substring(i, numToIndex)));
        i = numToIndex - 1;
      } else if (c == ')') {
        solveStackOperation(values, operators);
      }
    }

    while (!operators.empty()) {
      solveStackOperation(values, operators);
    }
    return values.pop();
  }

  private static Boolean isNumber(Character c) {
    return c.charValue() >= 48 && c.charValue() <= 58;
  }

  private static void solveStackOperation(Stack<Double> values, Stack<Character> operators) {
    double left = values.pop();
    double right = values.pop();
    Character operation = operators.pop();
    if (operation == '+') {
      values.push(left + right);
    } else if (operation == '*') {
      values.push(left * right);
    } else if (operation == '-') {
      values.push(left - right);
    } else if (operation == '/') {
      values.push(left / right);
    }
  }


}
