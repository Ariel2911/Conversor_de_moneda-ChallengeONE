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
		currencyMap.put("ARS", 0.0055);
		currencyMap.put("BRL", 0.19);
		
		Map<String, Double> temperatureMap = new HashMap<>();		
		temperatureMap.put("Cº", 1.0);
		temperatureMap.put("Fº", 0.0055);
		
		ConverterPanelCurrency = new ConverterPanel(new Color(255,0,0), "importe", "0.00 ARS", currencyMap);
		ConverterPanelTemperature = new ConverterPanel(new Color(0,0,255), "valor", "0.00 Fº", temperatureMap);
		
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
