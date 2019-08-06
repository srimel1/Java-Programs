import javax.swing.JFrame;
import javax.swing.JFrame;

public class PP4_17 {

   public static void main(String[] args) {

       JFrame win = new JFrame("Traffic Light");
       win.setSize(130, 290);
       win.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       win.add(new TrafficLight());
       // win.pack();
       win.setVisible(true);

   }
}