import javax.swing.JFrame;
import javax.swing.JTextField;

public class PushCounter {
	//Creates and displays the main program frame.
	public static void main(String[] args) {
		JTextField TF = new JTextField(5);
		JFrame frame = new JFrame("Push Counter");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		PushCounterPanel panel = new PushCounterPanel();
		frame.getContentPane().add(panel);
		
		frame.pack();
		frame.setVisible(true);
	}
}
