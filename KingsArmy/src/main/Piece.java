package main;

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
	
	public Position[] getMoves()
	{
		Position[] moves = {new Position(position.x() - 1,position.y() - 1),
							new Position(position.x() - 1,position.y()),
							new Position(position.x() - 1,position.y() + 1),
							new Position(position.x(),position.y() - 1),
							new Position(position.x(),position.y() + 1),
							new Position(position.x() + 1,position.y() - 1),
							new Position(position.x() + 1,position.y()),
							new Position(position.x() + 1,position.y() + 1)};
		return moves;
	}
}
