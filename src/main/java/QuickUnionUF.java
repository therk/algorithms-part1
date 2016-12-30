class QuickUnionUF extends UF {
  private int[] rootSize;

  QuickUnionUF(int size) {
    super(size);
    rootSize = new int[size];
    for (int i = 0; i < size; i++) {
      rootSize[i] = 1;
    }
  }

	public void union(int p, int q) {
    int pRoot = root(p);
    int qRoot = root(q);

    if (pRoot == qRoot) return;

    if (rootSize[pRoot] < rootSize[qRoot]) {
      data[pRoot] = qRoot;
      rootSize[qRoot] += rootSize[pRoot];
    } else {
      data[qRoot] = pRoot;
      rootSize[pRoot] += rootSize[qRoot];
    }
  }

	public boolean connected(int p, int q) {
    return root(p) == root(q);
  }

  int rootSize(int id) {
    return rootSize[root(id)];
  }

  int root(int node) {
    if (data[node] == node) {
      return node;
    }
    return root(data[node]);
  }
}