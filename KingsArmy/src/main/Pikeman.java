package main;

public class Pikeman extends Piece
{
	public Pikeman(boolean play, Position location)
	{
		super(play,location);
		type = 0;
	}
	
	public Position[] getMoves()
	{
		Position[] moves = new Position[3];
		if(player)
		{
			moves[0] = new Position(position.x() - 1,position.y() + 1);
			moves[1] = new Position(position.x(),position.y() + 1);
			moves[2] = new Position(position.x() + 1,position.y() + 1);
		}
		else
		{
			moves[0] = new Position(position.x() - 1,position.y() - 1);
			moves[1] = new Position(position.x(),position.y() - 1);
			moves[2] = new Position(position.x() + 1,position.y() - 1);
		}
		return moves;
	}
}
