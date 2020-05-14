package challenge.candy;

public class Candy {

  public int candies(int[] children) {

    if (children.length == 0) {
      return 0;
    }

    int[] candiesLR = new int[children.length];

    candiesLR[0] = 1;
    for (int i = 1; i < children.length; i++) {
      if (children[i] > children[i - 1]) {
        candiesLR[i] = candiesLR[i - 1] + 1;
      } else {
        candiesLR[i] = 1;
      }
    }

    int[] candiesRL = new int[children.length];
    candiesRL[candiesRL.length - 1] = 1;

    for (int i = children.length - 2; i >= 0; i--) {
      if (children[i] > children[i + 1]) {
        candiesRL[i] = candiesRL[i + 1] + 1;
      } else {
        candiesRL[i] = 1;
      }
    }

    int sum = 0;

    for (int i = 0; i < children.length; i++) {
      sum += Math.max(candiesLR[i], candiesRL[i]);
    }

    return sum;
  }

}
