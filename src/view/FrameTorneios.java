package view;

import java.awt.Color;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Classificacao;
import model.Clube;
import model.EAtleta;
import model.Torneio;
import model.EAtletaTorneio;

public class FrameTorneios extends JFrame {

	private static final long serialVersionUID = 1L;

	private JTextField txtNomeTorneio;
	private JTextField txtPorqueDoNome;
	private JComboBox<Clube> txtClube;
	private JComboBox<EAtleta> txtEatleta;

	private JButton btnEditarPartidas;
	private JButton btnNovoTorneio;
	private JButton btnRemoverJogador;
	private JButton btnAdicionarJogador;
	private JButton btnSalvarTorneio;
	private JButton btnDeletarTorneio;
	private JButton btnEditarTorneio;

	private DefaultListModel<Torneio> modelTorneios;
	private DefaultListModel<EAtletaTorneio> modelEatletaTorneio;
	private JList<EAtletaTorneio> jlstEatletaClube;
	private JList<Torneio> jlstTorneios;
	
	private JButton btnNovoJogadorClube;


	public FrameTorneios() {

		super("Torneio Lombra da Madrugada");

		JPanel panelTorneio = new JPanel();
		panelTorneio.setBackground(Color.LIGHT_GRAY);
		panelTorneio.setBounds(42, 214, 476, 186);
		getContentPane().add(panelTorneio);

		getContentPane().setLayout(null);
		modelTorneios = new DefaultListModel<Torneio>();
		jlstTorneios = new JList<Torneio>(modelTorneios);

		jlstTorneios.setBounds(42, 11, 451, 134);
		getContentPane().add(jlstTorneios);
		panelTorneio.setLayout(null);

		btnNovoTorneio = new JButton("Novo Torneio");

		btnNovoTorneio.setBounds(551, 23, 127, 25);
		getContentPane().add(btnNovoTorneio);

		JLabel lblNomeDoTorneio = new JLabel("Nome do Torneio");
		lblNomeDoTorneio.setBackground(Color.WHITE);
		lblNomeDoTorneio.setBounds(42, 185, 81, 14);
		getContentPane().add(lblNomeDoTorneio);

		JLabel lblPorqueEsseNome = new JLabel("Porque esse nome?");
		lblPorqueEsseNome.setBounds(558, 214, 93, 14);
		getContentPane().add(lblPorqueEsseNome);

		txtNomeTorneio = new JTextField();
		txtNomeTorneio.setText("NomeTorneio");
		txtNomeTorneio.setBounds(145, 179, 152, 20);
		getContentPane().add(txtNomeTorneio);
		txtNomeTorneio.setColumns(10);

		txtPorqueDoNome = new JTextField();
		txtPorqueDoNome.setText("Porque do nome");
		txtPorqueDoNome.setBounds(555, 239, 243, 150);
		getContentPane().add(txtPorqueDoNome);
		txtPorqueDoNome.setColumns(10);

		JLabel lblClube = new JLabel("Clube");
		lblClube.setBounds(32, 105, 27, 14);
		panelTorneio.add(lblClube);

		JLabel lblEatleta = new JLabel("EAtleta");
		lblEatleta.setBounds(32, 130, 35, 14);
		panelTorneio.add(lblEatleta);

		txtClube = new JComboBox<Clube>();
		txtClube.setBounds(93, 102, 96, 20);
		panelTorneio.add(txtClube);

		txtEatleta = new JComboBox<EAtleta>();
		txtEatleta.setBounds(93, 127, 96, 20);
		panelTorneio.add(txtEatleta);

		modelEatletaTorneio = new DefaultListModel<EAtletaTorneio>();

		JList<Classificacao> jlstClassif = new JList<>();
		jlstClassif.setBounds(42, 458, 746, 97);
		getContentPane().add(jlstClassif);

		btnRemoverJogador = new JButton("Remover Jogador e Clube");

		btnRemoverJogador.setBounds(32, 11, 157, 23);
		panelTorneio.add(btnRemoverJogador);

		jlstEatletaClube = new JList<EAtletaTorneio>(modelEatletaTorneio);
		jlstEatletaClube.setBounds(217, 11, 220, 155);
		panelTorneio.add(jlstEatletaClube);

		panelTorneio.add(jlstEatletaClube);
		btnAdicionarJogador = new JButton("Adicionar Jogador e Clube");
		btnAdicionarJogador.setBounds(32, 45, 157, 23);
		panelTorneio.add(btnAdicionarJogador);

		btnEditarPartidas = new JButton("Editar Partidas");

		btnEditarPartidas.setBounds(42, 422, 145, 25);
		getContentPane().add(btnEditarPartidas);
		btnSalvarTorneio = new JButton("Salvar Torneio");

		btnSalvarTorneio.setBounds(307, 180, 127, 23);
		getContentPane().add(btnSalvarTorneio);

		btnDeletarTorneio = new JButton("Deletar Torneio");

		btnDeletarTorneio.setBounds(551, 62, 127, 23);
		getContentPane().add(btnDeletarTorneio);

		btnEditarTorneio = new JButton("Editar Torneio");

		btnEditarTorneio.setBounds(551, 96, 127, 23);
		getContentPane().add(btnEditarTorneio);
		
		btnNovoJogadorClube = new JButton("Novo Jogador/Clube");
		
		btnNovoJogadorClube.setBounds(250, 423, 145, 23);
		getContentPane().add(btnNovoJogadorClube);
	}
	
	public JButton getBtnNovoJogadorClube() {
		return btnNovoJogadorClube;
	}

	public JList<Torneio> getJlstTorneios() {
		return jlstTorneios;
	}

	public JButton getBtnNovoTorneio() {
		return btnNovoTorneio;
	}

	public void setBtnNovoTorneio(JButton btnNovoTorneio) {
		this.btnNovoTorneio = btnNovoTorneio;
	}

	public JComboBox<Clube> getTxtClube() {
		return txtClube;
	}

	public JComboBox<EAtleta> getTxtEatleta() {
		return txtEatleta;
	}

	public JButton getBtnEditarTorneio() {
		return btnEditarTorneio;
	}

	public JButton getBtnDeletarTorneio() {
		return btnDeletarTorneio;
	}

	public JTextField getTxtPorqueDoNome() {
		return txtPorqueDoNome;
	}

	public JTextField getTxtNomeTorneio() {
		return txtNomeTorneio;
	}

	public DefaultListModel<Torneio> getModelTorneios() {
		return modelTorneios;
	}

	public DefaultListModel<EAtletaTorneio> getModelEatletaTorneio() {
		return modelEatletaTorneio;
	}

	public JList<EAtletaTorneio> getJlstEatletaClube() {
		return jlstEatletaClube;
	}

	public JButton getBtnRemoverJogador() {
		return btnRemoverJogador;
	}

	public JButton getBtnAdicionarJogador() {
		return btnAdicionarJogador;
	}

	public JButton getBtnSalvarTorneio() {
		return btnSalvarTorneio;
	}

	public JButton getBtnEditarPartidas() {
		return btnEditarPartidas;
	}

}
