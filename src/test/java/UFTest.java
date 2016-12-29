import org.junit.Test;
import static org.junit.Assert.*;

/*
 * @author therk, @date 12/28/16 4:35 PM
 */
public class UFTest {
		@Test public void testGetData() {
        UF uf = new UF(2);
        assertArrayEquals("Make sure we get correct data back for size 2 UF", uf.getData(), new int[]{0,1});
    }

    @Test public void testSimpleUnionAndConnected() {
        UF uf = new UF(2);
        uf.union(0, 1);
        assertTrue("Connected 1 and 2 should return 'true'", uf.connected(0, 1));
    }
}