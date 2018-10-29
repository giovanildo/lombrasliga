package estudos;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ListFrame extends JFrame

{
	private static final long serialVersionUID = 1L;

	private final JList<String> colorJList;
	private static final String[] colorNames = { "Black", "Blue", "Cyan", "Dark Gray", "Light Gray", "Magenta",
			"Orange", "Pink", "Red", "White", "Yellow" };
	private static final Color[] colors = { Color.BLACK, Color.BLUE, Color.CYAN, Color.DARK_GRAY, Color.LIGHT_GRAY,
			Color.MAGENTA, Color.ORANGE, Color.PINK, Color.RED, Color.WHITE, Color.YELLOW };

	public ListFrame() {
		super("List Test");
		setLayout(new FlowLayout());

		colorJList = new JList<String>(colorNames);
		colorJList.setVisibleRowCount(5);

		colorJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		add(new JScrollPane(colorJList));
		
		final JLabel label = new JLabel("Cor");
		
		add(label);

		colorJList.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent event) {
				getContentPane().setBackground(colors[colorJList.getSelectedIndex()]);
				label.setText(colorNames[colorJList.getSelectedIndex()]);
			}
		}
		);
	}

	public static void main(String[] args) {
		ListFrame listFrame = new ListFrame();
		listFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		listFrame.setSize(350, 150);
		listFrame.setVisible(true);
	}

}
