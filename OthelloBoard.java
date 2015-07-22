package othello;

import java.util.ArrayList;
import java.util.Iterator;


/**
 * @author Zachary Sander
 *
 */
/**
 * @author Zachary Sander
 *
 */
public class OthelloBoard {

	private enum Direction {
		RIGHT,UPRIGHT,UP,UPLEFT,LEFT,DOWNLEFT,DOWN,DOWNRIGHT;
	}
	
	private OthelloPiece[][] board;
	// Active player is used to define which players turn it is
	private OthelloPiece activePlayer;
	
	public OthelloPiece getActivePlayer() {
		return activePlayer;
	}

	// Create an Othello Board with the default layout. Black always moves first.
	public OthelloBoard(){
		this.board = new OthelloPiece[8][8];
		board[3][3] = OthelloPiece.WHITE;
		board[4][4]	= OthelloPiece.WHITE;
		board[3][4] = OthelloPiece.BLACK;
		board[4][3]	= OthelloPiece.BLACK;
		activePlayer = OthelloPiece.BLACK;
	}
	
	/**
	 * This constructor is used to create a board other than the default.
	 * Black still moves first by default.
	 * @param board An Othello board to use
	 */
	public OthelloBoard(OthelloPiece[][] board){
		this.board = board;
		this.activePlayer = OthelloPiece.BLACK;
	}
	
	public OthelloBoard(OthelloPiece[][] board, OthelloPiece activePlayer){
		this.board = board;
		this.activePlayer = activePlayer;
	}
	
	public OthelloPiece getSquare(int r, int c){
		return board[r][c];
	}
	
	public OthelloPiece getSquare(Coordinate c){
		return board[c.getX()][c.getY()];
	}
	
	/**
	 * 
	 * @param c column the piece is to be place in
	 * @param r row the piece is to be placed in
	 * @return	if a piece was placed
	 */
	public boolean placePiece(int c, int r){
		ArrayList<Coordinate> flip = findFlippablePieces(c,r);
		//TODO Refactor code so that an emptylist is an invalid move,
		// and never have a null here.
		if (flip != null && !flip.isEmpty()){
			board[c][r] = activePlayer;
			Iterator<Coordinate> flipIter = flip.iterator();
			while (flipIter.hasNext()){
				Coordinate nextFlip = flipIter.next();
				board[nextFlip.getX()][nextFlip.getY()] = activePlayer;
			}
			//TODO Should the switch active player method check if there is a valid move?
			switchActivePlayer();
			return true;
		}
		else
			return false;
	}
	
	/**
	 * Determine if the placement on the board is valid.
	 * If a single row would flip, return true.
	 * Note this method is different than findFlippablePieces,
	 * which acts similarly, but has to find and return all pieces to flip
	 * @return  If the placement is valid.
	 */
	public boolean checkValidPlacement(int c, int r){
		if (board[c][r] == null){
			for (Direction d : Direction.values()){
				if(checkPiecesInDirection(c, r, d)){
					return true;
				}
			}
		}	
		return false;
	}
	
	/**
	 * A helper method for checkValidPlacement. Check in a direction
	 * if pieces can be flipped.
	 * @param d The direction to check.
	 * @return  If pieces can be flipped in Direction d.
	 */
	private Boolean checkPiecesInDirection(int c, int r, Direction d){
		int xOff;
		int yOff;
		switch(d){
		case RIGHT: xOff = 1; yOff = 0; break;
		case UPRIGHT: xOff = 1; yOff = -1; break;
		case UP: xOff = 0; yOff = -1; break;
		case UPLEFT: xOff = -1; yOff = -1; break;
		case LEFT: xOff = -1; yOff = 0; break;
		case DOWNLEFT: xOff = -1; yOff = 1; break;
		case DOWN: xOff = 0; yOff = 1; break;
		case DOWNRIGHT: xOff = 1; yOff = 1; break;
		// This should never occur because all cases are covered.
		default: xOff = 0; yOff = 0;
		}
		Boolean atLeastOneBetween = false;
		
		// The location to check needs to exist
		for (int x=c+xOff, y=r+yOff;(0<=x && x<8) && (0<=y &&y<8);x+=xOff, y+=yOff){
			OthelloPiece nextPiece = board[x][y];
			if (nextPiece == null){
				return false;
			}
			if (nextPiece == activePlayer){
				if(atLeastOneBetween){
					return true;
				}
				else{
					return false;
				}
			}
			else if(!atLeastOneBetween){
				atLeastOneBetween = true;
			}			
		}
		// We followed a line to the end of the board 
		// and never found another piece in our color
		return false;
	}
	
	/**
	 * Determine if the placement
	 * @return A list of pieces to flip. If the returned list is empty, the move is invalid
	 */
	public ArrayList<Coordinate> findFlippablePieces(int c, int r){
		ArrayList<Coordinate> flippablePieces = new ArrayList<Coordinate>();
		// If we try to place the piece on an occupied square, it is not a valid move
		if (board[c][r] != null){
			return flippablePieces;
		}
		for (Direction d : Direction.values()){
			//TODO This may throw a null pointer exception. Deal with it.
			ArrayList<Coordinate> dFlipable = findFlippableInDirection(c, r, d);
			if (!dFlipable.isEmpty()){
				flippablePieces.addAll(dFlipable);
			}
		}		
		return flippablePieces;
	}
	
	private ArrayList<Coordinate> findFlippableInDirection(int c, int r, Direction d){
		int xOff;
		int yOff;
		switch(d){
		case RIGHT: xOff = 1; yOff = 0; break;
		case UPRIGHT: xOff = 1; yOff = -1; break;
		case UP: xOff = 0; yOff = -1; break;
		case UPLEFT: xOff = -1; yOff = -1; break;
		case LEFT: xOff = -1; yOff = 0; break;
		case DOWNLEFT: xOff = -1; yOff = 1; break;
		case DOWN: xOff = 0; yOff = 1; break;
		case DOWNRIGHT: xOff = 1; yOff = 1; break;
		// This should never occur because all cases are covered.
		default: xOff = 0; yOff = 0;
		}
		ArrayList<Coordinate> returnPieces = new ArrayList<Coordinate>();
		
		// The location to check needs to exist
		for (int x =c+xOff, y=r+yOff;(0<=x && x<8) && (0<=y &&y<8);x+=xOff, y+=yOff){
			OthelloPiece nextPiece = board[x][y];
			if(nextPiece == activePlayer.opposite()){
				returnPieces.add(new Coordinate(x,y));
			}
			else if (nextPiece == activePlayer && !returnPieces.isEmpty()){
				return returnPieces;
			}
			else {
				break;
			}
		}
		// There are no pieces to return, so return an empty list
		return new ArrayList<Coordinate>();
	}
	
	/**
	 * Check if the active player has a valid move.
	 * This method returns true if the active player has a valid move, 
	 * and false if the active player does not.
	 * @return 	if the active player has a valid move
	 */
	public boolean hasMove(OthelloPiece player){
		//TODO: Make this cleaner so it doesn't have to check every single space until it finds a working one.
		for (int r = 0;r<8;r++){
			for (int c = 0;c<8;c++){
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
		//TODO Should this code actually be in the GUI? Does the board care?
		activePlayer = activePlayer.opposite();
	}
	
	/**
	 * Switch the active player, but check that their is a valid move first.
	 * If there is no valid move for either player, end the game.
	 */
	public void passTurn(){
		if (hasMove(activePlayer.opposite())){
			activePlayer = activePlayer.opposite();
			}
		else if (!hasMove(activePlayer)){
			endGame();
		}
	}
	
	public void endGame(){
		
	}
	
}
