import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by therk on 1/1/17.
 */
public class PercolationStatsTest {

  private static final double DELTA = 0.3;
  PercolationStats ps1;

  @Before
  public void before() {
    ps1 = new PercolationStats(1000, 10);
  }

  @Test
  public void mean() throws Exception {
    assertEquals(0.593, ps1.mean(), DELTA);
  }

  @Test
  public void stddev() throws Exception {
    assertEquals(0.2, ps1.stddev(), DELTA);
  }

  @Test
  public void confidenceLo() throws Exception {
    assertEquals(0.593, ps1.confidenceLo(), DELTA);
  }

  @Test
  public void confidenceHi() throws Exception {
    assertEquals(0.593, ps1.confidenceHi(), DELTA);
  }
}