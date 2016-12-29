class QuickFindUF extends UF {
	QuickFindUF(int size) {
		super(size);
	}

	public void union(int p, int q) {
		int group = data[p];
		for (int i = 0; i < data.length; i++) {
			if (data[i] == group) {
				data[i] = data[q];
			}
		}
	}

	public boolean connected(int p, int q) {
		return data[p] == data[q];
	}
}