package challenge.logs;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class LogsTest {

  private Logs l;

  @Before
  public void setUp() throws Exception {

    l = new Logs();

  }

  @Test
  public void orderLogs() {

    String[] arr = new String[] {"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"};
    String[] result = new String[] {"let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"};

    assertArrayEquals(result, l.orderLogs(arr));

  }
}