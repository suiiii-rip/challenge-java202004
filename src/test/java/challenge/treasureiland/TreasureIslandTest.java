package challenge.treasureiland;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TreasureIslandTest {

  private TreasureIsland ti;

  @Before
  public void setUp() throws Exception {
    ti = new TreasureIsland();

  }

  @Test
  public void find() {

    char[][] grid = {
      {'O', 'O', 'O', 'O'},
      {'D', 'O', 'D', 'O'},
      {'O', 'O', 'O', 'O'},
      {'X', 'D', 'D', 'O'},
    };
    int result = 5;

    assertEquals(result, ti.find(grid));
  }

  @Test
  public void find_noIsland() {

    char[][] grid = {
      {'O', 'O', 'O', 'O'},
      {'D', 'O', 'D', 'O'},
      {'O', 'O', 'O', 'O'},
      {'O', 'D', 'D', 'O'},
    };
    int result = 0;

    assertEquals(result, ti.find(grid));
  }

  @Test
  public void find_1x1() {

    char[][] grid = {
      {'O'},
    };
    int result = 0;

    assertEquals(result, ti.find(grid));
  }

  @Test
  public void find_blocked() {

    char[][] grid = {
      {'O', 'O', 'O', 'O'},
      {'D', 'O', 'D', 'O'},
      {'D', 'D', 'O', 'O'},
      {'X', 'D', 'D', 'O'},
    };
    int result = 0;

    assertEquals(result, ti.find(grid));
  }

  @Test
  public void find_multipleShortestPaths() {

    char[][] grid = {
      {'O', 'O', 'O', 'O'},
      {'O', 'O', 'O', 'O'},
      {'O', 'O', 'O', 'O'},
      {'O', 'O', 'O', 'X'},
    };
    int result = 6;

    assertEquals(result, ti.find(grid));
  }
}