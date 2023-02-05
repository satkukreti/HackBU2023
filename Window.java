public class Window {
	private Pixel[][] printArray;
	// private final int terminalWidth;
	// private final int terminalHeight;
	Window(int terminalWidth, int terminalHeight) {
		// this.terminalHeight = terminalHeight;
		// this.terminalWidth = terminalWidth;

		this.printArray = new Pixel[terminalWidth][];
		for (int i=0; i<printArray.length; i++) {
			printArray[i] = new Pixel[terminalHeight];
		}
	}	
	public void updatePrintArray(int coordX, int coordY, Pixel newPoint) {
		printArray[coordX][coordY] = newPoint;
	}

	private void draw(boolean flip) {
		
		System.out.print("\u001b[?25l");
		System.out.print("\u001b[" + printArray.length + "A");
		for (int i = 0; i < printArray.length; i++) {
			for (int j = 0; j < printArray[0].length; j++) {
				Pixel currentPoint = printArray[i][j];
				if (!currentPoint.notBackground) {
					// ALlows the flicking of the things we want to draw
					if (flip) {
						System.out.print(currentPoint.color + currentPoint.shade
								+ "\u2588");
					} else {
						System.out.print(currentPoint.color + currentPoint.shade + " ");
					}
					
				} else {
					System.out.print(currentPoint.color + currentPoint.shade + "\u2588");
				}
			}
			System.out.println();
		}
	}
	public void print() {
		boolean flip = false;
		int flickerDuration = 0;
		while (true) {
			if (flickerDuration > 10) {
				flip = !flip;
				flickerDuration = 0;
			}
			this.draw(flip);
			flickerDuration++;
		}
	}
	public Pixel[][] getPrintArray() {
		return printArray;
	}
	
}
