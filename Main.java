package othello;

public class Main {

	public static void main(String[] args) {
		OthelloBoard gameBoard = new OthelloBoard();
		OthelloWindow window = new OthelloWindow(gameBoard);
		OthelloController controller = new OthelloController(window, gameBoard);
		window.pack();
		window.setVisible(true);
		
		/*javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				OthelloGUI gui = new OthelloGUI(gameBoard);
			}
		});*/
	}

}
