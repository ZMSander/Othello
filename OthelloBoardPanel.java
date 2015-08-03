package othello;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JPanel;

public class OthelloBoardPanel extends JPanel {
	
	private OthelloBoard board;
		
	public OthelloBoard getBoard() {
		return board;
	}

	public OthelloBoardPanel(OthelloBoard board){
		super();
		this.board = board;
	}
	
	public void drawBoard(Graphics g){
		
		int MAXX = this.getWidth();
		int MAXY = this.getHeight();
		
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.GREEN);
		g2d.fillRect(0, 0, MAXX, MAXY);
		
				
		//Draw grid lines
		g2d.setColor(Color.BLACK);
		g2d.drawRect(0, 0, MAXX-1, MAXY-1);
		for (int i = 1; i<=8; i++){
			int xVal = (MAXX * i)/8;
			int yVal = (MAXY * i)/8;
			g2d.drawLine(0, yVal, MAXX, yVal);
			g2d.drawLine(xVal, 0, xVal, MAXY);
		}
		
	}
	
	public void drawPieces(Graphics g){
		//This should be passed to the method
		ArrayList<Coordinate> pieces = new ArrayList<Coordinate>();
		
		int width = this.getWidth();
		int height = this.getHeight();
		
		//Test Code
		pieces.add(new Coordinate(4,4));

		Graphics2D g2d = (Graphics2D) g;
		for (int r = 0; r<8; r++){
			for (int c = 0; c<8; c++){
				OthelloPiece p = board.getSquare(r, c);
				if (p != null){
					if (p == OthelloPiece.BLACK){
						g2d.setColor(Color.BLACK);
					}
					else if (p == OthelloPiece.WHITE){
						g2d.setColor(Color.WHITE);
					}
					int x = (r * width)/8;
					int y = (c * height)/8;
					g2d.fillOval(x, y, (width/8), (height/8));
				}
			}	
		}
	}
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		drawBoard(g);
		drawPieces(g);
	}
	
}
