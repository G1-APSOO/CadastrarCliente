package main;

import javax.swing.JFrame;

public class MainClass {

	public static void main(String[] args) {
		System.out.println("Olá mundo");
		
		JFrame frame = new MainFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
