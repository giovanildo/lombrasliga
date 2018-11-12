package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;

import model.Partida;

import javax.swing.DefaultListModel;
import javax.swing.JButton;

public class FramePartidas extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtAnfitrio;
	private JTextField txtVisitante;

	private DefaultListModel<Partida> modelPartidas;
	
	public DefaultListModel<Partida> getModelPartidas() {
		return modelPartidas;
	}

	public FramePartidas() {
		getContentPane().setLayout(null);

		JLabel lblPartidas = new JLabel("PARTIDAS");
		lblPartidas.setBounds(369, 27, 70, 15);
		getContentPane().add(lblPartidas);

		JLabel lblAnfitriao = new JLabel("Anfitrião");
		lblAnfitriao.setBounds(34, 510, 70, 15);
		getContentPane().add(lblAnfitriao);

		JLabel lblX = new JLabel("X");
		lblX.setBounds(249, 510, 70, 15);
		getContentPane().add(lblX);

		JLabel lblVisitante = new JLabel("Visitante");
		lblVisitante.setBounds(398, 510, 70, 15);
		getContentPane().add(lblVisitante);

		txtAnfitrio = new JTextField();
		txtAnfitrio.setText("gols");
		txtAnfitrio.setBounds(121, 508, 114, 19);
		getContentPane().add(txtAnfitrio);
		txtAnfitrio.setColumns(10);

		txtVisitante = new JTextField();
		txtVisitante.setText("gols");
		txtVisitante.setBounds(272, 508, 114, 19);
		getContentPane().add(txtVisitante);
		txtVisitante.setColumns(10);

		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setBounds(469, 505, 117, 25);
		getContentPane().add(btnConfirmar);

		modelPartidas = new DefaultListModel<Partida>();
		JList<Partida> jlstPartidas = new JList<>(modelPartidas);		
		jlstPartidas.setBounds(34, 53, 525, 444);
		getContentPane().add(jlstPartidas);
		
		JButton btnAlterarPlacar = new JButton("Alterar Placar");
		btnAlterarPlacar.setBounds(610, 506, 102, 23);
		getContentPane().add(btnAlterarPlacar);
	}
}
