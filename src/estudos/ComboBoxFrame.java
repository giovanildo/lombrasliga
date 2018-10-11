package estudos;

import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ComboBoxFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private final JComboBox<String> imagesJComboBox;
	private final JLabel label;

	private static final String[] names = { "bug1.GIF", "bug2.GIF", "travelbug.gif", "buganim.gif" };
	private final Icon[] icons = {new ImageIcon(getClass().getResource(names[0])),
			new ImageIcon(getClass().getResource(names[1])), new ImageIcon(getClass().getResource(names[2])),
			new ImageIcon(getClass().getResource(names[3]))};

	public ComboBoxFrame() {
		super("Testing JComboBox");
		setLayout(new FlowLayout());
		imagesJComboBox = new JComboBox<String>(names);
		imagesJComboBox.setMaximumRowCount(4);

		imagesJComboBox.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent event) {
				if (event.getStateChange() == ItemEvent.SELECTED)
					label.setIcon(icons[imagesJComboBox.getSelectedIndex()]);
			}

		}

		);
		add(imagesJComboBox);
		label = new JLabel(icons[0]);
		add(label);

	}

	public static void main(String[] args) {
		ComboBoxFrame comboBoxFrame = new ComboBoxFrame();
		comboBoxFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		comboBoxFrame.setSize(350,150);
		comboBoxFrame.setVisible(true);
	}

}
