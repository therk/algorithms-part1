import java.util.Scanner;

class DynamicConnectivity {
	public static void main(String[] args) {
		Scanner in = new Scanner(new java.io.BufferedInputStream(System.in), "UTF-8");
		System.out.println("Enter the size:");
		int size = 0;
		try {
			size = in.nextInt();
		} catch (java.util.InputMismatchException e) {
			System.out.println("Exit!");
			System.exit(0);
		} catch (Exception e) {
			System.out.println("Errror: " + e);
			System.exit(1);
		}
		UF uf = new QuickFindUF(size);
		
		int p=0, q=0;
		while (true) {
			System.out.println("Enter two integers:");
			try {
				p = in.nextInt();
				q = in.nextInt();
			} catch (java.util.InputMismatchException e) {
				System.out.println("Exit!");
				System.exit(0);
			} catch (Exception e) {
				System.out.println("Errror: " + e);
				System.exit(1);
			}
			if (!uf.connected(p, q)) {
				uf.union(p, q);
				System.out.println(p + " " + q);
			}
		}
	}
}