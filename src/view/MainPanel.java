package view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

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
		
		Map<String, Double> currencyMap = new HashMap<>();		
		currencyMap.put("USD", 1.0);
		currencyMap.put("ARS", 0.005451400697230547);
		currencyMap.put("BRL", 0.19210453086509793);
		
		Map<String, Double> temperatureMap = new HashMap<>();		
		temperatureMap.put("C°", 1.0);
		temperatureMap.put("F°", 33.8);
		
		ConverterPanelCurrency = new ConverterPanel(new Color(72,120,250), "importe", "0.00 ARS", currencyMap, "Currency");
		ConverterPanelTemperature = new ConverterPanel(new Color(220,60,60), "valor", "0.00 F°", temperatureMap, "Temperature");
		
		ConverterPanelTemperature.setVisible(false);
		
		ActionListener evento = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == currency) {
					ConverterPanelTemperature.setVisible(false);
					ConverterPanelCurrency.setVisible(true);
				}else if(e.getSource() == temperature) {
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
