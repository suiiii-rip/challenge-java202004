package challenge.ropes;

import org.junit.Test;

import static org.junit.Assert.*;

public class RopesTest {

  private Ropes r = new Ropes();

  @Test
  public void minCost() {

    int[] ropes = new int[]{8, 4, 6, 12};
    int costs = r.minCost(ropes);

    assertEquals(58, costs);
  }
}