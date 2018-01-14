package main;

import java.util.ArrayList;

public class Board 
{
	private int size;
	private Space[][] board;
	private Position kingPlayer1, kingPlayer2;
	
	public Board(int sizeOfBoard)
	{
		size = sizeOfBoard;
		board = new Space[size][size];
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
		board[size/2][size - 1].setPiece(new King(false,new Position(size/2,size - 1)));
		board[size/2 - 1][size - 1].setPiece(new Knight(false,new Position(size/2 - 1,size - 1)));
		board[size/2 + 1][size - 1].setPiece(new Knight(false,new Position(size/2 + 1,size - 1)));
		kingPlayer2 = new Position(size/2,size - 1);
		board[0][size - 1].setPiece(new Pikeman(false,new Position(0,size - 1)));
		board[1][size - 1].setPiece(new Pikeman(false,new Position(1,size - 1)));
		board[size - 2][size - 1].setPiece(new Pikeman(false,new Position(size - 2,size - 1)));
		board[size - 1][size - 1].setPiece(new Pikeman(false,new Position(size - 1,size - 1)));
		for(int i = 0;i < size;i++)
			board[i][size - 2].setPiece(new Pikeman(false,new Position(i,size - 2)));
	}
	
	public int getSize()
	{
		return size;
	}
	
	public Piece getPiece(Position position)
	{
		return board[position.x()][position.y()].getPiece();
	}
	
	public ArrayList<Position> getPiecesMoves(Position position)
	{
		if(board[position.x()][position.y()].getPiece() != null)
			return board[position.x()][position.y()].getPiece().getMoves();
		else
			throw new NullPointerException();
	}
	
	public Position[] scrubMoves(Position[] moves, int type)
	{
		Space[][] deep = new Space[size][size];
		for(int i = 0;i < size;i++)
			for(int j = 0;j < size;j++)
				deep[i][j] = board[i][j].deepCopy();
		
		for(int i = 0;i < moves.length;i++)
			if()
		
		//cant move off the board
		//knight cant attack in two if there is nothing in between
		//king cant attack diagonally
	}
	
	public void movePiece(Position from, Position to)
	{
		
	}
	//in danger boolean for if king is in danger
	//two position variables that track both kings
	
	public boolean isKingInDanger(boolean player)
	{
		Position king;
		if(player)
			king = kingPlayer1;
		else
			king = kingPlayer2;
		
		for(int i = king.x() - 2;i <= king.x() + 2;i++)
			for(int j = king.y() - 2;j <= king.y() + 2;j++)
				if(i<=6 && j<=6 && i>=0 && j>=0 && board[i][j].getPiece() != null)
				{
					ArrayList<Position> p = board[i][j].getPiece().getMoves();
					for(int k = 0; k < p.size(); k++)
						if(p.get(k).equals(king)) return true;
				}
		return false;
	}
}
