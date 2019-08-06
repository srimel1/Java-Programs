import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class NBAcourtPanel extends JPanel {
		Graphics g;
		JPanel p;
		NBATeam spurs;

		public NBAcourtPanel(NBATeam spurs)
		{

		}
		public Dimension getPreferredSize() {
		 return new Dimension(200, 200);
		}
		 protected void paintComponent(Graphics g) {
		 super.paintComponent(g);
		 Graphics2D g2d = (Graphics2D) g.create();
		 Graphics2D g2d1 = (Graphics2D) g.create();
		 Graphics2D g2d2 = (Graphics2D) g.create();
		 Graphics2D g2d3 = (Graphics2D) g.create();
		 Graphics2D g2d4 = (Graphics2D) g.create();
		 Graphics2D g2d5 = (Graphics2D) g.create();
		int width = getWidth() - 100;
		 int height = getHeight() - 100;
		 int x = (getWidth() - width) / 2;
		int y = (getHeight() - height) / 2;
		 g2d.setColor(Color.ORANGE);
		 g2d.fillRect(x, y-20, width+50, height+30);
		 g2d1.setColor(Color.RED);
		g2d1.fillOval(260,90,120,120);
		 g2d2.setColor(Color.YELLOW);
		g2d2.drawLine(315,267,315,30);
		 g2d3.setColor(Color.YELLOW);
		 g2d3.drawArc(-40,80,180,150,270,180);
		 g2d4.setColor(Color.YELLOW);
		 g2d4.drawArc(500,80,180,150,450,180);
		 g2d5.setColor(Color.RED);

		}

		public void draw1(String s, Graphics g)
		{

		super.paintComponent(g);
		Graphics2D g2d5 = (Graphics2D) g.create();
		g2d5.drawString(s,100,100);
		}
		}


