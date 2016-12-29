class QuickUnionUF extends UF {
	QuickUnionUF(int size) {
		super(size);
	}

	public void union(int p, int q) {
    Root pRoot = root(data[p]);
    Root qRoot = root(data[q]);

    if (pRoot.getSize() < qRoot.getSize()) {
      data[pRoot.getId()] = qRoot.getId();
    } else {
      data[qRoot.getId()] = pRoot.getId();
    }
  }

	public boolean connected(int p, int q) {
    return root(data[p]).getId() == root(data[q]).getId();
  }

  private Root root(int id) {
    return findRoot(id, 1);
  }

  private Root findRoot(int node, int size) {
    if (data[node] == node) {
      return new Root(node, size);
    }
    return findRoot(data[node], size + 1);
  }
}