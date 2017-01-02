import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by therk on 1/2/17.
 */
public class StackOfItemsTest {

  StackOfItems<String> ss;

  @Before
  public void setUp() throws Exception {
    ss = new StackOfItems<>();
  }

  @Test
  public void push() throws Exception {
    ss.push("Test");
    ss.push(null);
  }

  @Test
  public void pop() throws Exception {
    ss.push("Test");
    assertEquals("Test", ss.pop());
  }

  @Test
  public void isEmpty() throws Exception {
    assertEquals(true, ss.isEmpty());
    ss.push("Test");
    assertEquals(false, ss.isEmpty());

  }

  @Test
  public void size() throws Exception {
    assertEquals(0, ss.size());
    ss.push("Test");
    assertEquals(1, ss.size());
    ss.pop();
    assertEquals(0, ss.size());
  }
}