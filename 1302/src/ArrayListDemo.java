

import java.awt.*;
import javax.swing.*;

import java.awt.event.*;
import java.util.*;
public class ArrayListDemo extends JFrame {
	ArrayList<String> names=new ArrayList<String>();
//	TreeSet<String> names=new TreeSet<String>();
	JTextField txt;
	MyPanel p2;
	
	public ArrayListDemo(){
		JLabel jl=new JLabel("Input a Name:");
		txt=new JTextField("name");
		JButton jb=new JButton ("Add");
		Mylistener ml=new Mylistener(); 
		jb.addActionListener(ml);
		JPanel p1=new JPanel();
		p1.add(jl); p1.add(txt); p1.add(jb);
		add(p1, BorderLayout.SOUTH);
		
		p2=new MyPanel();
		add(p2, BorderLayout.CENTER);
	}
	public static void main(String[] args) {
		JFrame jf=new ArrayListDemo();
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setSize(300,200);
		jf.setTitle("Demo of ArrayList");
		jf.setVisible(true);
	}
private class Mylistener implements ActionListener{
	public void actionPerformed(ActionEvent event){
		String s=txt.getText(); 
		names.add(s); 
		p2.repaint();
	}
}
	public class MyPanel extends JPanel{
		public void paintComponent(Graphics g){
			super.paintComponent(g);
			g.setColor(Color.RED);
			//for (int i=0;i<names.size(); i++)
			//	g.drawString(names.get(i), 40, 20+i*20);
			int i=0;
			for (String s : names){
				g.drawString(s, 40, 20+i*20); 
				i++;
			}
		}
	}
}


//
//public class ArrayListDemo extends JFrame{
//	ArrayList<String> names = new ArrayList<String>();    //Instance variables
//	JTextField txt;
//	MyPanel p2;
//	//create a constructor
//	public ArrayListDemo() {
//		JLabel jl = new JLabel("Input a name: ");
//		txt = new JTextField("name");
//		JButton jb = new JButton("Add");
//		Mylistener ml = new Mylistener();
//		jb.addActionListener(ml);  //makes connection of button to listener
//		JPanel p1 = new JPanel();
//		p1.add(jl);
//		p1.add(txt);
//		p1.add(jb);
//		add(p1, BorderLayout.SOUTH);
//		
//		p2 = new MyPanel();
//		add(p2, BorderLayout.CENTER);
//		
//		
//	}
//	public static void main(String[] args) {
//		
//		JFrame jf=new ArrayListDemo();
//		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		jf.setSize(300, 200);
//		jf.setTitle("Demo of ArrayList");
//		jf.setVisible(true);
//		
//		
//	}
//	private class Mylistener implements ActionListener{
//		public void actionPerformed(ActionEvent event) { // this gets the text from 
//			String s = txt.getText();                     //from the boxes and adds 
//			names.add(s);							     // to the ArrayList
//			p2.repaint();
//		}
//	}
//	
//	
//	public class MyPanel extends JPanel{
//		public void paintComponenet(Graphics g) {
//			super.paintComponent(g);
//			g.setColor(Color.RED);
//			int i=0;
//			for (String s : names){
//				g.drawString(s, 40, 20+i*20); 
//				i++;
//			}
//		}
//	}
//	
//}
