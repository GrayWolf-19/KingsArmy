package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import main.Board;
import main.Position;

public class KingsArmy
{
	JFrame frame;
	JPanel panel;
	JButton[][] buttons;
	JButton selected;
	int x, y;
	ArrayList<JButton> options;
	Board b;
	public static void main(String[] args)
	{
		KingsArmy army = new KingsArmy();
	}
	public KingsArmy()
	{
		b = new Board(7);
		buttons = new JButton[7][7];
		try {
			Assets.init();
		} catch (IOException e) {
			e.printStackTrace();
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
				buttons[i][j].setPreferredSize(new Dimension(100, 100));
			}
		frame = new JFrame("King's Army");
		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.pack();
		frame.setVisible(true);
		Dimension d = buttons[0][0].getSize();
		BufferedImage i  = Assets.rPikemanAtt[0];
		ImageIcon image = new ImageIcon(i.getScaledInstance(175, 175, 0));
		for(int j = 0; j < 7; j++)
		{
			
			buttons[j][1].setIcon(image);
		}
			
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
							ArrayList<Position> p = b.getPiecesMoves(new Position(i,j));
							for(int l = 0; l < p.size(); l++)
								options.add(buttons[p.get(l).x()][p.get(l).y()]);
							x= i;
							y=j;
						}
			}
			else if(!(options.indexOf(clicked) == -1))
			{
				for(int i = 0; i < buttons.length; i++)
					for(int j = 0; j < buttons[i].length; j++)
						if(clicked.equals(buttons[i][j]))
						{
							b.movePiece(new Position(x,y), new Position(i,j));
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
}
