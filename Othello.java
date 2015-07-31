package othello;

public class Othello {

	public static void main(String[] args) {
		OthelloBoard gameBoard = new OthelloBoard();
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			
			public void run() {
				OthelloGUI gui = new OthelloGUI();
			}
		});
	}

}
