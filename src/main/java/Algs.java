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
}
