package challenge.reversekgroup;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import static challenge.reversekgroup.Node.*;

public class ReverseNodesTest {

  private ReverseNodes r;

  @Before
  public void setUp() throws Exception {

    r = new ReverseNodes();

  }

  @Test
  public void reverse_example1() {

    Node list = n(1, n(2, n(3, n(4, n(5, NIL)))));
    int k = 2;

    Node result = n(2, n(1, n(4, n(3, n(5, NIL)))));

    assertEquals(result, r.reverse(list, k));
  }

  @Test
  public void reverse_example2() {

    Node list = n(1, n(2, n(3, n(4, n(5, NIL)))));
    int k = 3;

    Node result = n(3, n(2, n(1, n(4, n(5, NIL)))));

    assertEquals(result, r.reverse(list, k));
  }

  @Test
  public void reverse_empty() {

    Node list = NIL;
    int k = 0;

    Node result = NIL;

    assertEquals(result, r.reverse(list, k));
  }

  @Test
  public void reverse_maxK() {

    Node list = n(1, n(2, n(3, n(4, n(5, NIL)))));
    int k = 5;

    Node result = n(5, n(4, n(3, n(2, n(1, NIL)))));

    assertEquals(result, r.reverse(list, k));
  }

  @Test
  public void reverse_kZero() {

    Node list = n(1, n(2, n(3, n(4, n(5, NIL)))));
    int k = 0;

    assertEquals(list, r.reverse(list, k));
  }
}