package challenge.inttoroman;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ToRomanTest {


  private ToRoman r;

  @Before
  public void setUp() throws Exception {
    r = new ToRoman();
  }

  @Test
  public void convert() {
    int num = 3;
    String result = "III";

    assertEquals(result, r.convert(num));

  }

    @Test
  public void convert2() {
    int num = 4;
    String result = "IV";

    assertEquals(result, r.convert(num));

  }

 @Test
  public void convert3() {
    int num = 9;
    String result = "IX";

    assertEquals(result, r.convert(num));

  }

  @Test
  public void convert4() {
    int num = 58;
    String result = "LVIII";

    assertEquals(result, r.convert(num));

  }
  @Test
  public void convert5() {
    int num = 1994;
    String result = "MCMXCIV";

    assertEquals(result, r.convert(num));

  }

}