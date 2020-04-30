package challenge.optutil;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class OptimalUtilizationTest {

  private OptimalUtilization o;

  @Before
  public void setUp() throws Exception {

    o = new OptimalUtilization();
  }

  @Test
  public void find_example1() {

    int[][] a = {{1, 2}, {2, 4}, {3, 6}};
    int[][] b = {{1, 2}};
    int target = 7;

    int[][] output = {{2, 1}};

    assertArrayEquals(output, o.find(a, b, target));
  }

  @Test
  public void find_example2() {

    int[][] a = {{1, 3}, {2, 5}, {3, 7}, {4, 10}};
    int[][] b = {{1, 2}, {2, 3}, {3, 4}, {4, 5}};
    int target = 10;

    int[][] output = {{2, 4}, {3, 2}};

    assertArrayEquals(output, o.find(a, b, target));
  }

  @Test
  public void find_example3() {

    int[][] a = {{1, 8}, {2, 7}, {3, 14}};
    int[][] b = {{1, 5}, {2, 10}, {3, 14}};
    int target = 20;

    int[][] output = {{3, 1}};

    assertArrayEquals(output, o.find(a, b, target));
  }

  @Test
  public void find_example4() {

    int[][] a = {{1, 8}, {2, 15}, {3, 9}};
    int[][] b = {{1, 8}, {2, 11}, {3, 12}};
    int target = 20;

    int[][] output = {{1, 3}, {3, 2}};

    assertArrayEquals(output, o.find(a, b, target));
  }

  @Test
  public void find_2closest() {

    int[][] a = {{1, 8}, {2, 15}, {3, 8}};
    int[][] b = {{1, 8}, {2, 11}, {3, 11}};
    int target = 20;

    int[][] output = {{1, 2}, {1, 3}, {3, 2}, {3, 3}};

    assertArrayEquals(output, o.find(a, b, target));
  }

  @Test
  public void find_1empty() {

    int[][] a = {};
    int[][] b = {{1, 8}, {2, 11}, {3, 12}};
    int target = 20;

    int[][] output = {};

    assertArrayEquals(output, o.find(a, b, target));
  }

  @Test
  public void find_bothEmpty() {

    int[][] a = {};
    int[][] b = {};
    int target = 20;

    int[][] output = {};

    assertArrayEquals(output, o.find(a, b, target));
  }

  @Test
  public void find_negatives() {

    int[][] a = {{1, 3}, {2, 15}, {3, 7}, {4, 10}};
    int[][] b = {{1, 2}, {2, 3}, {3, 4}, {4, -5}};
    int target = 10;

    int[][] output = {{2, 4}, {3, 2}};

    assertArrayEquals(output, o.find(a, b, target));
  }

  @Test
  public void find_negativeTarget() {

    int[][] a = {{1, 3}, {2, -15}, {3, 7}, {4, 10}};
    int[][] b = {{1, 2}, {2, 3}, {3, 4}, {4, 5}};
    int target = -10;

    int[][] output = {{2, 4}};

    assertArrayEquals(output, o.find(a, b, target));
  }

  @Test
  public void find_negativeTarget_closest() {

    int[][] a = {{1, 3}, {2, -16}, {3, 7}, {4, 10}};
    int[][] b = {{1, 2}, {2, 3}, {3, 4}, {4, 5}};
    int target = -10;

    int[][] output = {{2, 4}};

    assertArrayEquals(output, o.find(a, b, target));
  }
}