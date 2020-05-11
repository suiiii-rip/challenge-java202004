package challenge.subwords;

import java.util.*;

public class SubStringWords {

  public Set<Integer> find(String s, String[] words) {

    if (words.length == 0) {
      return Collections.emptySet();
    }

    int numWords = words.length;
    int wordLength = 0;

    if (numWords > 0) {
      wordLength = words[0].length();
    }

    int subStringLength = numWords * wordLength;
    HashSet<Integer> result = new HashSet<>();

    for (int i = 0; i < s.length(); i++) {
      String substring = s.substring(i);
      boolean found = findWords(substring, Arrays.asList(words));

      if (found) {
        result.add(i);
        i += subStringLength - 1;
      }
    }

    return result;
  }

  private boolean findWords(String s, List<String> words) {

    if (words.isEmpty()) {
      return true;
    }
    if (s.isEmpty()) {
      return false;
    }

    for (String word : words) {
      if (s.startsWith(word)) {
        ArrayList<String> otherWords = new ArrayList<>(words);
        otherWords.remove(word);
        return findWords(s.substring(word.length()), otherWords);
      }
    }

    return false;
  }

}
