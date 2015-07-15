package othello;

import java.util.ArrayList;

import othello.OthelloBoard.Piece;

public class OthelloBoard {

	private enum Piece {
		WHITE, BLACK;
		public Piece opposite(){
			switch(this){
			case WHITE: return BLACK;
			case BLACK: return WHITE;
			}
		}
	}
	
	private Piece[][] board;
	private Piece activePlayer;
	
	public OthelloBoard(){
		this.board = new Piece[8][8];
		board[3][3] = Piece.WHITE;
		board[4][4]	= Piece.WHITE;
		board[3][4] = Piece.BLACK;
		board[4][3]	= Piece.BLACK;
		activePlayer = Piece.BLACK;
	}
	
	/**
	 * 
	 * @param c column the piece is to be place in
	 * @param r row the piece is to be placed in
	 * @return	if a piece was placed
	 */
	public boolean placePiece(int c, int r){
		ArrayList<Piece[][]> flip = findFlippablePieces(c,r);
		if (flip != null){
			for (int i = 0; flip.get(i) != null; i++){
				board[flip.get(i)][flip.get(i)] = activePlayer;
			}
			switchActivePlayer();
			return true;
			this.board[x][y] = activePlayer;
		}
		else
			return false;
	}
	
	/**
	 * Determine if the placement on the board is valid.
	 * If a single row would flip, return true.
	 * @return a list of pieces to flip. If the returned list is empty, the move is invalid
	 */
	public boolean checkValidPlacement(int c, int r){
		ArrayList<Piece[][]> flippablePieces = new ArrayList<Piece[][]>();
		Piece nextPiece = board[c+1][r];
		while(nextPiece == activePlayer.opposite()){
			
		}
		
		return false;
	}
	
	/**
	 * Determine if the placement
	 * @return A list of pieces to flip. If the returned list is empty, the move is invalid
	 */
	public ArrayList<Piece[][]> findFlippablePieces(int c, int r){
		ArrayList<Piece[][]> flippablePieces = new ArrayList<Piece[][]>();
		
		int x = c++;
		int y = r;
		
		// Check the right horizontal
		Piece nextPiece = board[c+1][r];
		while(nextPiece == activePlayer.opposite()){
			
			nextPiece = board[c++][r];
		}
		
		// Check the up-right diagonal
		nextPiece = board[c+1][r-1];
		
		// Check the upper vertical
		nextPiece = board[c][r-1];
		
		// Check the up-left diagonal
		nextPiece = board[c-1][r-1];
		
		// Check the left horizontal
		nextPiece = board[c-1][r];
		
		// Check the down-left diagonal
		nextPiece = board[c-1][r+1];
		
		// Check the lower vertical
		nextPiece = board[c][r+1];
		
		// Check the down-right diagonal
		nextPiece = board[c][r+1];
		
		return flippablePieces;
	}
	
	/**
	 * Check if the active player has a valid move.
	 * This method returns true if the active player has a valid move, 
	 * and false if the active player does not.
	 * @return 	if the active player has a valid move
	 */
	public boolean HasMove(){
		//TODO: Make this cleaner so it doesn't have to check every single space until it finds a working one.
		for (int r = 0;;r++){
			for (int c = 0;;c++){
				if (checkValidPlacement(r,c)){
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * Switch the active player
	 */
	public void switchActivePlayer(){
		activePlayer = activePlayer.opposite();
		
	}
	
}
