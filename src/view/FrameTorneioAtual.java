package view;

import java.awt.HeadlessException;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.TextField;
import java.awt.List;

public class FrameTorneioAtual extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtTorneio;
	private JLabel lblTorneio;
	private JTextField txtEAtleta;
	private JLabel lblEAtleta;
	private TextField txtClube;
	private JLabel lblClube;
	private JButton btnGerarTabela;
	private JPanel painel1;

	public void iniciar() {

	}

	public FrameTorneioAtual() {
		
		painel1 = new JPanel();
		lblTorneio = new JLabel("Torneio");
		txtTorneio = new JTextField("Torneio");
		lblEAtleta = new JLabel("Jogador de Video Game");
		txtEAtleta = new JTextField("Jogador de Video Game");
		lblClube = new JLabel("Clube");
		txtClube = new TextField("Clube");
		btnGerarTabela = new JButton("Gerar Tabela");
		painel1.add(lblTorneio);
		painel1.add(txtTorneio);
		painel1.add(lblEAtleta);
		painel1.add(txtEAtleta);
		painel1.add(lblClube);
		painel1.add(txtClube);
		painel1.add(btnGerarTabela);
		getContentPane().add(painel1);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
//		pack();
		setVisible(true);
		
		
	}

	public void testes() {

		JFileChooser fc = new JFileChooser();
		int retorno = fc.showOpenDialog(null);
		if (retorno == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			System.out.println(file.getAbsolutePath());
		}

	}

}
