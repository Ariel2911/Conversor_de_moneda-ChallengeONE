package view;

import java.awt.Button;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;

public class ConverterPanel extends JPanel {
	private JLabel value, result;
	private JTextField valueField;
	private JComboBox<Object> combo1, combo2;
	private Button buttonConverter;	
	private Map<String, Double> currencyMap;
	
	
	public ConverterPanel(Color color, String value, String result) {
		
		currencyMap = new HashMap<>();
		
		currencyMap.put("USD", 1.0);
		currencyMap.put("ARS", 0.0055);
		currencyMap.put("BRL", 0.19);
		
		for (String item : currencyMap.keySet()) {
			
			System.out.println(item);
		}
		
		setLayout(new GridLayout(6, 1, 8, 8));
		setBorder(new CompoundBorder(
				new LineBorder(
						color, 2 , true), 
						BorderFactory.createEmptyBorder(8,8,8,8)
					)
				);
		
		ActionListener event = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("convertir");
				
			}
		}; 
		
		this.value = new JLabel(value);
		this.result = new JLabel(result);
		this.result.setForeground(color);
		this.result.setFont(new Font("Sanserif", Font.BOLD, 18));
		
		this.valueField = new JTextField("150",20);
		
		this.combo1 = new JComboBox<Object>();
		this.combo2 = new JComboBox<Object>();
		
		for (String item : currencyMap.keySet()) {
			
			this.combo1.addItem(item);
		}
		for (String item : currencyMap.keySet()) {
			
			this.combo2.addItem(item);
		}
		
		
		this.buttonConverter = new Button("Convertir");
		this.buttonConverter.setBackground(color);
		this.buttonConverter.setFont(new Font("Sanserif", Font.PLAIN, 18));
		this.buttonConverter.setForeground(Color.WHITE);
		this.buttonConverter.setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.buttonConverter.addActionListener(event);

		add(this.value);
		add(this.valueField);
		add(this.combo1);
		add(this.combo2);
		add(this.buttonConverter);
		add(this.result);		
	}
}
