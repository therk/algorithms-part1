import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by therk on 1/2/17.
 */
public class AlgsTest {

  @Rule
  public MyJUnitWatcher watcher = new MyJUnitWatcher();

  @Test
  public void threeSumCount() throws Exception {
    assertEquals(4, Algs.threeSumCount(new int[]{30, -40, -20, -10, 40, 0, 10, 5}));
  }

  @Test
  public void binarySearch() throws Exception {
    assertEquals(4, Algs.binarySearch(new int[]{1, 2, 3, 4, 5, 6, 7}, 4));
    assertEquals(7, Algs.binarySearch(new int[]{1, 2, 3, 4, 5, 6, 7}, 7));
    assertEquals(1, Algs.binarySearch(new int[]{1, 2, 3, 4, 5, 6, 7}, 1));
    assertEquals(-1, Algs.binarySearch(new int[]{1, 2, 3, 4, 5, 6, 7}, 8));
  }

}