/**
 * 
 */
package estudos;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 * @author giovanildo
 *
 */
public class RadioButtonFrame extends JFrame{

	private static final long serialVersionUID = 1L;

	private final JTextField textField;
	private final Font plainFont;
	private final Font boldFont;
	private final Font italicFont;
	private final Font boldItalicFont;
	
	private final JRadioButton plainJRadioButton;
	private final JRadioButton boldJRadioButton;
	private final JRadioButton italicJRadioButton;
	private final JRadioButton boldItalicJRadioButton;
	
	
	
	private final ButtonGroup radioGroup;
	
	
	
	
	
	
	public RadioButtonFrame() {
		super("Radio Button Test");
		setLayout(new FlowLayout());
		textField = new JTextField("Watch the font style change", 25);
		add(textField);
		
		plainJRadioButton = new JRadioButton("Plain", true);
		boldJRadioButton = new JRadioButton("Bold", false);
		italicJRadioButton = new JRadioButton("Italic", false);
		boldItalicJRadioButton = new JRadioButton("Bold/Italic");
		add(plainJRadioButton);
		add(boldJRadioButton);
		add(italicJRadioButton);
		add(boldItalicJRadioButton);
		
		radioGroup = new ButtonGroup();
		radioGroup.add(boldItalicJRadioButton);
		radioGroup.add(italicJRadioButton);
		radioGroup.add(boldJRadioButton);
		radioGroup.add(plainJRadioButton);
		
		plainFont = new Font("Serif", Font.PLAIN, 14);
		boldFont = new Font("Serif", Font.BOLD, 14);
		italicFont = new Font("Serif", Font.ITALIC, 14);
		boldItalicFont = new Font("Serif", Font.BOLD + Font.ITALIC, 14);
		textField.setFont(plainFont);
		
		plainJRadioButton.addItemListener(new RadioButtonHandler(plainFont));
		boldJRadioButton.addItemListener(new RadioButtonHandler(boldFont));
		italicJRadioButton.addItemListener(new RadioButtonHandler(italicFont));
		boldItalicJRadioButton.addItemListener(new RadioButtonHandler(boldItalicFont));
	}
	private class RadioButtonHandler implements ItemListener{
		
		private Font font;
		
		public RadioButtonHandler(Font f) {
			font = f;
		}

		@Override
		public void itemStateChanged(ItemEvent e) {
			textField.setFont(font);
		}
		
	}

	public static void main(String[] args) {
		RadioButtonFrame radioButtonFrame = new RadioButtonFrame();
		radioButtonFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		radioButtonFrame.setSize(300,100);
		radioButtonFrame.setVisible(true);
	}

}
