package challenge.logs;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Logs {

  private static final Pattern PATTERN = Pattern.compile("^[\\d]+$");

  public String[] orderLogs(String[] logs) {

    List<String[]> digits = new ArrayList<>();
    SortedMap<String, String[]> letters = new TreeMap<>();

    for (String l : logs) {

      String[] split = l.split(" ");

      if (isDigit(split[1])) {
        digits.add(split);
      } else {
        String toOrder = String.join(" ", Arrays.copyOfRange(split, 1, split.length)) + " " + split[0];
        letters.put(toOrder, split);
      }
    }

    List<String[]> sorted = new ArrayList<>(letters.values());
    sorted.addAll(digits);

    List<String> result = new ArrayList<>();

    for (String[] arr : sorted) {
      result.add(String.join(" ", arr));
    }

    return result.toArray(new String[0]);
  }

  private boolean isDigit(String value) {
    Matcher matcher = PATTERN.matcher(value);
    return matcher.matches();
  }

}
