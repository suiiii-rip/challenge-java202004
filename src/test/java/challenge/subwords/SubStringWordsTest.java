package challenge.subwords;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class SubStringWordsTest {

  private SubStringWords f;

  @Before
  public void setUp() throws Exception {
    f = new SubStringWords();
  }

  @Test
  public void find1() {

    String s = "barfoothefoobarman";
    String[] words = {"foo", "bar"};

    Set<Integer> result = new HashSet<>(Arrays.asList(0, 9));

    assertEquals(result, f.find(s, words));

  }


  @Test
  public void find_interveningChar() {

    String s = "obarfootefoobarmn";
    String[] words = {"foo", "bar"};

    Set<Integer> result = new HashSet<>(Arrays.asList(1, 9));

    assertEquals(result, f.find(s, words));

  }

    @Test
  public void find_directFollower() {

    String s = "obarfoofoobarmn";
    String[] words = {"foo", "bar"};

    Set<Integer> result = new HashSet<>(Arrays.asList(1, 7));

    assertEquals(result, f.find(s, words));

  }

  @Test
  public void find2() {

    String s = "wordgoodgoodgoodbestword";
    String[] words = {"word", "good", "best", "word"};

    Set<Integer> result = Collections.emptySet();

    assertEquals(result, f.find(s, words));

  }

  @Test
  public void find_duplicateWord() {

    String s = "wordgoodbestword";
    String[] words = {"word", "good", "best", "word"};

    Set<Integer> result = Collections.singleton(0);
    assertEquals(result, f.find(s, words));
  }

  @Test
  public void find_emptyString() {

    String s = "";
    String[] words = {"word", "good", "best", "word"};

    Set<Integer> result = Collections.emptySet();
    assertEquals(result, f.find(s, words));
  }

  @Test
  public void find_emptyWords() {

    String s = "wordgoodbestword";
    String[] words = {};

    Set<Integer> result = Collections.emptySet();
    assertEquals(result, f.find(s, words));
  }
}