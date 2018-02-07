package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.Transparency;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Semaphore;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import main.Board;
import main.Piece;
import main.Position;
import main.Space;

public class KingsArmy
{
	JFrame frame;
	boolean danger;
	Click list;
	JPanel panel;
	JButton[][] buttons;
	JButton selected;
	Color sColor;
	int x, y;
	ArrayList<Color> oColor;
	ArrayList<JButton> options;
	Board b;
	Color king;
	boolean turn;
	public static void main(String[] args)
	{
		KingsArmy army = new KingsArmy();
	}
	public KingsArmy()
	{
		try {
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		turn = true;
		list = new Click();
		b = new Board(7);
		buttons = new JButton[7][7];
		try {
			Assets.init();
		} catch (IOException e) {
		}
		initialize();
	}
	public void initialize()
	{
		selected = null;
		panel = new JPanel();
		panel.setLayout(new GridLayout(7,7));
		for(int i = 0 ; i <= 6; i ++)
			for(int j = 0 ; j <= 6; j ++)
			{
				buttons[i][j] = new JButton();
				if((i+j)/2.0 == (int) (i+j)/2) buttons[i][j].setBackground(new Color(255, 255, 255));
				else buttons[i][j].setBackground(new Color(0, 0, 0));
				panel.add(buttons[i][j]);
				buttons[i][j].addMouseListener(list);
				buttons[i][j].setPreferredSize(new Dimension(100, 100));
			}
		frame = new JFrame("King's Army");
		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.pack();
		frame.setVisible(true);
		Dimension d = buttons[0][0].getSize();
		BufferedImage i  = Assets.rPikemanAtt[0];
		i= rotate(i, Math.PI/2);
		ImageIcon image = new ImageIcon(i.getScaledInstance(175, 175, 0));
		for(int j = 0; j < 7; j++)
		{
			buttons[j][1].setIcon(image);
		}
		d = buttons[0][0].getSize();
		i  = Assets.pPikemanAtt[0];
		i= rotate(i, 3*Math.PI/2);
		image = new ImageIcon(i.getScaledInstance(175, 175, 0));
		for(int j = 0; j < 7; j++)
		{
			buttons[j][5].setIcon(image);
		}
		d = buttons[0][0].getSize();
		i  = Assets.rPikemanAtt[0];
		i= rotate(i, Math.PI/2);
		image = new ImageIcon(i.getScaledInstance(175, 175, 0));
		for(int j = 0; j < 2; j++)
		{
			buttons[j][0].setIcon(image);
		}
		d = buttons[0][0].getSize();
		i  = Assets.rPikemanAtt[0];
		i= rotate(i, Math.PI/2);
		image = new ImageIcon(i.getScaledInstance(175, 175, 0));
		for(int j = 5; j < 7; j++)
		{
			buttons[j][0].setIcon(image);
		}
		d = buttons[0][0].getSize();
		i  = Assets.pPikemanAtt[0];
		i= rotate(i, 3*Math.PI/2);
		image = new ImageIcon(i.getScaledInstance(175, 175, 0));
		for(int j = 0; j < 2; j++)
		{
			buttons[j][6].setIcon(image);
		}
		d = buttons[0][0].getSize();
		i  = Assets.pPikemanAtt[0];
		i= rotate(i, 3*Math.PI/2);
		image = new ImageIcon(i.getScaledInstance(175, 175, 0));
		for(int j = 5; j < 7; j++)
		{
			buttons[j][6].setIcon(image);
		}
		d = buttons[0][0].getSize();
		i  = Assets.rPikemanAtt[0];
		i= rotate(i, Math.PI/2);
		image = new ImageIcon(i.getScaledInstance(175, 175, 0));
		for(int j = 0; j < 2; j++)
		{
			buttons[j][0].setIcon(image);
		}
		d = buttons[0][0].getSize();
		i  = Assets.rKnightAtt[0];
		i= rotate(i, Math.PI/2);
		image = new ImageIcon(i.getScaledInstance(120, 120, 0));
		buttons[4][0].setIcon(image);
		buttons[2][0].setIcon(image);
		d = buttons[0][0].getSize();
		i  = Assets.pKnightAtt[0];
		i= rotate(i, 3*Math.PI/2);
		image = new ImageIcon(i.getScaledInstance(120, 120, 0));
		buttons[4][6].setIcon(image);
		buttons[2][6].setIcon(image);
		d = buttons[0][0].getSize();
		i  = Assets.rKingAtt[0];
		i= rotate(i, Math.PI/2);
		image = new ImageIcon(i.getScaledInstance(150, 150, 0));
		buttons[3][0].setIcon(image);
		d = buttons[0][0].getSize();
		i  = Assets.pKingAtt[0];
		i= rotate(i, 3*Math.PI/2);
		image = new ImageIcon(i.getScaledInstance(150, 150, 0));
		buttons[3][6].setIcon(image);
	}
	public class Click implements MouseListener
	{

		@Override
		public void mouseClicked(MouseEvent arg0) {
			JButton clicked = (JButton)arg0.getSource();
			if(selected == null)
			{
				for(int i = 0; i < buttons.length; i++)
					for(int j = 0; j < buttons[i].length; j++)
						if(clicked.equals(buttons[i][j]))
						{
							if(b.getPiece(new Position(i,j)) == null || b.getPiece(new Position(i,j)).getPlayer() !=turn) return;
							ArrayList<Position> p = b.getPiecesMoves(new Position(i,j));
							options = new ArrayList<JButton>();
							oColor = new ArrayList<Color>();
							for(int l = 0; l < p.size(); l++)
							{
								options.add(buttons[p.get(l).x()][p.get(l).y()]);
								oColor.add(options.get(l).getBackground());
								options.get(l).setBackground(Color.GREEN);
							}
							x= i;
							y=j;
							selected = clicked;
							sColor = selected.getBackground();
							selected.setBackground(Color.YELLOW);
							ArrayList<Piece> pieces = b.allPieces(turn);
							boolean exit = false;
							for(int k = 0; k<pieces.size() && !exit;k++)
							{
								ArrayList<Position> moves = b.getPiecesMoves(pieces.get(k).getPosition());
								if(moves.size()!=0) exit=!exit;
							}
							if(exit==false) {
								frame.setVisible(false);
								if(turn) JOptionPane.showMessageDialog(null, "Purple Won!", "Game Over", JOptionPane.OK_OPTION);
								else JOptionPane.showMessageDialog(null, "Red Won!", "Game Over", JOptionPane.OK_OPTION);

							}
						}
			}
			else if(clicked.equals(selected))
			{
				selected.setBackground(sColor);
				for(int l = 0; l < options.size(); l++)
				{
					options.get(l).setBackground(oColor.get(l));
				}
				selected = null;
				options = null;
			}
			else if(!(options.indexOf(clicked) == -1))
			{
				for(int i = 0; i < buttons.length; i++)
					for(int j = 0; j < buttons[i].length; j++)
						if(clicked.equals(buttons[i][j]))
						{
							double rotation = 0;
							boolean flag = false;
							for(int k = -1; k <= 1 && !flag; k++)
								for(int l = -1; l <= 1; l++)
									if(x+k == i && y+l == j)
									{
										flag = true;
										if(k== 0)
											if(l == -1)
												rotation = 3*Math.PI/2;
											else
												rotation = Math.PI/2;
										else
											rotation = Math.atan2(l, -k);
										switch(b.getPiece(new Position(x, y)).getType())
										{
										case 0: 
										{
											BufferedImage bi;
											if(!turn) {bi  = Assets.pPikemanAtt[0];
											bi= rotate(bi, rotation);
											}
											else {  bi  = Assets.rPikemanAtt[0];
											bi= rotate(bi, rotation);
											}
											selected.setIcon(new ImageIcon(bi.getScaledInstance(175, 175, 0)));
											break;
										}
										case 1:
										{
											BufferedImage bi;
											if(!turn) {
												bi  = Assets.pKnightAtt[0];
												bi= rotate(bi, rotation);
											}
											else
											{bi  = Assets.rKnightAtt[0];
											bi= rotate(bi, rotation);
											}
											selected.setIcon(new ImageIcon(bi.getScaledInstance(175, 175, 0)));
											break;
										}
										case 2:
										{
											BufferedImage bi;
											if(!turn) { bi  = Assets.pKingAtt[0];
											bi= rotate(bi, rotation);
											}
											else {  bi  = Assets.rKingAtt[0];
											bi= rotate(bi, rotation);
											}
											selected.setIcon(new ImageIcon(bi.getScaledInstance(175, 175, 0)));
											break;
										}
										}
									}
							final double rotate = rotation;
							Timer timer = new Timer();
							final int iSave = i, jSave= j;
							final boolean fSave = flag;
							final Piece moving =  b.getPiece(new Position(x, y)), dying = b.getPiece(new Position(i, j));
							timer.schedule(new TimerTask() 
							{
								public void run()
								{
									if(b.movePiece(new Position(x,y), new Position(iSave,jSave)))
									{
										final JButton c = selected;

										for(int z = 0; z < Assets.numPictures(moving.getType()); z++)
										{

											final int y = z;
											Timer time = new Timer();
											time.schedule(new TimerTask()
											{
												public void run()
												{
													c.setIcon(new ImageIcon(rotate(Assets.getAnimation(moving.getType(), turn)[y], rotate).getScaledInstance(175, 175, 0)));
													if(y == Assets.numPictures(moving.getType())-1)
													{
														if(!fSave)
														{
															Position mid = null;
															if(x == iSave)
																if(y > jSave)
																	mid = new Position(x, jSave+1);
																else
																	mid = new Position(x, y+1);
															else if(y == jSave)
																if(x > iSave)
																	mid = new Position(y, iSave+1);
																else
																	mid = new Position(y, x+1);
															buttons[mid.x()][mid.y()].setIcon(null);
														}
														clicked.setIcon(selected.getIcon());
														selected.setIcon(null);
														selected.setBackground(sColor);
														for(int l = 0; l < options.size(); l++)
														{
															options.get(l).setBackground(oColor.get(l));
														}
														selected = null;
														options = null;
														turn = !turn;
														danger = b.isKingInDanger(turn);
														for(int lcv = 0; lcv < buttons.length; lcv++)
															for(int variable = 0; variable < buttons[lcv].length; variable++)
																if(buttons[lcv][variable].getBackground().equals(Color.RED))
																	buttons[lcv][variable].setBackground(king);
														if(danger)
														{
															Position p = b.getKing(turn);
															king= buttons[p.x()][p.y()].getBackground();
															buttons[p.x()][p.y()].setBackground(Color.RED);
														}

													}
												}

											}, (1000/(Assets.getAnimation(moving.getType(), turn).length))*y);

										}
									}
									else
									{
										if(!fSave)
										{
											Position mid = null;
											if(x == iSave)
												if(y > jSave)
													mid = new Position(x, jSave+1);
												else
													mid = new Position(x, y+1);
											else if(y == jSave)
												if(x > iSave)
													mid = new Position(y, iSave+1);
												else
													mid = new Position(y, x+1);
											buttons[mid.x()][mid.y()].setIcon(null);
										}
										clicked.setIcon(selected.getIcon());
										selected.setIcon(null);
										selected.setBackground(sColor);
										for(int l = 0; l < options.size(); l++)
										{
											options.get(l).setBackground(oColor.get(l));
										}
										selected = null;
										options = null;
										turn = !turn;
										danger = b.isKingInDanger(turn);
										for(int lcv = 0; lcv < buttons.length; lcv++)
											for(int variable = 0; variable < buttons[lcv].length; variable++)
												if(buttons[lcv][variable].getBackground().equals(Color.RED))
													buttons[lcv][variable].setBackground(king);
										if(danger)
										{
											Position p = b.getKing(turn);
											king= buttons[p.x()][p.y()].getBackground();
											buttons[p.x()][p.y()].setBackground(Color.RED);
										}

									}
								}
							}, 300);

						}
			}

		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

	}
	public static BufferedImage rotate(BufferedImage image, double angle) {
		double sin = Math.abs(Math.sin(angle)), cos = Math.abs(Math.cos(angle));
		int w = image.getWidth(), h = image.getHeight();
		int neww = (int)Math.floor(w*cos+h*sin), newh = (int) Math.floor(h * cos + w * sin);
		GraphicsConfiguration gc = getDefaultConfiguration();
		BufferedImage result = gc.createCompatibleImage(neww, newh, Transparency.TRANSLUCENT);
		Graphics2D g = result.createGraphics();
		g.translate((neww - w) / 2, (newh - h) / 2);
		g.rotate(angle, w/2, h/2);
		g.drawRenderedImage(image, null);
		g.dispose();
		return result;
	}

	private static GraphicsConfiguration getDefaultConfiguration() {
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice gd = ge.getDefaultScreenDevice();
		return gd.getDefaultConfiguration();
	}
}
