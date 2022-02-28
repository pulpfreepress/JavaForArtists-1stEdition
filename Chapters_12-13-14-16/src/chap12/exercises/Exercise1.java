/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

package chap12.exercises;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Exercise1{
	public static void main(String[] arg) {
		JFrame frame = new JFrame( "Clock GUI");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container cont = frame.getContentPane();
		cont.setLayout(new GridBagLayout());
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = gbc.BOTH;
		gbc.gridx = 1;
		gbc.gridy = 0;
		cont.add( new JButton("XI"), gbc);
		gbc.gridx = 2;
		cont.add( new JButton("XII"), gbc);
		gbc.gridx = 3;
		cont.add( new JButton("I"), gbc);

		gbc.gridx = 0;
		gbc.gridy = 1;
		cont.add( new JButton("X"), gbc);
		gbc.gridy = 2;
		cont.add( new JButton("IX"), gbc);
		gbc.gridy = 3;
		cont.add( new JButton("VIII"), gbc);

		gbc.gridx = 1;
		gbc.gridy = 4;
		cont.add( new JButton("VII"), gbc);
		gbc.gridx = 2;
		cont.add( new JButton("VI"), gbc);
		gbc.gridx = 3;
		cont.add( new JButton("V"), gbc);
		
		gbc.gridx = 4;
		gbc.gridy = 1;
		cont.add( new JButton("II"), gbc);
		gbc.gridy = 2;
		cont.add( new JButton("III"), gbc);
		gbc.gridy = 3;
		cont.add( new JButton("IV"), gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.gridheight = gbc.gridwidth = 3;
		gbc.insets = new Insets(10, 10, 10, 10);
		cont.add( new JButton("*"), gbc);
		

		frame.pack();
		frame.setVisible(true);
	}
}
