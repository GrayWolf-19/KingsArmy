package main;

//import java.util.ArrayList;

public class Space 
{
	private Position position;
	private Piece piece;
	
	public Space(Position coordinate)
	{
		position = coordinate;
		piece = null;
	}
	
	public Piece getPiece()
	{
		return piece;
	}
	
	public boolean isEmpty()
	{
		return piece == null;
	}
	
	public Position getPosition()
	{
		return position;
	}
	
	public Position setPiece(Piece newPiece)
	{
		piece = newPiece;
		if(piece != null)
			return piece.setPosition(position);
		else
			return null;
	}
	public Space deepCopy()
	{
		Space s = new Space(position);
		if(piece != null)
			s.setPiece(piece.deepCopy());
		else
			s.setPiece(null);
		return s;
	}
	public String toString()
	{
		return "Space at: "+ position.toString();
	}
}
