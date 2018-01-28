package main;

import java.util.ArrayList;

public class Piece 
{
	protected boolean player; //player 1 == true, player 2 == false
	protected Position position;
	protected int type; //-1 for no type, 0 for pikeman, 1 for knight, 2 for king
	
	public Piece(boolean play, Position location)
	{
		player = play;
		position = location;
		type = -1;
	}
	
	public Position getPosition()
	{
		return position;
	}
	
	public boolean getPlayer()
	{
		return player;
	}
	
	public int getType()
	{
		return type;
	}
	
	public Position setPosition(Position newPosition)
	{
		Position old = new Position(position.x(),position.y());
		position = newPosition;
		return old;
	}
	
	public ArrayList<Position> getMoves()
	{
		ArrayList<Position> moves = new ArrayList<Position>();
		moves.add(new  Position(position.x() - 1, position.y() - 1));
							moves.add(new  Position(position.x() - 1, position.y()));
							moves.add(new  Position(position.x() - 1, position.y() + 1));
							moves.add(new  Position(position.x(), position.y() - 1));
							moves.add(new  Position(position.x(), position.y() + 1));
							moves.add(new  Position(position.x() + 1, position.y() - 1));
							moves.add(new  Position(position.x() + 1, position.y()));
							moves.add(new  Position(position.x() + 1, position.y() + 1));
		return moves;
	}
	public Piece deepCopy()
	{
		Piece p = null;
		if(type == -1) p = new Piece(player, position);
		else if(type == 0)  p = new Pikeman(player, position);
		else if(type == 1)  p = new Knight(player, position);
		else if(type == 2)  p = new King(player, position);
		return p;
	}
	public String toString()
	{
		return "Piece at: "+ position.toString();
	}
}
