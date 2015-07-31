package othello;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class OthelloBoardDrawPanel extends JPanel {
	
	public OthelloBoardDrawPanel(){
		super();
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
		
	}
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		drawBoard(g);
		drawPieces(g);
	}
	
}
