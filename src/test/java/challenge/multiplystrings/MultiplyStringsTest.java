package challenge.multiplystrings;

import org.junit.Before;
import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.*;

public class MultiplyStringsTest {

  private MultiplyStrings m;

  @Before
  public void setUp() throws Exception {

    m = new MultiplyStrings();

  }

  @Test
  public void multiply() {
    String a = "2";
    String b = "3";
    String result = "6";

    assertEquals(result, m.multiply(a, b));
  }

  @Test
  public void multiply_2() {
    String a = "123";
    String b = "456";
    String result = "56088";

    assertEquals(result, m.multiply(a, b));
  }


  @Test
  public void multiply_3() {
    String a = "123";
    String b = "4";
    String result = "" + Integer.parseInt(a) * Integer.parseInt(b);

    assertEquals(result, m.multiply(a, b));
  }

  @Test
  public void multiply_largeNumbers() {
    String a = "123346345267567237034567347465701235";
    String b = "436723450382028523357628902348135890619089063457982635";
    String result = new BigInteger(a).multiply(new BigInteger(b)).toString();


    assertEquals(result, m.multiply(a, b));
  }

  @Test
  public void multiply_zero() {
    String a = "123";
    String b = "0";
    String result = "0";

    assertEquals(result, m.multiply(a, b));
  }

  @Test
  public void multiply_empty() {
    String a = "";
    String b = "345346";
    String result = "0";

    assertEquals(result, m.multiply(a, b));
  }
}