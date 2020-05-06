package challenge.jumpgame2;

public class JumpGame2 {

  public int jumps(int[] arr) {
    if (arr.length < 2) {
      return 0;
    }
    return minimum(arr, 0, arr[0]);
  }

  // using a recursive function in java creates a stackoverflow for even small datasets really fast.
  // better to use a loop approach with mutables
  private int minimum(int[] arr, int startPosition, int availableJumps) {
    if (arr.length - 1 - startPosition <= availableJumps) {
      return 1;
    }

    int maxReach = 0;

    int farthestPosition = startPosition + availableJumps;
    for (int i = farthestPosition; i > startPosition; i--) {
      int reach = arr[i] - (farthestPosition - i);
      maxReach = Math.max(maxReach, reach);
    }

    if (maxReach == 0) {
      throw new RuntimeException("Cannot reach end of array");
    }

    return 1 + minimum(arr, farthestPosition, maxReach);
  }

}
