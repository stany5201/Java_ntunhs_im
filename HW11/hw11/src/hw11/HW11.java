package hw11;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HW11 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame=new JFrame("Tic Tac Toe Game");
		JButton[][] buttons= new JButton[3][3];
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300,300);
		
		JPanel panel=new JPanel();
		panel.setLayout(new GridLayout(3,3));
		frame.add(panel,BorderLayout.CENTER);
		
		JLabel statusLabel =new JLabel("Player X's turn");
		frame.add(statusLabel,BorderLayout.SOUTH);
		
		for(int i=0;i<3;i++) {
			for(int j= 0; j <3;j++) {
				buttons[i][j]= new JButton();
				buttons[i][j].setFont(new Font("Arial", Font.BOLD,40));
				
				panel.add(buttons[i][j]);
			}
		}
		frame.setVisible(true);
	}
}

