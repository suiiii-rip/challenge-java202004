package challenge.maximumgap;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MaximumGapTest {

  private MaximumGap m;

  @Before
  public void setUp() throws Exception {
    m = new MaximumGap();
  }

  @Test
  public void find() {
    int[] num = {3, 6, 9, 1};
    int result = 3;

    assertEquals(result, m.find(num));
  }


  @Test
  public void find_more() {
    int[] num = {3, 6, 9, 1, 30, 14, 9};
    int result = 16;

    assertEquals(result, m.find(num));
  }


  @Test
  public void find_moreSmallerGap() {
    int[] num = {3, 6, 9, 1, 30, 14, 9, 40, 50, 23};
    int result = 10;

    assertEquals(result, m.find(num));
  }


  @Test
  public void find_lessThan2() {
    int[] num = {10};
    int result = 0;

    assertEquals(result, m.find(num));
  }


  @Test
  public void find_2() {
    int[] num = {10, 1};
    int result = 9;

    assertEquals(result, m.find(num));
  }
}