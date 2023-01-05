package view;

import javax.swing.JFrame;

public class MainFrame extends JFrame{
	
	public MainFrame() {		
		
		setTitle("Conversor Alura");		
		setVisible(true);
		setBounds(300, 400, 276, 420);// modificar para centrar en la pantalla
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		MainPanel mainPanel = new MainPanel();
		
		add(mainPanel);
		
	}

}
