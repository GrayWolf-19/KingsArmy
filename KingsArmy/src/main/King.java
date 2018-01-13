package main;

public class King extends Piece
{
	public King(boolean play, Position location)
	{
		super(play,location);
		type = 2;
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
