public class UF {
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

	public void union(int p, int q) {
		int group = data[p];
		for (int i = 0; i < data.length; i++) {
			if (data[i] == group) {
				data[i] = data[q];
			}
		}
	}

	public boolean connected(int p, int q) {
		return(data[p] == data[q]);
	}
}