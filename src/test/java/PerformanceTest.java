import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.Random;

/**
 * Created by therk on 12/31/16.
 */
public class PerformanceTest {
  private static int MAX_SIZE = 10000;
  @Rule
  public MyJUnitWatcher watcher = new MyJUnitWatcher();
  private QuickFindUF uf;

  @Before
  public void before() {
    uf = new QuickFindUF(MAX_SIZE);
  }

  @Test
  public void QuickFind10KRendomUnionsTest() {
    Random rand = new Random();
    for (int i = 0; i < MAX_SIZE; i++) {
      uf.union(rand.nextInt(MAX_SIZE), rand.nextInt(MAX_SIZE));
    }
  }

  @Test
  public void QuickFind10KConnectedTest() {
    int sqrtMax = (int) Math.sqrt(MAX_SIZE);
    for (int i = 0; i < sqrtMax; i++) {
      for (int j = 0; j < sqrtMax; j++) {
        uf.connected(i, j);
      }
    }
  }


}
