package othello;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class OthelloController {
	private class BoardMouseListener implements MouseListener{

		public void mouseClicked(MouseEvent e) {
			OthelloBoardPanel boardPanel = othelloView.getBoardPanel();
			int x = (e.getX() * 8) / boardPanel.getWidth();
			int y = (e.getY() * 8) / boardPanel.getHeight();
			//No need to repaint the board if we don't have anything new to draw
			if(othelloModel.placePiece(x, y)){
				boardPanel.repaint();
				othelloView.changeTurn();
			}
			else{
				//TODO Present to the player that the move was invalid
			}
		}

		//Don't care
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		//Don't care
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		//Don't care
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		//Don't care
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
	
	private OthelloWindow othelloView;
	private OthelloBoard othelloModel;
	
	public OthelloController(OthelloWindow	window, OthelloBoard board){
		BoardMouseListener mouseListener = new BoardMouseListener();
		window.getBoardPanel().addMouseListener(mouseListener);
		othelloView = window;
		othelloModel = board;
	}

	public OthelloBoardPanel getBoard() {
		return othelloView.getBoardPanel();
	}
	
}
