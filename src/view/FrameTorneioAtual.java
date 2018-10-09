package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Clube;
import model.EAtleta;
import model.EAtletaTorneio;

import javax.swing.JComboBox;
import javax.swing.JTabbedPane;
import javax.swing.JList;
import javax.swing.AbstractListModel;

public class FrameTorneioAtual extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtTorneio;
	private JLabel lblTorneio;
	private JLabel lblEAtleta;
	private JLabel lblClube;
	private JButton btnGerarTabela;
	private JPanel painel1;
	private JList list;

	public FrameTorneioAtual() {

		painel1 = new JPanel();
		lblTorneio = new JLabel("Torneio");
		lblTorneio.setBounds(24, 74, 36, 14);
		txtTorneio = new JTextField("Torneio");
		txtTorneio.setBounds(70, 71, 231, 20);
		lblEAtleta = new JLabel("Jogador de Video Game");
		lblEAtleta.setBounds(24, 99, 113, 14);
		lblClube = new JLabel("Clube");
		lblClube.setBounds(165, 96, 86, 20);
		btnGerarTabela = new JButton("Gerar Tabela");
		btnGerarTabela.setBounds(24, 245, 95, 23);
		painel1.setLayout(null);
		painel1.add(lblTorneio);
		painel1.add(txtTorneio);
		painel1.add(lblEAtleta);
		painel1.add(lblClube);
		painel1.add(btnGerarTabela);
		getContentPane().add(painel1);
		
		JLabel lblLombrasDaMadrugada = new JLabel("TORNEIO DE FUTEBOL ENTRE AMIGOS - LOMBRAS DA MADRUGADA");
		lblLombrasDaMadrugada.setBounds(10, 11, 476, 44);
		painel1.add(lblLombrasDaMadrugada);
		
		list.setBounds(24, 146, 290, 53);
		painel1.add(list);
		
	

	}
}
