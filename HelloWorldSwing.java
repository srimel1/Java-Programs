import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class HelloWorldSwing extends JFrame{
	public HelloWorldSwing() {
		super("HelloWorldSwing");
		final JLabel label = new JLabel("Hello World");
		getContentPane().add(label);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}
	public static void main(String[] args) {
		HelloWorldSwing frame = new HelloWorldSwing();
	}
	}
		

//	public static void main(String[] args) {
//		
//	
//		
//		JFrame frame = new JFrame("HelloWorldSwing");
//		final JLabel label = new JLabel("Hello World");
//		frame.getContentPane().add(label);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);;
//		frame.pack();	// pack causes a window to be sized to fit the preferred size and layouts of its subcomponents
//		frame.setVisible(true);
//		Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
//		double jFrameWidth = screenDimension.width * 0.7;
//		double jFrameHeight = screenDimension.height * 0.5;
	//}
	
	

//}
