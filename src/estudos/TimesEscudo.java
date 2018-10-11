package estudos;

import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class TimesEscudo extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private final JComboBox<String> times;
	private final JLabel label;
	
	private static final String[] escudos = {"palmeiras.jpg","ceara.png","fortaleza.jpg","ferroviario.png"	};
	private final Icon[] icons = 
		{
		new ImageIcon(getClass().getResource(escudos[0])),
		new ImageIcon(getClass().getResource(escudos[1])),
		new ImageIcon(getClass().getResource(escudos[2])),
		new ImageIcon(getClass().getResource(escudos[3])),			
			
			};
		
	public TimesEscudo() {
		super("times e escudo");
		setLayout(new FlowLayout());
		
		times = new JComboBox<String>(escudos);
		times.setMaximumRowCount(4);		
		times.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent event) {
				if(event.getStateChange() == ItemEvent.SELECTED)
					label.setIcon(icons[times.getSelectedIndex()]);
			}
			
		});
		
		add(times);
		label = new JLabel(icons[0]);
		
		add(label);
	}

	public static void main(String[] args) {
		TimesEscudo timesEscudo = new TimesEscudo();
		timesEscudo.setDefaultCloseOperation(EXIT_ON_CLOSE);
		timesEscudo.setSize(350,150);
		timesEscudo.setVisible(true);		
	}

}
