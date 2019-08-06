import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class NBAPlayoff extends JFrame
{
private JTextField txtName;
private JTextField txtAge;
private NBATeam spurs;

private NBAcourtPanel court;
private JLabel lMax, lMin, lAvg, lNum;

public NBAPlayoff()
{
spurs = new NBATeam("Spurs");
court = new NBAcourtPanel(spurs);
add(court,BorderLayout.CENTER);


JLabel lMax0 = new JLabel("Max age");
lMax = new JLabel("");
JLabel lMin0 = new JLabel(" Min age");
lMin = new JLabel("");
JLabel lAvg0 = new JLabel(" Average age");
lAvg = new JLabel("");
JLabel lNum0 = new JLabel(" Number of Players: ");
lNum = new JLabel("");

JPanel rp = new JPanel(new GridLayout(8,1));
rp.add(lNum0);
rp.add(lNum);
rp.add(lMax);
rp.add(lMin0);
rp.add(lMin);
rp.add(lAvg0);
rp.add(lAvg);
add(rp, BorderLayout.EAST);
JPanel x = new JPanel(new GridLayout(8,1));
JLabel z;
z=new JLabel(" ");
x.add(z);
//x.setBackground(Color.RED);
add(x, BorderLayout.WEST);
JLabel l1 = new JLabel("Player Name: ");
txtName = new JTextField();
txtName.setPreferredSize(new Dimension(120, 24));

JLabel l2 = new JLabel("Player Age: ");
txtAge = new JTextField();
txtAge.setPreferredSize(new Dimension(120, 24));
JLabel a1 = new JLabel();
add(a1);
JButton jbtAdd = new JButton("Add a Player");
jbtAdd.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent e){
int age = Integer.parseInt(txtAge.getText());
spurs.addAPlayer(txtName.getText(), age);
Graphics g1 = null;
draw1("spurs",g1);
add(a1, spurs.getName());
lMax.setText(" " + spurs.getMaxAge() + " ");
lMin.setText(" " + spurs.getMinAge() + " ");
lAvg.setText(" " + spurs.getAverage() + " ");
lNum.setText(" " + spurs.getNumOfPlayer() + " ");
court.repaint();
}
});

JButton jbtClear = new JButton("Clear");
jbtClear.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent e){
txtName.setText("");
txtAge.setText("");

}
});

JPanel pBot = new JPanel();
pBot.add(l1);
pBot.add(txtName);
pBot.add(l2);
pBot.add(txtAge);
pBot.add(jbtAdd);


pBot.add(jbtClear);
add(pBot, BorderLayout.SOUTH);

}

protected void draw1(String string, Graphics g1) {
	super.paintComponents(g1);
	Graphics2D g2d5 = (Graphics2D) g1.create();
	g2d5.drawString(string,100,100);
	
}

public static void main(String[] args)
{
NBAPlayoff frame = new NBAPlayoff();
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setLocationRelativeTo(null);

frame.setSize(800, 400);
frame.setVisible(true);
}
}

//public class NBAPlayoff extends JFrame{
//	private JTextField txtName;
//	private JTextField txtAge;
//	private NBATeam spurs;
//	private NBAcourtPanel court;
//	private JLabel lMax, lMin, lAvg, lNum;
//	
//	public NBAPlayoff() {
//		spurs = new NBATeam("Spurs");
//		court = new NBAcourtPanel(spurs);
//		add(court, BorderLayout.CENTER);
//		
//		JLabel lMax0 = new JLabel("Max Age: ");
//		lMax = new JLabel("");
//		JLabel lMin0 = new JLabel("Min Age: ");
//		lMin = new JLabel("");
//		JLabel lAvg0 = new JLabel("Average Age: ");
//		lAvg = new JLabel("");
//		JLabel lNum0 = new JLabel("Number of Players: ");
//		lNum = new JLabel("");
//		JPanel rp = new JPanel(new GridLayout(8,1));
//		rp.add(lNum0);rp.add(lNum);rp.add(lMax0);rp.add(lMax);
//		rp.add(lMin0);rp.add(lMin);rp.add(lAvg0);rp.add(lAvg);
//		add(rp, BorderLayout.EAST);
//		
//		JLabel l1 = new JLabel("Player Name: ");
//		txtName = new JTextField();
//		txtName.setPreferredSize(new Dimension(120,24));
//		JLabel l2 = new JLabel("Player Age: ");
//		txtAge = new JTextField();
//		txtAge.setPreferredSize(new Dimension(120,24));
//		
//		JButton jbtAdd = new JButton("Add A Player");
//		jbtAdd.addActionListener(new ActionListener()) {
//			public void actionPerformed(ActionEvent e) {
//				int age = Integer.parseInt(txtAge.getText());
//				spurs.addAplayer(txtName.getText(), age);
//			}
//		});
//		
//	}
//	
//
//}
