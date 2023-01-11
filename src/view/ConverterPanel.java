package view;

import java.awt.Button;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Cursor;
import java.awt.Font;
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
	private Button buttonConverter;
	
	public ConverterPanel(Color color, String value, String result) {
		
		setLayout(new GridLayout(6, 1, 8, 8));
		setBorder(new CompoundBorder(
				new LineBorder(
						color, 2 , true), 
						BorderFactory.createEmptyBorder(8,8,8,8)
					)
				);		
		
		this.value = new JLabel(value);
		this.result = new JLabel(result);
		
		this.valueField = new JTextField("150",20);
		
		this.combo1 = new JComboBox<Object>();
		this.combo2 = new JComboBox<Object>();
		
		this.combo1.addItem("monada 1");
		this.combo2.addItem("monada 2");
		
		this.buttonConverter = new Button("Convertir");
		this.buttonConverter.setBackground(color);
		this.buttonConverter.setFont(new Font("Sanserif", Font.PLAIN, 18));
		this.buttonConverter.setForeground(Color.WHITE);
		this.buttonConverter.setCursor(new Cursor(Cursor.HAND_CURSOR));

		add(this.value);
		add(this.valueField);
		add(this.combo1);
		add(this.combo2);
		add(this.buttonConverter);
		add(this.result);
		
	}
}
