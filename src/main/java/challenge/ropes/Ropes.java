package challenge.ropes;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class Ropes {

  public int minCost(int[] ropes) {

    List<Integer> list = Arrays.stream(ropes).boxed().collect(Collectors.toList());
    PriorityQueue<Integer> minHeap = new PriorityQueue<>(list);

    int rope = minHeap.remove();
    int cost = 0;

    while(!minHeap.isEmpty()) {
      rope += minHeap.remove();
      cost += rope;
    }

    return cost;
  }

}
