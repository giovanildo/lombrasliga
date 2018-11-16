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

import model.Clube;
import model.EAtleta;
import model.Torneio;
import model.EAtletaTorneio;

public class FrameTorneios extends JFrame {

	private static final long serialVersionUID = 1L;
	/**
	 * txt Nome do Torneio 
	 * 
	 */
	private JTextField txtNomeTorneio;
	/**
	 * txt porque do nome
	 */
	private JTextField txtPorqueDoNome;
	/**
	 * combo box do clube
	 */
	private JComboBox<Clube> txtClube;
	/**
	 * combo box do eatleta
	 */
	private JComboBox<EAtleta> txtEatleta;
	/**
	 * botão para editar partidas
	 */
	private JButton btnEditarPartidas;
	/**
	 * botão para criar novo torneio
	 */
	private JButton btnNovoTorneio;
	/**
	 * botão para remover jogador
	 */
	private JButton btnRemoverJogador;
	/**
	 * botão para adicionar Jogador
	 */
	private JButton btnAdicionarJogador;
	/**
	 * botão para salvar Torneio
	 */
	private JButton btnSalvarTorneio;
	/**
	 * botão para deletar torneio
	 */
	private JButton btnDeletarTorneio;
	/**
	 * botão para editar torneio
	 */
	private JButton btnEditarTorneio;
	/**
	 * List Model dos torneios
	 */
	private DefaultListModel<Torneio> modelTorneios;
	/**
	 * Model List do eatleta torneio
	 */
	private DefaultListModel<EAtletaTorneio> modelEatletaTorneio;
	/**
	 * JList do Eatleta torneio
	 */
	private JList<EAtletaTorneio> jlstEatletaClube;
	/**
	 * Jlist dos torneios
	 */
	private JList<Torneio> jlstTorneios;
	/**
	 * botão para cadastrar novo jogador e clube
	 */
	private JButton btnNovoJogadorClube;

	/**
	 * Monta a tela
	 */
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
	/**
	 * 
	 * @return botão para cadastrar novo jogador e clube
	 */
	public JButton getBtnNovoJogadorClube() {
		return btnNovoJogadorClube;
	}
	/**
	 * 
	 * @return JList Torneio
	 */
	public JList<Torneio> getJlstTorneios() {
		return jlstTorneios;
	}
	/**
	 * 
	 * @return botão novo torneio
	 */
	public JButton getBtnNovoTorneio() {
		return btnNovoTorneio;
	}
	/**
	 * 
	 * @param btnNovoTorneio
	 */
	public void setBtnNovoTorneio(JButton btnNovoTorneio) {
		this.btnNovoTorneio = btnNovoTorneio;
	}
	/**
	 * 
	 * @return combo box de clubes
	 */
	public JComboBox<Clube> getTxtClube() {
		return txtClube;
	}
	/**
	 * 
	 * @return combobox de eatletas
	 */
	public JComboBox<EAtleta> getTxtEatleta() {
		return txtEatleta;
	}
	/**
	 * 
	 * @return botão editar torneio
	 */
	public JButton getBtnEditarTorneio() {
		return btnEditarTorneio;
	}
	/**
	 * 
	 * @return botão deletar torneio
	 */
	public JButton getBtnDeletarTorneio() {
		return btnDeletarTorneio;
	}
	/**
	 * 
	 * @return txt de Porque do nome
	 */
	public JTextField getTxtPorqueDoNome() {
		return txtPorqueDoNome;
	}
	/**
	 * 
	 * @return txt do nome do torneio
	 */
	public JTextField getTxtNomeTorneio() {
		return txtNomeTorneio;
	}
	/**
	 * 
	 * @return List Model de Torneios
	 */
	public DefaultListModel<Torneio> getModelTorneios() {
		return modelTorneios;
	}
	/**
	 * 
	 * @return list Model de eatletaTorneio
	 */
	public DefaultListModel<EAtletaTorneio> getModelEatletaTorneio() {
		return modelEatletaTorneio;
	}
	/**
	 * 
	 * @return JList de eatleta torneio
	 */
	public JList<EAtletaTorneio> getJlstEatletaClube() {
		return jlstEatletaClube;
	}
	/**
	 * 
	 * @return botão remover jogador
	 */
	public JButton getBtnRemoverJogador() {
		return btnRemoverJogador;
	}
	/**
	 * 
	 * @return botão de adicionar jogador
	 */
	public JButton getBtnAdicionarJogador() {
		return btnAdicionarJogador;
	}
	/**
	 * 
	 * @return botão salvar torneio
	 */
	public JButton getBtnSalvarTorneio() {
		return btnSalvarTorneio;
	}
	/**
	 * 
	 * @return botão de editar partidas
	 */
	public JButton getBtnEditarPartidas() {
		return btnEditarPartidas;
	}

}
