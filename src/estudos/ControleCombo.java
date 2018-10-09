package estudos;

import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;

public class ControleCombo extends JFrame implements ItemListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JComboBox<String> combo;
	JLabel label;
	ImageIcon[] imagens = { new ImageIcon(getClass().getResource("/fotos/01.JPG")),
			new ImageIcon(getClass().getResource("/fotos/02.JPG")),
			new ImageIcon(getClass().getResource("/fotos/03.JPG")),
			new ImageIcon(getClass().getResource("/fotos/04.JPG")) };

	public ControleCombo() {
		super("�lbum de Fotos");

		Container c = getContentPane();

		combo = new JComboBox<String>();
		combo.setFont(new Font("Serif", Font.PLAIN, 26));
		combo.addItem("Mari01");
		combo.addItem("Mari02");
		combo.addItem("Mari03");
		combo.addItem("Mari04");
		combo.addItemListener(this);

		label = new JLabel(imagens[0]);

		c.add(BorderLayout.NORTH, combo);
		c.add(BorderLayout.CENTER, label);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(300, 530);
		setVisible(true);

	}

	public static void main(String[] args) {
		new ControleCombo();
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED) {
			label.setIcon(imagens[combo.getSelectedIndex()]);
		}
	}
}
