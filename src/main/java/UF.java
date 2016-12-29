abstract class UF {
	int[] data;

	UF(int size) {
		data = new int[size];
		for (int i = 0; i < size; i++) {
			data[i] = i;
		}
	}

	public int[] getData() {
		return data;
	}

	abstract public boolean connected(int p, int q);

	abstract public void union(int p, int q);
}