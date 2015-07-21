package othello;

public class Coordinate {
	private int x;
	private int y;
	
	public Coordinate(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Not sure if this constructor should exist
	 */
	public Coordinate(){
		this.x = 0;
		this.y = 0;
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
}
