package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;

import model.Partida;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FramePartidas extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtAnfitriao;
	private JTextField txtVisitante;
	private JButton btnAlterarPlacar;
	private JButton btnConfirmar;
	
	/**
	 * @return the txtAnfitriao
	 */
	public JTextField getTxtAnfitriao() {
		return txtAnfitriao;
	}


	/**
	 * @return the txtVisitante
	 */
	public JTextField getTxtVisitante() {
		return txtVisitante;
	}


	/**
	 * @return the btnConfirmar
	 */
	public JButton getBtnConfirmar() {
		return btnConfirmar;
	}

	private JList<Partida> jlstPartidas;
	
	private JLabel lblAnfitriao;
	
	private JLabel lblVisitante;
	
	/**
	 * @return the lblAnfitriao
	 */
	public JLabel getLblAnfitriao() {
		return lblAnfitriao;
	}


	/**
	 * @return the lblVisitante
	 */
	public JLabel getLblVisitante() {
		return lblVisitante;
	}


	/**
	 * @return the jlstPartidas
	 */
	public JList<Partida> getJlstPartidas() {
		return jlstPartidas;
	}

	private DefaultListModel<Partida> modelPartidas;

	/**
	 * @return the btnAlterarPlacar
	 */
	public JButton getBtnAlterarPlacar() {
		return btnAlterarPlacar;
	}

	
	public DefaultListModel<Partida> getModelPartidas() {
		return modelPartidas;
	}

	public FramePartidas() {
		getContentPane().setLayout(null);

		JLabel lblPartidas = new JLabel("PARTIDAS");
		lblPartidas.setBounds(369, 27, 70, 15);
		getContentPane().add(lblPartidas);

		lblAnfitriao = new JLabel("Anfitrião");
		lblAnfitriao.setBounds(34, 510, 70, 15);
		getContentPane().add(lblAnfitriao);

		JLabel lblX = new JLabel("X");
		lblX.setBounds(249, 510, 70, 15);
		getContentPane().add(lblX);

		lblVisitante = new JLabel("Visitante");
		lblVisitante.setBounds(398, 510, 70, 15);
		getContentPane().add(lblVisitante);

		txtAnfitriao = new JTextField();
		txtAnfitriao.setText("gols");
		txtAnfitriao.setBounds(121, 508, 114, 19);
		getContentPane().add(txtAnfitriao);
		txtAnfitriao.setColumns(10);

		txtVisitante = new JTextField();
		txtVisitante.setText("gols");
		txtVisitante.setBounds(272, 508, 114, 19);
		getContentPane().add(txtVisitante);
		txtVisitante.setColumns(10);

		 btnConfirmar = new JButton("Confirmar");

		btnConfirmar.setBounds(469, 505, 117, 25);
		getContentPane().add(btnConfirmar);

		modelPartidas = new DefaultListModel<Partida>();
		jlstPartidas = new JList<>(modelPartidas);		
		jlstPartidas.setBounds(34, 53, 525, 444);
		getContentPane().add(jlstPartidas);
		
		btnAlterarPlacar = new JButton("Alterar Placar");

		btnAlterarPlacar.setBounds(610, 506, 102, 23);
		getContentPane().add(btnAlterarPlacar);
	}
}
