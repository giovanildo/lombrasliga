package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JButton;

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

		JLabel lblAnfitriao = new JLabel("Anfitrião");
		lblAnfitriao.setBounds(64, 574, 70, 15);
		getContentPane().add(lblAnfitriao);

		JLabel lblX = new JLabel("X");
		lblX.setBounds(279, 574, 70, 15);
		getContentPane().add(lblX);

		JLabel lblVisitante = new JLabel("Visitante");
		lblVisitante.setBounds(428, 574, 70, 15);
		getContentPane().add(lblVisitante);

		txtAnfitrio = new JTextField();
		txtAnfitrio.setText("gols");
		txtAnfitrio.setBounds(151, 572, 114, 19);
		getContentPane().add(txtAnfitrio);
		txtAnfitrio.setColumns(10);

		txtVisitante = new JTextField();
		txtVisitante.setText("gols");
		txtVisitante.setBounds(302, 572, 114, 19);
		getContentPane().add(txtVisitante);
		txtVisitante.setColumns(10);

		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setBounds(520, 569, 117, 25);
		getContentPane().add(btnConfirmar);
		
		JList jlstPartidas = new JList();
		jlstPartidas.setBounds(43, 49, 713, 486);
		getContentPane().add(jlstPartidas);
	}
}
