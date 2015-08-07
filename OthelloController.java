package othello;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class OthelloController {
	//TODO Should this not be a mouselistener if we only want one of its method?
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
		public void mouseEntered(MouseEvent e) {}		
		//Don't care
		public void mouseExited(MouseEvent e) {}
		//Don't care
		public void mousePressed(MouseEvent e) {}
		//Don't care
		public void mouseReleased(MouseEvent e) {}
	}
	
	private class PassButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if (othelloModel.passTurnWithoutMoving()){
				othelloView.changeTurn();
			}
		}
	}
	
	private OthelloWindow othelloView;
	private OthelloBoard othelloModel;
	
	public OthelloController(OthelloWindow	window, OthelloBoard board){
		BoardMouseListener boardListener = new BoardMouseListener();
		window.getBoardPanel().addMouseListener(boardListener);
		PassButtonListener passButtonListener = new PassButtonListener();
		window.getPassButton().addActionListener(passButtonListener);
		othelloView = window;
		othelloModel = board;
	}

	public OthelloBoardPanel getBoard() {
		return othelloView.getBoardPanel();
	}
	
}
