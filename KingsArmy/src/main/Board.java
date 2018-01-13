package main;

public class Board 
{
	private int size;
	private Space[][] board;
	
	public Board(int sizeOfBoard)
	{
		size = sizeOfBoard;
		initialize();
	}
	
	public void initialize()
	{
		for(int i = 0;i < size;i++)
			for(int j = 0;j < size;j++)
				board[i][j] = new Space(new Position(i,j));
	}
	
	public int getSize()
	{
		return size;
	}
	
	public Position[] getPiecesMoves(Position position)
	{
		if(board[position.x()][position.y()].getPiece() != null)
			return board[position.x()][position.y()].getPiece().getMoves();
		else
			throw new NullPointerException();
	}
	
	public void movePiece(Position from, Position to)
	{
		
	}
	//in danger boolean for if king is in danger
	//two position variables that track both kings
}
