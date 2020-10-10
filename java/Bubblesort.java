/**
 * Simple utility class which implements the Bubblesort algorithm.
 */
public class Bubblesort {
  public static void sort(final int[] input) {
    for (int i = input.length -1; i >= 0; i--) {
      for (int j = 0; j < i - 1; j++) {
        if (input[j] > input[j+1]) {
          final int temp = input[j];
          input[j] = input[j+1];
          input[j+1] = temp;
        }
      }
    }
  }
}
