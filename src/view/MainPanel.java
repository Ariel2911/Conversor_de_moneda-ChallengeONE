package view;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class MainPanel extends JPanel {
	
	private JLabel greeting, paragraph;
	private ButtonGroup optionGroup;
	private JRadioButton currency, temperature;
	
	public MainPanel() {
		
		greeting = new JLabel("Hola!");
		paragraph = new JLabel("Elije la opción que deseas utilizar");
		
		optionGroup = new ButtonGroup();
		currency = new JRadioButton("Moneda", true);
		temperature = new JRadioButton("Temperatura", false);
		
		optionGroup.add(currency);
		optionGroup.add(temperature);
		
		add(greeting);
		add(paragraph);
		add(currency);
		add(temperature);
	}
}