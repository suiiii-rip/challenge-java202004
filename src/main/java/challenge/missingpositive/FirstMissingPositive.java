package challenge.missingpositive;

import java.util.TreeSet;

public class FirstMissingPositive {

  public int find(int[] numbers) {

    TreeSet<Integer> nonCandidates = new TreeSet<>();

    for (int num : numbers) {
      if (num > 0) {
        nonCandidates.add(num);
      }
    }

    int i = 1;
    Integer a = nonCandidates.pollFirst();
    while(a != null && i == a) {
      a = nonCandidates.pollFirst();
      i++;
    }

    return i;
  }

}
