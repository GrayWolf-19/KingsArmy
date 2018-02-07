package gui;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Assets  
{
	public static BufferedImage[] pKingAtt;
	public static BufferedImage[] rKingAtt;
	public static BufferedImage[] pKnightAtt;
	public static BufferedImage[] rKnightAtt;
	public static BufferedImage[] pPikemanAtt;
	public static BufferedImage[] rPikemanAtt;
	private static final int king = 19, knight = 12, pikeman = 18;
	
	public static void init() throws IOException
	{
		pKingAtt = new BufferedImage[king];
		rKingAtt = new BufferedImage[king];
		pKnightAtt = new BufferedImage[knight];
		rKnightAtt = new BufferedImage[knight];
		pPikemanAtt = new BufferedImage[pikeman];
		rPikemanAtt = new BufferedImage[pikeman];
		
		BufferedImage sheetP = ImageIO.read(new File("res/Textures/KingPurpleAttackSpriteSheet.png"));
		BufferedImage sheetR = ImageIO.read(new File("res/Textures/KingRedAttackSpriteSheet.png"));
		
		for(int i = 0; i < pKingAtt.length; i++)
		{
			pKingAtt[i] = sheetP.getSubimage(0, i * 513, 512, 512);
			rKingAtt[i] = sheetR.getSubimage(0, i * 513, 512, 512);
		}
		
		sheetP = ImageIO.read(new File("res/Textures/KnightPurpleAttackSpriteSheet.png"));
		sheetR = ImageIO.read(new File("res/Textures/KnightRedAttackSpriteSheet.png"));
		
		for(int i = 0; i < pKnightAtt.length; i++)
		{
			pKnightAtt[i] = sheetP.getSubimage(0, i * 513, 512, 512);
			rKnightAtt[i] = sheetR.getSubimage(0, i * 513, 512, 512);
		}
		
		sheetP = ImageIO.read(new File("res/Textures/PikemanPurpleAttackSpriteSheet.png"));
		sheetR = ImageIO.read(new File("res/Textures/PikemanRedAttackSpriteSheet.png"));
		
		for(int i = 0; i < pPikemanAtt.length; i++)
		{
			pPikemanAtt[i] = sheetP.getSubimage(0, i * 513, 512, 512);
			rPikemanAtt[i] = sheetR.getSubimage(0, i * 513, 512, 512);
		}
	}
	public static int numPictures(int Type)
	{
		switch(Type)
		{
		case 0:
		{
			return pikeman;
		}
		case 1:
		{
			return knight;
		}
		case 2:
		{
			return king;
		}
		}
		return -1;
	}
	public static BufferedImage[] getAnimation(int Type, boolean Team)
	{
		switch(Type)
		{
		case 0:
		{
			return getPikeman(Team);
		}
		case 1:
		{
			return getKnight(Team);
		}
		case 2:
		{
			return getKing(Team);
		}
		}
		return null;
	}
	private static BufferedImage[] getPikeman(boolean team)
	{
		if(team) return rPikemanAtt;
		else 
			return pPikemanAtt;
		
	}
	private static BufferedImage[] getKnight(boolean team)
	{
		if(team) return rKnightAtt;
		else 
			return pKnightAtt;
	}
	private static BufferedImage[] getKing(boolean team)
	{
		if(team) return rKingAtt;
		else 
			return pKingAtt;
	}
}
