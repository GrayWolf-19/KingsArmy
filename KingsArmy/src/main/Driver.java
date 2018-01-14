package main;

import java.util.ArrayList;

public class Driver 
{

	public static void main(String[] args) 
	{
		Board board = new Board(7);
		
		printBoard(board);
		System.out.println();
		System.out.println(board.getPiece(new Position(3,1)).getClass() + " ");
		System.out.println();
		ArrayList moves = board.getPiecesMoves(new Position(3,1));
		for(int i = 0;i < moves.size();i++)
			System.out.println(moves.get(i));
	}
	
	private static void printBoard(Board board)
	{
		for(int i = 0;i < board.getSize();i++)
		{
			for(int j = 0;j < board.getSize();j++)
				if(board.getPiece(new Position(i,j)) != null)
					System.out.print(board.getPiece(new Position(i,j)).getClass() + " ");
				else
					System.out.print("Space ");
			System.out.println();
		}
	}

}
