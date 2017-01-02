import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by therk on 1/2/17.
 */
public class AlgsTest {

  private static final double DELTA = 0.01;

  @Rule
  public MyJUnitWatcher watcher = new MyJUnitWatcher();

  @Test
  public void solveArithmeticExpressionJustNumber() throws Exception {
    assertEquals(2, Algs.solveArithmeticExpression("2"), DELTA);
  }

  @Test
  public void solveArithmeticExpressionSimpleAddition() throws Exception {
    assertEquals(4, Algs.solveArithmeticExpression("2+2"), DELTA);
  }

  @Test
  public void solveArithmeticExpressionSimpleWithParenthesis() throws Exception {
    assertEquals(4, Algs.solveArithmeticExpression("(2+2)"), DELTA);
    assertEquals(8, Algs.solveArithmeticExpression("(2+2)*2"), DELTA);
  }

  @Test
  public void solveArithmeticExpressionWithLargeNumbers() throws Exception {
    assertEquals(40, Algs.solveArithmeticExpression("20+20"), DELTA);
  }


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