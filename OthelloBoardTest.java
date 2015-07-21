package othello;

import static org.junit.Assert.*;

import org.junit.Test;

public class OthelloBoardTest {

	@Test
	public void testOthelloBoard() {
		OthelloBoard testBoard = new OthelloBoard();
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
		fail("Not yet implemented");
	}

	@Test
	public void testCheckValidPlacement() {
		fail("Not yet implemented");
	}

	@Test
	public void testHasMove() {
		fail("Not yet implemented");
	}

	@Test
	public void testSwitchActivePlayer() {
		fail("Not yet implemented");
	}

}
