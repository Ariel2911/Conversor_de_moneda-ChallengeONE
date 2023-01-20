package view;

import java.awt.Button;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;

public class ConverterPanel extends JPanel {
	private JLabel value, result;
	private JTextField valueField;
	private JComboBox<String> combo1, combo2;
	private Button buttonConverter;		
	
	public ConverterPanel(Color color, String value, String result, Map<String, Double> valueMap) {
		
		setLayout(new GridLayout(6, 1, 8, 8));
		setBorder(new CompoundBorder(
				new LineBorder(
						color, 2 , true), 
						BorderFactory.createEmptyBorder(8,8,8,8)
					)
				);
		
		this.value = new JLabel(value);
		this.result = new JLabel(result);
		this.result.setForeground(color);
		this.result.setFont(new Font("Sanserif", Font.BOLD, 18));
		
		this.valueField = new JTextField("0.00",15);
		this.valueField.setFont(new Font("Sanserif", Font.BOLD, 14));
		this.valueField.setForeground(color);
		this.valueField.setBorder(
				new CompoundBorder(
						new LineBorder(color, 2, true), 
						BorderFactory.createEmptyBorder(8,4,8,4)
						)
				);
//		this.valueField.setBackground(getBackground());
		
		this.combo1 = new JComboBox<String>();
		this.combo2 = new JComboBox<String>();
		
		valueMap.keySet().forEach((key) -> this.combo1.addItem(key));
		valueMap.keySet().forEach((key) -> this.combo2.addItem(key));

		ActionListener event = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					Double DoubleValueField = Double.parseDouble(valueField.getText());
					Double valueSelectCombo1 = valueMap.get(combo1.getSelectedItem());
					Double valueSelectCombo2 = valueMap.get(combo2.getSelectedItem());				
					Double resultConvert = 
							(DoubleValueField * valueSelectCombo1) 
							/ valueSelectCombo2;				
					String formatResultConvert;
					
					if(resultConvert > 999999999) {
						
						formatResultConvert =  "+" + "999999999.99";
						JOptionPane.showMessageDialog(
								ConverterPanel.this, 
								"No es posible mostrar el resultado de la converción ya que supera los 9 dígitos disponibles"
								);
						
					} else {					
						
						DecimalFormatSymbols a = new DecimalFormatSymbols();						
						a.setDecimalSeparator('.');
						
						formatResultConvert = new DecimalFormat("0.00", a).format(resultConvert);
					}
					
					ConverterPanel.this.result.setText(
							formatResultConvert 
							+" " 
							+ combo2.getSelectedItem()
							);				
					
				}
				catch(Exception error) {
					JOptionPane.showMessageDialog(
							ConverterPanel.this, 
							"Dato inválido. Verifique el valor ingresado.");
				}
				
			}
		}; 
				
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
