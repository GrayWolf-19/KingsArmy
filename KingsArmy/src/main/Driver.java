package main;

public class Driver 
{

	public static void main(String[] args) 
	{
		Board board = new Board(7);
		
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
