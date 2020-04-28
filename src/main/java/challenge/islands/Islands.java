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

    class SearchIslands {
      public int search() {
        int islands = 0;

        for (int i = 0; i < rows; i++) {
          for (int j = 0; j < columns; j++) {

            if (grid[i][j] == 1 && !searched[i][j]) {
              islands++;
              searchIsland(i, j);
            }

          }
        }

        return islands;
      }

      private void searchIsland(int i, int j) {
        if (searched[i][j]) {
          return;
        }
        searched[i][j] = true;

        if (grid[i][j] == 0) {
          return;
        }

        // go right
        searchIsland(i, Math.min(j + 1, columns - 1));

        // go down
        searchIsland(Math.min(i + 1, rows - 1), j);

        // go left
        searchIsland(i, Math.max(j - 1, 0));

        // go up
        searchIsland(Math.max(i - 1, 0), j);
      }
    }

    return new SearchIslands().search();
  }

}
