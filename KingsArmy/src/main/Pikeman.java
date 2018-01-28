package main;

import java.util.ArrayList;

public class Pikeman extends Piece
{
	public Pikeman(boolean play, Position location)
	{
		super(play,location);
		type = 0;
	}
	
	public ArrayList<Position> getMoves()
	{
		ArrayList<Position> moves = new ArrayList<Position>();
		if(player)
		{
			moves.add(new Position(position.x() - 1,position.y() + 1));
			moves.add(new Position(position.x(),position.y() + 1));
			moves.add(new Position(position.x() + 1,position.y() + 1));
		}
		else
		{
			moves.add(new Position(position.x() - 1,position.y() - 1));
			moves.add(new Position(position.x(),position.y() - 1));
			moves.add(new Position(position.x() + 1,position.y() - 1));
		}
		return moves;
	}

	public String toString()
	{
		return "Pikeman at: "+ position.toString();
	}
}
