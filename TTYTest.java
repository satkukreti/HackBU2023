import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Arrays;

public class TTYTest {
	public static void main(String[] args) throws Throwable {
		// Prints out e.g. "^[[30;120R" (=30 rows, 120 cols)
		// 1) simulate cursor moving to row 999, col 999
		// 2) request for cursor position
		System.out.println("\033[999;999H\033[6n");

		// The rows / columns of TTY will be printed out
		// --> however, I have to simulate VK_ENTER as it awaits my ENTER input
		// new Robot().keyPress(KeyEvent.VK_ENTER);

		// read the stdin "^[[30;120R" -> "30;120"
		final var sb = new StringBuilder();
		while (System.in.available() != -1) {
			char ch = (char) System.in.read();
			if (ch == 'R')
				break;
			if (Character.isDigit(ch) || ch == ';')
				sb.append(ch);
		}

		final var result = sb.toString();
		System.out.println("Result: " + result);

		final var rowsAndCols = result.split(";");
		System.out.println("Result (splitted): " + Arrays.toString(rowsAndCols));

		final var rows = Integer.valueOf(rowsAndCols[0]);
		final var cols = Integer.valueOf(rowsAndCols[1]);
		System.out.println("Rows: " + rows + ", Cols: " + cols);
	}
}