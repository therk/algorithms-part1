import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

/*
 * @author therk
 */
public class QuickUnionTest {

	@Test public void testTwoUnionsConnected() {
		UF uf = new QuickUnionUF(3);
		uf.union(0, 1);
		uf.union(1, 2);
		assertTrue("Connected 0 and 2 should return 'true'", uf.connected(0, 2));
	}

	@Test
	public void testWeightedQuickUnion() {
		UF uf = new QuickUnionUF(10);
		uf.union(4, 3);
		uf.union(3, 8);
		uf.union(6, 5);
		uf.union(9, 4);
		uf.union(2, 1);
		uf.union(5, 0);
		uf.union(7, 2);
		uf.union(6, 1);
		uf.union(7, 3);
		assertArrayEquals("Test that we used optimized weighted quick union, where we avoid putting the large tree lower",
				uf.getData(),
				new int[]{6, 2, 6, 4, 6, 6, 6, 2, 4, 4});
	}
}
