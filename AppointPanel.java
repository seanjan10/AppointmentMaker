import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.*;
public class AppointPanel extends JPanel {

	public JComboBox timeAvail;
	public JLabel sched = new JLabel("When will you like to pick up your supplies?");
	public ArrayList<String> untakenAppointment = new ArrayList<String>();
	public ArrayList<String> takenAppointment = new ArrayList<String>();
	public JButton confirm = new JButton("Confirm Time");
	public AppointPanel() throws Exception {
		
		
		
		setLayout(new FlowLayout());
		for (int i = 8; i <21; i++ ) {
			untakenAppointment.add(i + ":" + "00 - " + i + ":15");
			untakenAppointment.add(i + ":" + "15 - " + i + ":30");
			untakenAppointment.add(i + ":" + "30 - " + i + ":45");
			untakenAppointment.add(i + ":" + "45 - " + (i + 1) + ":00");
		}
		
		
		Scanner fr = new Scanner(new FileInputStream("./SpotsTaken.txt")); //file reader
		while (fr.hasNextLine()) {
			String temp = fr.nextLine(); //read prior inputs and store into list
			if (untakenAppointment.contains(temp)) {
				takenAppointment.add(temp);
			
			untakenAppointment.remove(temp);
			}
		}
		fr.close();
		
	
		timeAvail = new JComboBox(untakenAppointment.toArray());
	
		add(sched);
		add(timeAvail);
		add(confirm);
		
		confirm.addActionListener(new ActionListener()  { 
			//button to save to fiel
			public void actionPerformed(ActionEvent e) {
				try {
				PrintWriter pwL = new PrintWriter(new FileOutputStream("./SpotsTaken.txt")); //print to the file
				for (int i = 0; i < takenAppointment.size(); i++) {
					pwL.write(takenAppointment.get(i) + "\n");
					
				}
				pwL.write(untakenAppointment.get(timeAvail.getSelectedIndex()));
				timeAvail.removeItemAt(timeAvail.getSelectedIndex());
		
				pwL.close();
				confirm.setVisible(false);
				timeAvail.setVisible(false);
				
				sched.setText("Thank you, an email reminder has been sent to your email. We'll see you then!");
				} catch (Exception err){
					
				}
			}
			
		});
		
		
		
	}
}
