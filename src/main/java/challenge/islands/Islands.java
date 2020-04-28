package challenge.islands;

public class Islands {

  public int count(int[][] grid) {

    int rows = grid.length;
    int columns = grid.length > 0 ? grid[0].length : 0;

    // create search grid
    boolean[][] searched = new boolean[rows][];
    for (int i = 0; i < rows; i++) {
      searched[i] = new boolean[columns];
    }

    int islands = 0;

    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {

        if (grid[i][j] == 1 && !searched[i][j]) {
          islands++;
          searchIsland(i, j, grid, searched);
        }

      }
    }

    return islands;
  }

  private void searchIsland(int i, int j, int[][]grid, boolean[][] searched) {
    if (searched[i][j]) {
      return;
    }
    searched[i][j] = true;

    if (grid[i][j] == 0) {
      return;
    }

    // go right
    searchIsland(i, Math.min(j + 1, grid[0].length - 1), grid, searched);

    // go down
    searchIsland(Math.min(i + 1, grid.length - 1), j, grid, searched);

    // go left
    searchIsland(i, Math.max(j - 1, 0), grid, searched);

    // go up
    searchIsland(Math.max(i - 1, 0), j, grid, searched);
  }

}
