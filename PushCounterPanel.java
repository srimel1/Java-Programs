import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PushCounterPanel extends JPanel
{
   private int count;
   private JButton push;
   private JLabel label;
   private JTextField TF1;
   private JTextField TF2;
   private JTextField TF3;
   

   //-----------------------------------------------------------------
   //  Constructor: Sets up the GUI.
   //-----------------------------------------------------------------
   public PushCounterPanel()
   {
      count = 0;

      push = new JButton("Push Me!");
      label = new JLabel();
      push.addActionListener(new ButtonListener());
     
      
      TF1 = new JTextField(5);
      TF2 = new JTextField(5);
      TF3 = new JTextField(5);
      add(TF1);
      add(TF2);
      add(TF3);
      add(push);
      System.out.println();
      add(label);
      setBackground(Color.cyan);
      setPreferredSize(new Dimension(300, 80));
   }

   //*****************************************************************
   //  Represents a listener for button push (action) events.
   //*****************************************************************
	private class ButtonListener implements ActionListener
	{
	public void actionPerformed(ActionEvent event)
  	{
//         count++;
//         label.setText("Pushes: " + count);
		
		
		int x,y,z;
		int[] temp = new int[3];
		x = Integer.parseInt(TF1.getText());
		temp[0] = x;
//		System.out.print(temp[0] + " " + x + "\t");
		y = Integer.parseInt(TF2.getText());
		temp[1] = y;
//		System.out.print(temp[1] + " " + y + "\t");
		z = Integer.parseInt(TF3.getText());
		temp[2] = z;
//		System.out.print(temp[2] + " " + z + "\t");
		
		int CurrentTemp = 0;
		for(int i = 0; i< temp.length;i++){
			for(int j=i;j<temp.length;j++){
				if(temp[i] < temp [j]){
					CurrentTemp = temp[i];
					temp[i] = temp[j];
					temp[j] = CurrentTemp;
				}
			}
		}
		for(int u: temp)
		System.out.print(u + "\t");
		label.setText("The sorted Array is: " + temp[0] + ", " + temp[1] + ", " + temp[2]);
		
		
  	}
 	}
}

