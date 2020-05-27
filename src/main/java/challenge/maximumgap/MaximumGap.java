package challenge.maximumgap;

public class MaximumGap {

  public int find(int[] numbers) {

    if (numbers.length < 2) {
      return 0;
    }

    int lowest = Integer.MAX_VALUE;
    int largest = -1;

    for (int n : numbers) {
      lowest = Math.min(n, lowest);
      largest = Math.max(n, largest);
    }

    boolean[] buckets = new boolean[largest - lowest + 1];

    for (int number : numbers) {
      buckets[number - lowest] = true;
    }

    int maxGap = -1;
    int gap = 0;
    for (int i = 1; i < buckets.length; i++) {
      gap++;
      if (buckets[i]) {
        maxGap = Math.max(maxGap, gap);
        gap = 0;
      }
    }

    return maxGap;
  }


}
