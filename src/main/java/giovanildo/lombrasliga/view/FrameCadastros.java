package giovanildo.lombrasliga.view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.ListSelectionModel;

import giovanildo.lombrasliga.model.Clube;
import giovanildo.lombrasliga.model.EAtleta;

public class FrameCadastros extends JFrame {
	
	private static final long serialVersionUID = 1L;
	/**
	 * TextField do Clube
	 */
	private JTextField txtClube;
	/**
	 * textField do EAtleta
	 */
	private JTextField txtEatleta;
	/**
	 * List Model da Jlist de Clubes
	 */
	private DefaultListModel<Clube> modelClubes;
	/**
	 * List Model da Jlist de EAtletas
	 */
	private DefaultListModel<EAtleta> modelEatletas;
	/**
	 * List Model do JList de Clubes
	 */
	private JList<Clube> jlstClubes;
	/**
	 * Botão de cadastrar clubes
	 */
	private JButton btnAdicionarClube;
	/**
	 * Botão de cadastrar EAtleta
	 */
	private JButton btnAdicionarEatleta;
	/**
	 * JList dos EAtletas
	 */
	private JList<EAtleta> jlstEatleta;
	/**
	 * botão que permite retornar a tela principal
	 */
	private JButton  btnTelaPrincipal;
	/**
	 * botão que permite descadastrar um Eatleta
	 */
	private JButton btnApagarEatleta;
	/**
	 * botão que permite descadastrar Clube
	 */
	private JButton btnApagarClube;

	
	private JButton btnEditarClube;
	private JButton btnEditarEatleta;
	/**
	 * Monta a tela de Cadastros de Clube e Jogadores 
	 */
	public FrameCadastros() {

		getContentPane().setLayout(null);

		JLabel lblCadastros = new JLabel("CADASTROS");
		lblCadastros.setBounds(218, 24, 103, 15);
		getContentPane().add(lblCadastros);

		JLabel lblClube = new JLabel("Clube");
		lblClube.setBounds(56, 70, 70, 15);
		getContentPane().add(lblClube);

		txtClube = new JTextField();
		txtClube.setText("");
		txtClube.setBounds(130, 68, 114, 19);
		getContentPane().add(txtClube);
		txtClube.setColumns(10);

		JLabel lblEatleta = new JLabel("EAtleta");
		lblEatleta.setBounds(282, 70, 70, 15);
		getContentPane().add(lblEatleta);

		txtEatleta = new JTextField();
		txtEatleta.setText("");
		txtEatleta.setBounds(379, 68, 114, 19);
		getContentPane().add(txtEatleta);
		txtEatleta.setColumns(10);

		modelClubes = new DefaultListModel<Clube>();
		jlstClubes = new JList<Clube>(modelClubes);

		jlstClubes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		jlstClubes.setBounds(36, 211, 206, 263);
		getContentPane().add(jlstClubes);

		modelEatletas = new DefaultListModel<>();
		jlstEatleta = new JList<>(modelEatletas);
		jlstEatleta.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jlstEatleta.setBounds(282, 212, 243, 263);
		getContentPane().add(jlstEatleta);

		btnAdicionarClube = new JButton("Adicionar");
		btnAdicionarClube.setBounds(56, 96, 178, 25);
		getContentPane().add(btnAdicionarClube);

		btnAdicionarEatleta = new JButton("Adicionar");
		btnApagarClube = new JButton("Apagar");
		btnApagarClube.setBounds(56, 132, 178, 25);
		getContentPane().add(btnApagarClube);
		btnAdicionarEatleta.setBounds(292, 96, 221, 25);
		getContentPane().add(btnAdicionarEatleta);
		
		btnApagarEatleta = new JButton("Apagar");
		btnApagarEatleta.setBounds(292, 133, 221, 25);
		getContentPane().add(btnApagarEatleta);
		
		btnTelaPrincipal = new JButton("Tela Principal");
		
		btnTelaPrincipal.setBounds(186, 495, 150, 25);
		getContentPane().add(btnTelaPrincipal);
		
		btnEditarClube = new JButton("Editar");

		btnEditarClube.setBounds(56, 172, 178, 23);
		getContentPane().add(btnEditarClube);
		
		btnEditarEatleta = new JButton("Editar");

		btnEditarEatleta.setBounds(292, 166, 221, 23);
		getContentPane().add(btnEditarEatleta);
	}
	/**
	 * 
	 * @return Botão editar clube
	 */
	public JButton getBtnEditarClube() {
		return btnEditarClube;
	}

	/**
	 * 
	 * @return botão editar eatleta
	 */
	public JButton getBtnEditarEatleta() {
		return btnEditarEatleta;
	}
	/**
	 * 
	 * @return txt de clube
	 */
	public JTextField getTxtClube() {
		return txtClube;
	}
	
	/**
	 * 
	 * @return botão de apagar eatleta
	 */
	public JButton getBtnApagarEatleta() {
		return btnApagarEatleta;
	}
	/**
	 * 
	 * @return txt de EAtleta
	 */
	public JTextField getTxtEatleta() {
		return txtEatleta;
	}
	/**
	 * 
	 * @return model List de Clubes
	 */
	public DefaultListModel<Clube> getModelClubes() {
		return modelClubes;
	}
	/**
	 * 
	 * @return botão que direciona à tela principal
	 */
	public JButton getBtnTelaPrincipal() {
		return btnTelaPrincipal;
	}
	/**
	 * Model List de EAtlets
	 * @return
	 */
	public DefaultListModel<EAtleta> getModelEatletas() {
		return modelEatletas;
	}
	/**
	 * 
	 * @return JList de Clubes
	 */
	public JList<Clube> getJlstClubes() {
		return jlstClubes;
	}
	/**
	 * 
	 * @return retorna botão de cadastrar clube
	 */
	public JButton getBtnAdicionarClube() {
		return btnAdicionarClube;
	}
	/**
	 * 
	 * @return botão de cadastrar eatleta
	 */
	public JButton getBtnAdicionarEatleta() {
		return btnAdicionarEatleta;
	}
	/**
	 * 
	 * @return Jlist de EAtleta
	 */
	public JList<EAtleta> getJlstEatleta() {
		return jlstEatleta;
	}
	/**
	 * 
	 * @return botão de descadastrar clube
	 */
	public JButton getBtnApagarClube() {
		return btnApagarClube;
	}
}