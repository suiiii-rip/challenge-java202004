package challenge.ropes;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class Ropes {

  public int minCost(int[] ropes) {

    PriorityQueue<Integer> minHeap = Arrays.stream(ropes).boxed().collect(Collectors.toCollection(PriorityQueue::new));

    int rope = minHeap.remove();
    int cost = 0;

    while(!minHeap.isEmpty()) {
      rope += minHeap.remove();
      cost += rope;
    }

    return cost;
  }

}
