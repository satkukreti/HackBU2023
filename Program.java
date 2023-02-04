import java.io.IOException;

class Program {
	
	public static void main(String[] args) {
		// System.out.println("\u001b[1mThis should be colored different\u001b[0m");
		// System.out.println("\u001b[9mThis should be struck through\u001b[29m");
		// System.out.println("\u001b[9AAAAAAAAAAAAAAAAUUUUUUUUUUUUGGGGGGGGGHHHH");
		//
		int[] terminalSize = new int[1];
		try {
			terminalSize = getTerminalSize();
		} catch (IOException e) {
			terminalSize[0] = 10;
			terminalSize[1] = 10;
		}
		
		Vector[][] v = new Vector[10][];
		for (int i = 0; i < v.length;i++) {
			v[i] = new Vector[10];
			for (int j = 0; j < v[0].length;j++){
				if (i==j) v[i][j] = new Vector(0);
				else v[i][j] = new Vector(1);
			}
		}
		int permutation = 0;
		while (true) {
			draw(v);
			if (v[permutation][permutation].color ==1) v[permutation][permutation].color = 0;
			else v[permutation][permutation].color = 1;
			permutation++;
			permutation %=10;

		}
	}
	private static class Vector {
		public int color = 0;
		public Vector(int color) {
			this.color = color;
		}
	}
	private static void draw(Vector[][] v) {
		System.out.print("\u001b[?25l");
			System.out.print("\u001b[" + v.length + "A");
			for (int i = 0; i < v.length;i++) {
				for (int j = 0; j < v[0].length; j++) {
					if (v[i][j].color == 1) {
						System.out.print("0");
					}
					else {
						System.out.print(" ");
					}
				}
				System.out.println();
			}
	}
	private static int[] getTerminalSize() throws IOException {
		final var sb = new StringBuilder();
		while (System.in.available() != -1) {
			char ch = (char) System.in.read();
			System.out.println(ch);
			if (ch == 'R')
				break;
			if (Character.isDigit(ch) || ch == ';')
				sb.append(ch);
		}
		String[] rowColumn = sb.toString().split(";");
		int[] result = new int[1];
		result[0] = Integer.parseInt(rowColumn[0]);
		result[1] = Integer.parseInt(rowColumn[1]);
		return result;

	}




}
