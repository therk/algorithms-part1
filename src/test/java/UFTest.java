import org.junit.Test;
import static org.junit.Assert.*;

/*
 * @author therk, @date 12/28/16 4:35 PM
 */
public class UFTest {
    @Test public void testSimpleUnionAndConnected() {
        UF uf = new UF(1);
        uf.union(0, 1);
        assertTrue("Connected 1 and 2 should return 'true'", uf.connected(0, 1));
    }
}
