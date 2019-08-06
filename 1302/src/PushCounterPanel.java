import java.awt.event.*;
import java.util.Arrays;
import java.util.Random;
import java.awt.*;
import javax.swing.*;

public class PushCounterPanel extends JPanel{
	
	private int count;
	private JButton push;
	private JLabel label;
	private JTextField f1, f2, f3;
	
	//construcor: sets up the GUI
	public PushCounterPanel() {
		count = 0;
		
		push = new JButton("Push Me!");
		
		label = new JLabel();
		push.addActionListener(new ButtonListener());
		f1 = new JTextField(5);
		f2 = new JTextField(5);
		f3 = new JTextField(5);
		add(f1);
		add(f2);
		add(f3);
		add(push);
		System.out.println();
		add(label);
		
		setBackground(Color.cyan);
		setSize(new Dimension(500,500));
		
	}
	//represents a listener for button push (action events)
	private class ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			
//			Random rand = new Random();
//			count = rand.nextInt(100)+1;
//			label.setText("Pushes: " + count);
			
			int x, y, z;
			int[] array = new int[3];
			
				
			x = Integer.parseInt(f1.getText());
			array[0] = x;
			y = Integer.parseInt(f2.getText());
			array[1] = y;
			z = Integer.parseInt(f3.getText());
			array[2] = z;
			Arrays.sort(array);
			label.setText(Arrays.toString(array));
				
			
			
			
		}
	}
}
