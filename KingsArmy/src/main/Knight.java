package main;

import java.util.ArrayList;

public class Knight extends Pikeman
{
	public Knight(boolean play, Position location)
	{
		super(play,location);
		type = 1;
	}
	
	public ArrayList<Position> getMoves()
	{
		ArrayList<Position> moves = new ArrayList<Position>();
		moves.add(new  Position(position.x() - 1,position.y() - 1));
		moves.add(new  Position(position.x() - 1,position.y()));
		moves.add(new  Position(position.x() - 1,position.y() + 1));
		moves.add(new  Position(position.x(), position.y() - 1));
		moves.add(new  Position(position.x(), position.y() + 1));
		moves.add(new  Position(position.x() + 1,position.y() - 1));
		moves.add(new  Position(position.x() + 1,position.y()));
		moves.add(new  Position(position.x() + 1,position.y() + 1));
		moves.add(new  Position(position.x() - 2,position.y() - 2));
		moves.add(new  Position(position.x() - 2,position.y()));
		moves.add(new  Position(position.x() - 2,position.y() + 2));
		moves.add(new  Position(position.x(), position.y() - 2));
		moves.add(new  Position(position.x(), position.y() + 2));
		moves.add(new  Position(position.x() + 2,position.y() - 2));
		moves.add(new  Position(position.x() + 2,position.y()));
		moves.add(new  Position(position.x() + 2,position.y() + 2));
		return moves;
	}

	public String toString()
	{
		return "Knight at: "+ position.toString();
	}
}
