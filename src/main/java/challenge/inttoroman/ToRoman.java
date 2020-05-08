package challenge.inttoroman;

import java.util.*;

public class ToRoman {

  public static final SortedMap<Integer, String> SYMBOLS;

  static {
    TreeMap<Integer, String> baseSymbols = new TreeMap<Integer, String>() {{
      put(1, "I");
      put(5, "V");
      put(10, "X");
      put(50, "L");
      put(100, "C");
      put(500, "D");
      put(1000, "M");
    }};

    Iterator<Map.Entry<Integer, String>> iterator = baseSymbols.entrySet().iterator();
    TreeMap<Integer, String> computedSymbols = new TreeMap<>(Comparator.reverseOrder());

    Map.Entry<Integer, String> first = iterator.next();
    Map.Entry<Integer, String> second;

    while(iterator.hasNext()) {
      second = iterator.next();
      String roman = first.getValue() + second.getValue();
      int num = second.getKey() - first.getKey();

      computedSymbols.put(num, roman);

      if (Math.log10(second.getKey()) % 1 == 0) {
        first = second;
      }
    }

    computedSymbols.putAll(baseSymbols);
    SYMBOLS = Collections.unmodifiableSortedMap(computedSymbols);
  }

  public String convert(int number) {
    if (number == 0) {
      return "";
    }

    Integer key = SYMBOLS.tailMap(number).firstKey();
    String roman = SYMBOLS.get(key);
    return roman + convert(number - key);
  }
}
