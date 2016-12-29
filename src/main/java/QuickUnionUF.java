class QuickUnionUF extends UF {
	QuickUnionUF(int size) {
		super(size);
	}

	public void union(int p, int q) {
		int pRoot = findRoot(data[p]);
		data[pRoot] = findRoot(data[q]);
	}

	public boolean connected(int p, int q) {
		return findRoot(data[p]) == findRoot(data[q]);
	}

	private int findRoot(int node) {
		if (data[node] == node) {
			return node;
		} 
		return findRoot(data[node]);
	}
}