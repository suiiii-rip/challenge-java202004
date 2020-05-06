package challenge.jumpgame2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class JumpGame2Test {

  private JumpGame2 j;

  @Before
  public void setUp() throws Exception {
    j = new JumpGame2();
  }

  @Test
  public void jumps() {

    int[] arr = {2,3,1,1,4};
    int result = 2;

    assertEquals(result, j.jumps(arr));

  }

  @Test
  public void jumps_zero() {

    int[] arr = {2,0,1,1,4};
    int result = 3;

    assertEquals(result, j.jumps(arr));

  }
  @Test
  public void jumps_1Jump() {

    int[] arr = {9,3,1,1,4};
    int result = 1;

    assertEquals(result, j.jumps(arr));

  }

  @Test
  public void jumps_singleArray() {

    int[] arr = {2};
    int result = 0;

    assertEquals(result, j.jumps(arr));

  }
}