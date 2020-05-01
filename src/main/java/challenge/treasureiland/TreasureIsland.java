package challenge.treasureiland;

import java.util.*;

public class TreasureIsland {

  private static final char BLOCKED = 'D';
  private static final char TREASURE = 'X';
  private static final char OPEN = 'O';

  public int find(char[][] grid) {

    final int height = grid.length - 1;
    final int width = grid[0].length - 1;
    Map<Point, Integer> visited = new HashMap<>();

    class NextStep {
      public int go(Point p, Set<Point> path) {
        if (visited.containsKey(p)) {
          return visited.get(p);
        }

        if (peek(p) == BLOCKED) {
          visited.put(p, Integer.MAX_VALUE);
          return Integer.MAX_VALUE;
        }

        if (peek(p) == TREASURE) {
          int result = path.size();
          visited.put(p, result);
          return result;
        }

        HashSet<Point> updated = new HashSet<>(path);
        updated.add(p);

        PriorityQueue<Integer> results = new PriorityQueue<>();

        visited.put(p, Integer.MAX_VALUE);

        // left
        results.add(go(new Point(p.x, Math.max(0, p.y - 1)), updated));

        // down
        results.add(go(new Point(Math.min(height, p.x + 1), p.y), updated));

        //right
        results.add(go(new Point(p.x, Math.min(width, p.y + 1)), updated));

        // up
        results.add(go(new Point(Math.max(0, p.x - 1), p.y), updated));

        int result = results.peek();
        visited.put(p, result);
        return result;
      }

      private char peek(Point p) {
        return grid[p.x][p.y];
      }
    }

    int result = new NextStep().go(new Point(0, 0), Collections.emptySet());


    return result == Integer.MAX_VALUE ? 0 : result;
  }



  private static class Point {
    private final int x, y;

    private Point(int x, int y) {
      this.x = x;
      this.y = y;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Point that = (Point) o;
      return x == that.x &&
        y == that.y;
    }

    @Override
    public int hashCode() {
      return Objects.hash(x, y);
    }

    @Override
    public String toString() {
      return "Point{" +
        "x=" + x +
        ", y=" + y +
        '}';
    }
  }

}
