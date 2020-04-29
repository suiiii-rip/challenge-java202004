package challenge.sums;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SumsTest {

  private Sums s;

  @Before
  public void setUp() throws Exception {

    s = new Sums();
  }

  @Test
  public void findIndices_example1() {

    int[] numbers = new int[] {1, 10, 25, 35, 60};
    int target = 90;

    int[] result = new int[] {2, 3};

    assertArrayEquals(result, s.findIndices(numbers, target));
  }

  @Test
  public void findIndices_example2() {

    int[] numbers = new int[] {20, 50, 40, 25, 30, 10};
    int target = 90;

    int[] result = new int[] {1, 5};

    assertArrayEquals(result, s.findIndices(numbers, target));
  }

  @Test
  public void findIndices_duplicates() {

    int[] numbers = new int[] {20, 50, 40, 25, 30, 10, 10, 50};
    int target = 90;

    int[] result = new int[] {1, 5};

    assertArrayEquals(result, s.findIndices(numbers, target));
  }

  @Test
  public void findIndices_duplicates2() {

    int[] numbers = new int[] {20, 30, 30, 25, 30, 10};
    int target = 90;

    int[] result = new int[] {1, 2};

    assertArrayEquals(result, s.findIndices(numbers, target));
  }

  @Test
  public void findIndices_negativeTarget() {

    int[] numbers = new int[] {20, 50, 40, 25, 30, 10, -120, 3, 0};
    int target = -90;

    int[] result = new int[] {6, 8};

    assertArrayEquals(result, s.findIndices(numbers, target));
  }

  @Test
  public void findIndices_negatives() {

    int[] numbers = new int[] {20, 50, 40, 25, 30, 10, 90, -30, -1000};
    int target = 90;

    int[] result = new int[] {6, 7};

    assertArrayEquals(result, s.findIndices(numbers, target));
  }

  @Test
  public void findIndices_empty() {

    int[] numbers = new int[] {};
    int target = 90;

    int[] result = new int[] {};

    assertArrayEquals(result, s.findIndices(numbers, target));
  }

  @Test
  public void findIndices_noSolution() {

    int[] numbers = new int[] {1, 2};
    int target = 90;

    int[] result = new int[] {};

    assertArrayEquals(result, s.findIndices(numbers, target));
  }

  @Test
  public void findIndices_singleNumber() {

    int[] numbers = new int[] {1};
    int target = 90;

    int[] result = new int[] {};

    assertArrayEquals(result, s.findIndices(numbers, target));
  }
}