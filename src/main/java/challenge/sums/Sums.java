package challenge.sums;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

public class Sums {

  public static final int CONSTANT = 30;

  public int[] findIndices(int[] numbers, int target) {

    SortedSet<IndexedNumber> sortedNumbers = new TreeSet<>(Comparator
      .comparing((IndexedNumber in) -> in.number).reversed()
      .thenComparing(in -> in.index));

    for (int i = 0; i < numbers.length; i++) {
      sortedNumbers.add(new IndexedNumber(i, numbers[i]));
    }

    for (IndexedNumber in : sortedNumbers) {
      int targetNumber = target - in.number - CONSTANT;

      for (IndexedNumber inn : sortedNumbers.tailSet(in)) {
        if (inn != in) {
          if (targetNumber == inn.number) {
            return new int[] { Math.min(in.index, inn.index), Math.max(in.index, inn.index) };
          } else if (inn.number < targetNumber) {
            break;
          }
        }
      }
    }


    return new int[0];
  }

  private static final class IndexedNumber {
    private final int index, number;

    private IndexedNumber(int index, int number) {
      this.index = index;
      this.number = number;
    }
  }

}
