import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by therk on 1/1/17.
 */
public class PercolationTest {
  Percolation p2;

  @Before
  public void before() {
    p2 = new Percolation(2);
  }

  @Test(expected = IndexOutOfBoundsException.class)
  public void constructWithNegativeSize() {
    new Percolation(-1);
  }

  @Test(expected = IndexOutOfBoundsException.class)
  public void isOpenWithNegative() {
    p2.isOpen(-1, 1);
  }

  @Test(expected = IndexOutOfBoundsException.class)
  public void isOpenWithLargerThenSize() {
    p2.isOpen(3, 1);
  }

  @Test
  public void isOpen() throws Exception {
    assertEquals("Should be closed at the start", false, p2.isOpen(1, 1));
  }

  @Test
  public void open() throws Exception {
    p2.open(1, 1);
    assertEquals("Should be open after open", true, p2.isOpen(1, 1));
  }

  @Test
  public void isFull() throws Exception {
    assertEquals("Should not be full at the start", false, p2.isFull(1, 1));
    p2.open(1, 1);
    assertEquals("Should be full after the only slot is open", true, p2.isFull(1, 1));
  }

  @Test
  public void numberOfOpenSites() throws Exception {
    assertEquals("Should be 0 at the start", 0, p2.numberOfOpenSites());
    p2.open(1, 1);
    assertEquals("Should be 1 after single open", 1, p2.numberOfOpenSites());
    p2.open(1, 1);
    assertEquals("Should remain 1 if the same slot is marked as open", 1, p2.numberOfOpenSites());
  }

  @Test
  public void percolates() throws Exception {
    assertEquals("Should not percolate at the start", false, p2.percolates());
    p2.open(1, 1);
    assertEquals("Should percolate after the only slot is opened", true, p2.percolates());
  }

}