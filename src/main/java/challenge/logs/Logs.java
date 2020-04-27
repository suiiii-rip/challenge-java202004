package challenge.logs;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Logs {

  private static final Pattern PATTERN = Pattern.compile("^[\\d\\s]+$");

  public String[] orderLogs(String[] logs) {

    Map<Boolean, List<Tuple<String, String>>> collect = Arrays.stream(logs)
      .map(s -> s.split(" "))
      .map(s -> new Tuple<>(s[0], String.join(" ", Arrays.copyOfRange(s, 1, s.length))))
      .collect(Collectors.partitioningBy(tuple -> isDigit(tuple.b)));

    Stream<Tuple<String, String>> letterLogs = collect.get(false).stream()
      .sorted(Comparator.comparing((Tuple<String, String> t) -> t.b).thenComparing(t -> t.a));

    return Stream.concat(letterLogs, collect.get(true).stream())
      .map(t -> t.a + " " + t.b)
      .toArray(String[]::new);
  }

  private boolean isDigit(String values) {
    Matcher matcher = PATTERN.matcher(values);
    return matcher.matches();
  }

  private static class Tuple<A, B> {
    private final A a;
    private final B b;

    Tuple(A a, B b) {
      this.a = a;
      this.b = b;
    }
  }

}
