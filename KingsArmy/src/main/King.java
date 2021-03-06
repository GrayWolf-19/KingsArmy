package main;

import java.util.ArrayList;

public class King extends Piece
{
	public King(boolean play, Position location)
	{
		super(play,location);
		type = 2;
	}
	
	public ArrayList<Position> getMoves()
	{
		ArrayList<Position> moves = new  ArrayList<Position>();
		moves.add(new  Position(position.x() - 1,position.y() - 1));
							moves.add(new  Position(position.x() - 1,position.y()));
							moves.add(new  Position(position.x() - 1,position.y() + 1));
							moves.add(new  Position(position.x(), position.y() - 1));
							moves.add(new  Position(position.x(), position.y() + 1));
							moves.add(new  Position(position.x() + 1,position.y() - 1));
							moves.add(new  Position(position.x() + 1,position.y()));
							moves.add(new  Position(position.x() + 1,position.y() + 1));
		return moves;
	}

	public String toString()
	{
		return "King at: "+ position.toString();
	}
}
