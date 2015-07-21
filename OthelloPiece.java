package othello;

public enum OthelloPiece {
	WHITE, BLACK;
	public OthelloPiece opposite(){
		switch(this){
		case WHITE: return BLACK;
		case BLACK: return WHITE;
		default: return null;
		}
	}
}