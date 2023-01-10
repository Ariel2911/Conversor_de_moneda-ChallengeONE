package view;

import java.awt.Color;
import java.awt.GridLayout;

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
	
	public ConverterPanel() {
		
		setLayout(new GridLayout(5, 1, 8, 8));
		setBorder(new CompoundBorder(
				new LineBorder(
						Color.RED, 2 , true), 
						BorderFactory.createEmptyBorder(8,8,8,8)
					)
				);		
		
		value = new JLabel("importe");
		result = new JLabel("150 pesos");
		
		valueField = new JTextField("150",20);
		
		combo1 = new JComboBox<Object>();
		combo2 = new JComboBox<Object>();
		
		combo1.addItem("monada 1");
		combo2.addItem("monada 2");

		add(value);
		add(valueField);
		add(combo1);
		add(combo2);
		add(result);
		
	}
}
