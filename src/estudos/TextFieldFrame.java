package estudos;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class TextFieldFrame extends JFrame{

	private final JTextField textField1;
	private final JTextField textField2;	
	private final JTextField textField3;
	private final JPasswordField passwordField;
	
	public TextFieldFrame() {
		super("Testing");
		setLayout(new FlowLayout());

		textField1 = new JTextField(10);
		add(textField1);
		
		textField2 = new JTextField("enter text here");
		add(textField2);
		
		textField3 = new JTextField("Uneditable text", 21);
		add(textField3);
		
		passwordField = new JPasswordField("hidden text");
		add(passwordField);
		
		TextFieldHandler handler = new TextFieldHandler();
		
		textField1.addActionListener(handler);
		textField2.addActionListener(handler);		
		textField3.addActionListener(handler);
		
		passwordField.addActionListener(handler);
	}
	private class TextFieldHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent event) {
			String string = "";
			
			if(event.getSource() == textField1) {
				string = String.format("textField1:%s", event.getActionCommand());				
			}
			if(event.getSource() == textField2) {
				string = String.format("textField2:%s", event.getActionCommand());				
			}
			if(event.getSource() == textField3) {
				string = String.format("textField3:%s", event.getActionCommand());				
			}
			if(event.getSource() == passwordField) {
				string = String.format("passwordField:%s", event.getActionCommand());				
			}
			JOptionPane.showMessageDialog(null, string);
		}
		
	}
	
}
