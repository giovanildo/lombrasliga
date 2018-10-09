package gui;

import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;

public class ControleCheck extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1617532082248645034L;
	JTextField texto;
	JCheckBox bold, italic;

	public ControleCheck() {
		super("Controle Check");

		texto = new JTextField("Veja a Fonte Mudar", 12);
		texto.setFont(new Font("Serif", Font.PLAIN, 26));

		bold = new JCheckBox("Bold");
		bold.addItemListener(new CheckListener());
		italic = new JCheckBox("Italic");
		italic.addItemListener(new CheckListener());

		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		c.add(texto);
		c.add(bold);
		c.add(italic);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(300, 300);
		setVisible(true);

	}

	class CheckListener implements ItemListener {

		@Override
		public void itemStateChanged(ItemEvent e) {
			if (bold.isSelected() && italic.isSelected()) {
				texto.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 26));
			} else if (bold.isSelected()) {
				texto.setFont(new Font("Serif", Font.BOLD, 26));
			} else if (italic.isSelected()) {
				texto.setFont(new Font("Serif", Font.ITALIC, 26));
			} else {
				texto.setFont(new Font("Serif", Font.PLAIN, 26));
			}

		}

	}

	public static void main(String[] args) {
		new ControleCheck();
	}

}
