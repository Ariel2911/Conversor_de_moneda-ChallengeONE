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
	private ConverterPanel ConverterPanelCurrency;
	private ConverterPanel ConverterPanelTemperature;
	
	public MainPanel() {
		
		setLayout(new FlowLayout(FlowLayout.LEFT,0, 16));
		
		setBorder(BorderFactory.createEmptyBorder(8,8,8,8));
		
		ConverterPanelCurrency = new ConverterPanel(new Color(255,0,0), "importe", "150 pesos");
		ConverterPanelTemperature = new ConverterPanel(new Color(0,0,255), "valor", "150 Cº");
		
		ConverterPanelTemperature.setVisible(false);
		
		ActionListener evento = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == currency) {
					ConverterPanelTemperature.setVisible(false);
					ConverterPanelCurrency.setVisible(true);
				}
				
				if(e.getSource() == temperature) {
					ConverterPanelCurrency.setVisible(false);
					ConverterPanelTemperature.setVisible(true);
				}
			}
		};
		
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
		add(ConverterPanelTemperature);			
	}
}
