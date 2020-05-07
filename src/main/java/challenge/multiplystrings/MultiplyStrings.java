package challenge.multiplystrings;

import java.util.ArrayList;
import java.util.List;

public class MultiplyStrings {

  public String multiply(String a, String b) {

    List<List<Integer>> resultMatrix = new ArrayList<>();

    for (int i = a.length() - 1; i >= 0; i--) {

      int x = Character.getNumericValue(a.charAt(i));

      List<Integer> rowResult = new ArrayList<>();

      for (int k = 0; k < a.length() - i - 1; k++) {
        rowResult.add(0);
      }

      int overflow = 0;

      for (int j = b.length() - 1; j >= 0; j--) {
        int y = Character.getNumericValue(b.charAt(j));

        int result = (x * y) + overflow;

        int resultDigit = result % 10;
        overflow = result / 10;

        rowResult.add(resultDigit);
      }
      rowResult.add(overflow);
      resultMatrix.add(rowResult);
    }

    boolean hasDigits = true;
    int i = 0;
    int overflow = 0;
    StringBuilder sb = new StringBuilder();

    while (hasDigits) {
      List<Integer> columnDigits = new ArrayList<>();
      boolean columnsValid = false;

      for (List<Integer> row : resultMatrix) {

        if (row.size() > i) {
          columnDigits.add(row.get(i));
          columnsValid = true;
        }
      }
      int result = columnDigits.stream().reduce(0, Integer::sum) + overflow;

      int resultDigit = result % 10;
      overflow = result / 10;

      sb.append(resultDigit);

      hasDigits &= columnsValid;
      i++;
    }
    String resultString = sb.reverse().toString();

    while (resultString.charAt(0) == '0' && resultString.length() > 1) {
      resultString = resultString.substring(1);
    }

    return resultString;
  }
}
