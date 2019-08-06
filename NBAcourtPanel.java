import java.awt.*;
 import javax.swing.*;
 import java.awt.Graphics;
 import javax.swing.JComponent;
 import javax.swing.JFrame;

 public class NBAcourtPanel extends JPanel{



 public NBAcourtPanel(){

 setBackground (Color.yellow);

 setPreferredSize (new Dimension(300,600)); }


 public NBAcourtPanel(NBATeam spurs) {


 }

 public void paint(Graphics g){

      super.paint(g);

     int i =0;
	 NBATeam namess = new NBATeam("");

	 int height = 400;
	 int width = 260;

	 g.setColor(Color.orange);
	 g.fillRect(100,20,height,width);
	 g.setColor (Color.red);
	 g.fillOval (240,80, 120, 120);
	 g.setColor(Color.white);
	 g.drawLine(300, 20, 300, 280);
	 g.drawArc(10, 65, 180, 170, 270, 180);
	 g.drawArc(410, 65, 180, 170, 90, 180);

	 g.setFont(g.getFont().deriveFont(18f));
	 g.setColor(Color.GREEN);


     while (true){
	  g.drawString("Names\n"+namess.getName()+"\n", 450, 70);
	  break;
          }


	 }

	 public void repaint(Graphics f) { }


	 }


