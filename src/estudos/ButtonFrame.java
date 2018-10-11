package estudos;

import java.awt.Event;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ButtonFrame extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JButton plainJButton;
	private final JButton fancyJButton;
	
	
	public ButtonFrame() {
		super("Testing Buttons");
		setLayout(new FlowLayout());
		
		plainJButton = new JButton("Plain Button");
		add(plainJButton);
		
		Icon bug1 = new ImageIcon(getClass().getResource("bug1.GIF"));
		Icon bug2 = new ImageIcon(getClass().getResource("bug2.GIF"));
		fancyJButton = new JButton("FancyButton");
		fancyJButton.setRolloverIcon(bug2);
		add(fancyJButton);
		
		ButtonHandler handler = new ButtonHandler();
		fancyJButton.addActionListener(handler);
		plainJButton.addActionListener(handler);
		
	}
	
	private class ButtonHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {
			JOptionPane.showMessageDialog(ButtonFrame.this,  String.format("You pressed: %s", event.getActionCommand()));
		}
		
	}

	public static void main(String[] args) {
		ButtonFrame buttonFrame = new ButtonFrame();
		buttonFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		buttonFrame.setSize(275,110);
		buttonFrame.setVisible(true);
	}
	
}