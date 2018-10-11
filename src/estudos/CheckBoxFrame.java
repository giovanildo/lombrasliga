package estudos;

import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;

public class CheckBoxFrame extends JFrame {

	private final JTextField textField;
	private final JCheckBox boldJCheckBox;
	private final JCheckBox italicJCheckBox;

	public CheckBoxFrame() {
		super("JCheckBox Test");
		setLayout(new FlowLayout());

		textField = new JTextField("Watch the font style change", 20);
		textField.setFont(new Font("Serif", Font.PLAIN, 14));
		add(textField);

		boldJCheckBox = new JCheckBox("Bold");
		italicJCheckBox = new JCheckBox("Italic");

		add(boldJCheckBox);
		add(italicJCheckBox);

		CheckBoxHandler handler = new CheckBoxHandler();
		boldJCheckBox.addItemListener(handler);
		italicJCheckBox.addItemListener(handler);
	}

	private class CheckBoxHandler implements ItemListener {

		@Override
		public void itemStateChanged(ItemEvent event) {
			Font font = null;

			if (boldJCheckBox.isSelected() && italicJCheckBox.isSelected())
				font = new Font("Serif", Font.BOLD + Font.ITALIC, 14);
			else if (boldJCheckBox.isSelected())
				font = new Font("Serif", Font.BOLD, 14);
			
			else if (italicJCheckBox.isSelected()) {
				font = new Font("Serif", Font.ITALIC, 14);
			} else {
				font = new Font("Serif", Font.PLAIN, 14);
			}
			textField.setFont(font);
		}
	}

	public static void main(String[] args) {
		CheckBoxFrame checkBoxFrame = new CheckBoxFrame();
		checkBoxFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		checkBoxFrame.setSize(275,100);
		checkBoxFrame.setVisible(true);
	}

}
