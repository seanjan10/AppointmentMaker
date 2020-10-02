import javax.swing.JFrame;
import java.awt.*;
public class AppointMain {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Schedule your appointment"); //create the frame
		 try {
		AppointPanel panel = new AppointPanel();
		//defualt jframe stuff
		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		frame.setSize(600, 400);
		frame.setVisible(true);
		frame.setResizable(false);
		 } catch (Exception e) {
			 
		 }

	}

}
