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
	
	public static void init() throws IOException
	{
		pKingAtt = new BufferedImage[19];
		rKingAtt = new BufferedImage[19];
		pKnightAtt = new BufferedImage[12];
		rKnightAtt = new BufferedImage[12];
		pPikemanAtt = new BufferedImage[18];
		rPikemanAtt = new BufferedImage[18];
		
		BufferedImage sheetP = ImageIO.read(new File("res/Textures/KingPurpleAttackSpriteSheet.png"));
		BufferedImage sheetR = ImageIO.read(new File("res/Textures/KingRedAttackSpriteSheet.png"));
		
		for(int i = 0; i < 19; i++)
		{
			pKingAtt[i] = sheetP.getSubimage(0, i * 513, 512, 512);
			rKingAtt[i] = sheetR.getSubimage(0, i * 513, 512, 512);
		}
		
		sheetP = ImageIO.read(new File("res/Textures/KnightPurpleAttackSpriteSheet.png"));
		sheetR = ImageIO.read(new File("res/Textures/KnightRedAttackSpriteSheet.png"));
		
		for(int i = 0; i < 12; i++)
		{
			pKnightAtt[i] = sheetP.getSubimage(0, i * 513, 512, 512);
			rKnightAtt[i] = sheetR.getSubimage(0, i * 513, 512, 512);
		}
		
		sheetP = ImageIO.read(new File("res/Textures/PikemanPurpleAttackSpriteSheet.png"));
		sheetR = ImageIO.read(new File("res/Textures/PikemanRedAttackSpriteSheet.png"));
		
		for(int i = 0; i < 18; i++)
		{
			pPikemanAtt[i] = sheetP.getSubimage(0, i * 513, 512, 512);
			rPikemanAtt[i] = sheetR.getSubimage(0, i * 513, 512, 512);
		}
	}
}
