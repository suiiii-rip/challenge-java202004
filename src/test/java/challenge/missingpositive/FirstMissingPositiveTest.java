package challenge.missingpositive;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FirstMissingPositiveTest {

  private FirstMissingPositive f;

  @Before
  public void setUp() throws Exception {
    f = new FirstMissingPositive();
  }

  @Test
  public void find() {
    int[] numbers = {1, 2, 0};
    int result = 3;

    assertEquals(result, f.find(numbers));
  }

  @Test
  public void find2() {
    int[] numbers = {3, 4, -1, 1};
    int result = 2;

    assertEquals(result, f.find(numbers));
  }

  @Test
  public void find3() {
    int[] numbers = {7, 8, 9, 11, 12};
    int result = 1;

    assertEquals(result, f.find(numbers));
  }

  @Test
  public void find_emptyNumbers() {
    int[] numbers = {};
    int result = 1;

    assertEquals(result, f.find(numbers));
  }

  @Test
  public void find_onlyNegatives() {
    int[] numbers = {-1, -2};
    int result = 1;

    assertEquals(result, f.find(numbers));
  }
}