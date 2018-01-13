package main;

public class Knight extends Pikeman
{
	public Knight(boolean play, Position location)
	{
		super(play,location);
		type = 1;
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
							new Position(position.x() + 1,position.y() + 1),
							new Position(position.x() - 2,position.y() - 2),
							new Position(position.x() - 2,position.y()),
							new Position(position.x() - 2,position.y() + 2),
							new Position(position.x(),position.y() - 2),
							new Position(position.x(),position.y() + 2),
							new Position(position.x() + 2,position.y() - 2),
							new Position(position.x() + 2,position.y()),
							new Position(position.x() + 2,position.y() + 2)};
		return moves;
	}
}
