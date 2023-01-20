package view;

import javax.swing.JFrame;

public class MainFrame extends JFrame{
	
	public MainFrame() {		
		MainPanel mainPanel = new MainPanel();
		
		setTitle("Conversor Alura");		
		setBounds(300, 200, 258, 468);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		add(mainPanel);		
	}
}
