package challenge.islands;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class IslandsTest {

  private Islands i;

  @Before
  public void setUp() throws Exception {

    i = new Islands();

  }

  private int[] r(int... fields) {
    return fields;
  }

  @Test
  public void count_example1() {

    int[][] grid = new int[][] {
      r(1, 1, 1, 1, 0),
      r(1, 1, 0, 1, 0),
      r(1, 1, 0, 0, 0),
      r(0, 0, 0, 0, 0),
    };
    int result = 1;

    assertEquals(result, i.count(grid));
  }

  @Test
  public void count_example2() {

    int[][] grid = new int[][] {
      r(1, 1, 0, 0, 0),
      r(1, 1, 0, 0, 0),
      r(0, 0, 1, 0, 0),
      r(0, 0, 0, 1, 1),
    };
    int result = 3;

    assertEquals(result, i.count(grid));
  }

  @Test
  public void count_example3() {

    int[][] grid = new int[][] {
      r(1, 1, 0, 1, 0),
      r(1, 1, 0, 0, 1),
      r(0, 0, 1, 0, 1),
      r(1, 1, 0, 1, 1),
    };
    int result = 5;

    assertEquals(result, i.count(grid));
  }

  @Test
  public void count_zeros() {

    int[][] grid = new int[][] {
      r(0, 0, 0, 0, 0),
      r(0, 0, 0, 0, 0),
      r(0, 0, 0, 0, 0),
      r(0, 0, 0, 0, 0),
    };
    int result = 0;

    assertEquals(result, i.count(grid));
  }

  @Test
  public void count_ones() {

    int[][] grid = new int[][] {
      r(1, 1, 1, 1, 1),
      r(1, 1, 1, 1, 1),
      r(1, 1, 1, 1, 1),
      r(1, 1, 1, 1, 1),
    };
    int result = 1;

    assertEquals(result, i.count(grid));
  }

  @Test
  public void count_empty() {

    int[][] grid = new int[][] {};
    int result = 0;

    assertEquals(result, i.count(grid));
  }
}