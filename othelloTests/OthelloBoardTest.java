package othello.othelloTests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import othello.Coordinate;
import othello.OthelloBoard;
import othello.OthelloPiece;

public class OthelloBoardTest {

	OthelloBoard testBoard;
	
	@Before
	public void setUp(){
		testBoard = new OthelloBoard();
	}
	
	@Test
	public void testOthelloBoard() {
		assertNull("There should not be a piece at 0,0 on the starting board", testBoard.getSquare(0, 0));
		assertEquals("The piece at 3,3 should start White", testBoard.getSquare(3, 3),OthelloPiece.WHITE);
		assertEquals("The piece at 3,4 should start Black", testBoard.getSquare(3, 4),OthelloPiece.BLACK);
		assertEquals("The piece at 4,3 should start Black", testBoard.getSquare(4, 3),OthelloPiece.BLACK);
		assertEquals("The piece at 4,4 should start White", testBoard.getSquare(4, 4),OthelloPiece.WHITE);
	}

	@Test
	public void testFindFlippablePieces() {
		OthelloBoard testBoard = new OthelloBoard();
		assertEquals("There should be no flippable pieces if black places at 0,0",
				0, testBoard.findFlippablePieces(0, 0).size());
		assertEquals("There should be no flippable pieces when checking an occupied space of the same color",
				0, testBoard.findFlippablePieces(3, 3).size());
		assertEquals("There should be no flippable pieces when checking an occupied space of the opposite color",
				0, testBoard.findFlippablePieces(3, 4).size());
		assertEquals("There should be no flippable pieces if black places at 2,4",
				0,testBoard.findFlippablePieces(2, 4).size());
		assertEquals("Black should be able to flip the piece 3,3",
				new Coordinate(3,3),testBoard.findFlippablePieces(2, 3).get(0));
	}
	
	@Test
	public void testPlacePiece() {
		assertFalse("Black should not be able to place a piece at 2,4", testBoard.placePiece(2, 4));
		assertNull("Black should not have placed a piece at 2,4", testBoard.getSquare(2, 4));
		assertTrue("Black should be able to place a piece at 3,2",testBoard.placePiece(3, 2));
		assertEquals("The piece at 3,2 should be black",testBoard.getSquare(3, 2),OthelloPiece.BLACK);
	}

	@Test
	public void testSwitchActivePlayer() {
		testBoard.switchActivePlayer();
		assertEquals("Not yet implemented", testBoard.getActivePlayer(), OthelloPiece.WHITE);
		testBoard.switchActivePlayer();
		assertEquals("Not yet implemented", testBoard.getActivePlayer(), OthelloPiece.BLACK);
	}
	
	@Test
	public void testCheckValidPlacement() {
		assertTrue("Black should be able to place a piece at 3,2", testBoard.checkValidPlacement(3, 2));
		assertFalse("A black piece should not be placed on a white piece.", testBoard.checkValidPlacement(3, 3));
		assertFalse("A black piece should not be placed on a black piece.", testBoard.checkValidPlacement(3, 4));
		assertFalse("A piece should not be able to be placed without any nearby pieces", testBoard.checkValidPlacement(0, 0));
		assertFalse("A black piece needs a white piece nearby to be placed", testBoard.checkValidPlacement(2, 4));
		testBoard.switchActivePlayer();
		assertTrue("White should be able to place a piece at 2,4", testBoard.checkValidPlacement(2, 4));
		assertFalse("White should not be able to place a piece at 3,2", testBoard.checkValidPlacement(3, 2));
	}

	@Test
	public void testHasMove() {
		assertTrue("Black should have a valid move on the default board", testBoard.hasMove(testBoard.getActivePlayer()));
		assertTrue("White should have a valid move on the default board", testBoard.hasMove(testBoard.getActivePlayer().opposite()));
		testBoard = new OthelloBoard(new OthelloPiece[8][8]);
		assertFalse("Black should not have a valid move on an empty board", testBoard.hasMove(testBoard.getActivePlayer()));
		assertFalse("White should not have a valid move on an empty board", testBoard.hasMove(testBoard.getActivePlayer().opposite()));
		//TODO Add more cases with other boards
	}

	

}
