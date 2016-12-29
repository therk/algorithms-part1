import org.junit.Test;
import static org.junit.Assert.*;

/*
 * @author therk
 */
public class QuickFindTest {
	@Test public void testGetDataOfSizeTwo() {
		UF uf = new QuickFindUF(2);
		assertArrayEquals("Make sure we get correct data back for size 2 UF", uf.getData(), new int[] {0, 1});
	}

	@Test public void testSimpleUnionAndConnected() {
		UF uf = new QuickFindUF(2);
		uf.union(0, 1);
		assertTrue("Connected 0 and 1 should return 'true'", uf.connected(0, 1));
	}
	@Test public void testTwoUnionsConnected() {
		UF uf = new QuickFindUF(3);
		uf.union(0, 1);
		uf.union(1, 2);
		assertTrue("Connected 0 and 2 should return 'true'", uf.connected(0, 2));
	}
}
