/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

package chap12.exercises;
import java.awt.*;
import javax.swing.*;

public class Exercise3 extends JFrame{
	
	public Exercise3(){
		super("Exercise3");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		createGUI();
	}
	
	public void createGUI(){
		JLabel firstNameLabel = new JLabel("First Name:", JLabel.RIGHT);
		JLabel lastNameLabel = new JLabel("Last Name:", JLabel.RIGHT);
		JLabel middleInitialLabel = new JLabel("Middle Initial:", JLabel.RIGHT);
		JLabel emailLabel = new JLabel("Email:", JLabel.RIGHT);
		JLabel phoneLabel = new JLabel("Phone:", JLabel.RIGHT);
	
		JTextField firstNameField = new JTextField(20);
		JTextField lastNameField = new JTextField(20);
		JTextField middleInitialField = new JTextField(1);
		JTextField emailField = new JTextField(20);
		JTextField phoneField = new JTextField(20);

		JPanel westPanel = new JPanel(new GridLayout(0, 1, 5, 5));
		westPanel.add( firstNameLabel );
		westPanel.add( lastNameLabel );
		westPanel.add( middleInitialLabel );
		westPanel.add( emailLabel );
		westPanel.add( phoneLabel );

		JPanel centerPanel = new JPanel(new GridLayout(0, 1, 5, 5));
		centerPanel.add( firstNameField );
		centerPanel.add( lastNameField );
		centerPanel.add( middleInitialField );
		centerPanel.add( emailField );
		centerPanel.add( phoneField );

		Container cont = getContentPane();
		cont.setLayout(new BorderLayout(5, 5));
		cont.add( westPanel, BorderLayout.WEST);
		cont.add( centerPanel, BorderLayout.CENTER);
	}
	
	public static void main(String[] arg) {
		JFrame frame = new Exercise3();
		frame.pack();
		frame.setVisible(true);
	}
}
