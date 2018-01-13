package main;

public class Position 
{
	private int x,y;
	
	public Position(int xcoord, int ycoord)
	{
		x = xcoord;
		y = ycoord;
	}
	
	public int x()
	{
		return x;
	}
	
	public int y()
	{
		return y;
	}
	
	public boolean equals(Position newPos)
	{
		return this.x() == newPos.x() && this.y() == newPos.y();
	}
}
