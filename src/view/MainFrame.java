package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

public class MainFrame extends JFrame{
	
	private JLabel greeting, paragraph;
	private JRadioButton currency, temperature;
	
	public MainFrame() {		
		
		setTitle("Conversor Alura");		
		setVisible(true);
		setBounds(300, 200, 240, 420);// modificar para centrar en la pantalla
		
	}

}
