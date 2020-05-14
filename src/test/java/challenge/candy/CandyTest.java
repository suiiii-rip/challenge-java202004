package challenge.candy;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CandyTest {

  private Candy c;

  @Before
  public void setUp() throws Exception {
    c = new Candy();
  }

  @Test
  public void candies() {

    int[] children = {1,0,2};
    int result = 5;

    assertEquals(result, c.candies(children));

  }

  @Test
  public void candies2() {

    int[] children = {1,2,2};
    int result = 4;

    assertEquals(result, c.candies(children));

  }

    @Test
  public void candies_empty() {

    int[] children = {};
    int result = 0;

    assertEquals(result, c.candies(children));

  }

    @Test
  public void candies_1Child() {

    int[] children = {1};
    int result = 1;

    assertEquals(result, c.candies(children));

  }

    @Test
  public void candies3() {

    int[] children = {1,6,5,4,4};
//  int[] children = {1,2,1,1,1};
//  int[] children = {1,3,2,1,1};
//  int[] children = {1,3,2,1,1};
    int result = 8;

    assertEquals(result, c.candies(children));

  }
}