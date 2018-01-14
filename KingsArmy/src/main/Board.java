package main;

public class Board 
{
	private int size;
	private Space[][] board;
	private Position kingPlayer1, kingPlayer2;
	
	public Board(int sizeOfBoard)
	{
		size = sizeOfBoard;
		initialize();
		setUpPieces();
	}
	
	public void initialize()
	{
		for(int i = 0;i < size;i++)
			for(int j = 0;j < size;j++)
				board[i][j] = new Space(new Position(i,j));
	}
	
	public void setUpPieces()
	{
		//set up player 1
		board[size/2][0].setPiece(new King(true,new Position(size/2,0)));
		board[size/2 - 1][0].setPiece(new Knight(true,new Position(size/2 - 1,0)));
		board[size/2 + 1][0].setPiece(new Knight(true,new Position(size/2 + 1,0)));
		kingPlayer1 = new Position(size/2,0);
		board[0][0].setPiece(new Pikeman(true,new Position(0,0)));
		board[1][0].setPiece(new Pikeman(true,new Position(1,0)));
		board[size - 2][0].setPiece(new Pikeman(true,new Position(size - 2,0)));
		board[size - 1][0].setPiece(new Pikeman(true,new Position(size - 1,0)));
		for(int i = 0;i < size;i++)
			board[i][1].setPiece(new Pikeman(true,new Position(i,1)));
		
		//set up player 2
		board[size/2][size - 1].setPiece(new King(true,new Position(size/2,size - 1)));
		board[size/2 - 1][size - 1].setPiece(new Knight(true,new Position(size/2 - 1,size - 1)));
		board[size/2 + 1][size - 1].setPiece(new Knight(true,new Position(size/2 + 1,size - 1)));
		kingPlayer2 = new Position(size/2,size - 1);
		board[0][size - 1].setPiece(new Pikeman(true,new Position(0,size - 1)));
		board[1][size - 1].setPiece(new Pikeman(true,new Position(1,size - 1)));
		board[size - 2][size - 1].setPiece(new Pikeman(true,new Position(size - 2,size - 1)));
		board[size - 1][size - 1].setPiece(new Pikeman(true,new Position(size - 1,size - 1)));
		for(int i = 0;i < size;i++)
			board[i][size - 1].setPiece(new Pikeman(true,new Position(i,size - 1)));
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
	/*
	public Position[] scrubMoves(Position[] moves, int type)
	{
		//cant move off the board
		//knight cant attack in two if there is nothing in between
		//king cant attack diagonally
	}
	*/
	public void movePiece(Position from, Position to)
	{
		
	}
	//in danger boolean for if king is in danger
	//two position variables that track both kings
}
