package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;

import model.Classificacao;
import model.Partida;

import javax.swing.DefaultListModel;
import javax.swing.JButton;

import javax.swing.ListSelectionModel;


public class FramePartidas extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtGolsAnfitriao;
	private JTextField txtGolsVisitante;
	private JButton btnAlterarPlacar;
	private JButton btnConfirmar;
	private JList<Partida> jlstPartidas;
	private JLabel lblAnfitriao;
	private JLabel lblVisitante;
	private DefaultListModel<Partida> modelPartidas;
	private JList<Classificacao> jlstClassif;
	private DefaultListModel<Classificacao> modelClassif;
	


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

		txtGolsAnfitriao = new JTextField();
		txtGolsAnfitriao.setText("gols");
		txtGolsAnfitriao.setBounds(121, 508, 114, 19);
		getContentPane().add(txtGolsAnfitriao);
		txtGolsAnfitriao.setColumns(10);

		txtGolsVisitante = new JTextField();
		txtGolsVisitante.setText("gols");
		txtGolsVisitante.setBounds(272, 508, 114, 19);
		getContentPane().add(txtGolsVisitante);
		txtGolsVisitante.setColumns(10);

		btnConfirmar = new JButton("Confirmar");


		btnConfirmar.setBounds(183, 549, 117, 25);
		getContentPane().add(btnConfirmar);

		modelPartidas = new DefaultListModel<Partida>();
		jlstPartidas = new JList<>();
		jlstPartidas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		jlstPartidas.setModel(modelPartidas);
		jlstPartidas.setBounds(34, 53, 359, 444);
		getContentPane().add(jlstPartidas);
		
		modelClassif = new DefaultListModel<Classificacao>();
		jlstClassif = new JList<Classificacao>(modelClassif);
		jlstClassif.setBounds(419, 53, 477, 444);
		getContentPane().add(jlstClassif);
		
//		btnAlterarPlacar = new JButton("Alterar Placar");
//
//		btnAlterarPlacar.setBounds(228, 551, 122, 23);
//		getContentPane().add(btnAlterarPlacar);
	}
	
	/**
	 * @return the modelClassif
	 */
	public DefaultListModel<Classificacao> getModelClassif() {
		return modelClassif;
	}



	/**
	 * @return the jlstClassif
	 */
	public JList<Classificacao> getJlstClassif() {
		return jlstClassif;
	}



	public JTextField getTxtGolsAnfitriao() {
		return txtGolsAnfitriao;
	}



	public JTextField getTxtGolsVisitante() {
		return txtGolsVisitante;
	}
	
	/**
	 * @return the btnConfirmar
	 */
	public JButton getBtnConfirmar() {
		return btnConfirmar;
	}
	
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

	/**
	 * @return the btnAlterarPlacar
	 */
	public JButton getBtnAlterarPlacar() {
		return btnAlterarPlacar;
	}

	public DefaultListModel<Partida> getModelPartidas() {
		return modelPartidas;
	}
}
