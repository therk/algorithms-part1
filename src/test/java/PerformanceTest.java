import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.Random;

/**
 * Created by therk on 12/31/16.
 */
public class PerformanceTest {
  private static int MAX_SIZE = 10;
  @Rule
  public MyJUnitWatcher watcher = new MyJUnitWatcher();
  private QuickFindUF uf;

  @Before
  public void before() {
    uf = new QuickFindUF(MAX_SIZE);
  }

  @Test
  public void QuickFindMillonRendomUnionsTest() {
    Random rand = new Random();
    for (int i = 0; i < MAX_SIZE; i++) {
      uf.union(rand.nextInt(MAX_SIZE), rand.nextInt(MAX_SIZE));
    }
  }

  @Test
  public void QuickFind1MillionFindTest() {
    for (int i = 0; i < MAX_SIZE; i = i * i) {
      for (int j = 0; j < MAX_SIZE; j = j * (j + 1)) {
        uf.connected(i, j);
      }
    }
  }


}
