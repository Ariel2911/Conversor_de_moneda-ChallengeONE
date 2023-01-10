package view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class MainPanel extends JPanel {
	
	private JLabel greeting, paragraph;
	private ButtonGroup optionGroup;
	private JRadioButton currency, temperature;
	
	public MainPanel() {
		
		ConverterPanel ConverterPanelCurrency = new ConverterPanel(new Color(255,0,0), "importe", "150 pesos");
		ConverterPanel ConverterPanelTemperature = new ConverterPanel(new Color(0,0,255), "valor", "150 Cº");
		
		ActionListener evento = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			
				if(e.getSource() == currency) {
//					System.out.println("currency");
					remove(ConverterPanelTemperature);
					repaint();
					add(ConverterPanelCurrency);
				}
				
				if(e.getSource() == temperature) {
//					System.out.println("temperature");
					remove(ConverterPanelCurrency);
					repaint();
					add(ConverterPanelTemperature);
				}
				
			}
		};
		
		setLayout(new FlowLayout(FlowLayout.LEFT,4, 16));
		setBorder(BorderFactory.createEmptyBorder(16,4,16,0));
		
		greeting = new JLabel("Hola!");
		paragraph = new JLabel("Elije la opción que deseas utilizar");		
		
		optionGroup = new ButtonGroup();
		currency = new JRadioButton("Moneda", true);
		temperature = new JRadioButton("Temperatura", false);
		
		currency.addActionListener(evento);
		temperature.addActionListener(evento);
		
		optionGroup.add(currency);
		optionGroup.add(temperature);
		
		add(greeting);
		add(paragraph);
		add(currency);
		add(temperature);
		
		add(ConverterPanelCurrency);
			
	}
}
