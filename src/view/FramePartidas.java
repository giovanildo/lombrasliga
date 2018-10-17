package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTree;

public class FramePartidas extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtAnfitrio;
	private JTextField txtVisitante;

	public FramePartidas() {
		getContentPane().setLayout(null);

		JLabel lblPartidas = new JLabel("PARTIDAS");
		lblPartidas.setBounds(369, 27, 70, 15);
		getContentPane().add(lblPartidas);

		JList list = new JList();
		list.setBounds(64, 82, 769, 279);
		getContentPane().add(list);

		JLabel lblAnfitrio = new JLabel("Anfitrião");
		lblAnfitrio.setBounds(64, 412, 70, 15);
		getContentPane().add(lblAnfitrio);

		JLabel lblX = new JLabel("X");
		lblX.setBounds(266, 412, 70, 15);
		getContentPane().add(lblX);

		JLabel lblVisitante = new JLabel("Visitante");
		lblVisitante.setBounds(428, 412, 70, 15);
		getContentPane().add(lblVisitante);

		txtAnfitrio = new JTextField();
		txtAnfitrio.setText("gols");
		txtAnfitrio.setBounds(151, 410, 114, 19);
		getContentPane().add(txtAnfitrio);
		txtAnfitrio.setColumns(10);

		txtVisitante = new JTextField();
		txtVisitante.setText("gols");
		txtVisitante.setBounds(302, 410, 114, 19);
		getContentPane().add(txtVisitante);
		txtVisitante.setColumns(10);

		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setBounds(520, 407, 117, 25);
		getContentPane().add(btnConfirmar);
	}
}
