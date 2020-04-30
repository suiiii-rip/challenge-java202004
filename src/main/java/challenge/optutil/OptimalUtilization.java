package challenge.optutil;

import java.util.*;
import java.util.stream.Collectors;

public class OptimalUtilization {

  public int[][] find(int[][] aArray, int[][] bArray, int target) {

    Comparator<int[]> valueComparator = Comparator.comparing((int[] ar) -> ar[1]);
    Comparator<int[]> idComparator = Comparator.comparing((int[] ar) -> ar[0]);
    Comparator<int[]> naturalComparator = valueComparator.thenComparing(idComparator);

    SortedSet<int[]> sortedA = Arrays.stream(aArray).collect(Collectors
      .toCollection(() -> new TreeSet<>(valueComparator.reversed().thenComparing(idComparator))));
    SortedSet<int[]> sortedB = Arrays.stream(bArray).collect(Collectors
      .toCollection(() -> new TreeSet<>(naturalComparator)));

    SortedMap<Integer, List<int[]>> candidates = new TreeMap<>(Comparator.reverseOrder());

    for (int[] a : sortedA) {
      for (int[] b : sortedB) {

        int sum = a[1] + b[1];
        if (sum <= target) {
          int[] candidate = {a[0], b[0]};

          List<int[]> values = candidates.getOrDefault(sum, new ArrayList<>());
          values.add(candidate);
          candidates.put(sum, values);
        } else {
          break;
        }
      }
    }

    SortedSet<int[]> result = new TreeSet<>(idComparator.thenComparing(valueComparator));
    if (!candidates.isEmpty()) {
      result.addAll(candidates.get(candidates.firstKey()));
    }
    return result.toArray(new int[][]{});
  }

}
