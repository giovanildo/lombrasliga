package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import model.Clube;
import model.EAtleta;

import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.ListSelectionModel;

public class FrameCadastros extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	private JTextField txtClube;
	private JTextField txtEatleta;
	private DefaultListModel<Clube> modelClubes;
	private DefaultListModel<EAtleta> modelEatletas;
	private JList<Clube> jlstClubes;
	private JButton btnAdicionarClube;
	private JButton btnAdicionarEatleta;
	private JList<EAtleta> jlstEatleta;
	private JButton  btnTelaPrincipal;
	private JButton btnApagarEatleta;
	private JButton btnApagarClube;
	private JButton btnEditarClube;
	private JButton btnEditarEatleta;
	
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

	public JButton getBtnEditarClube() {
		return btnEditarClube;
	}


	public JButton getBtnEditarEatleta() {
		return btnEditarEatleta;
	}

	public JTextField getTxtClube() {
		return txtClube;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public JButton getBtnApagarEatleta() {
		return btnApagarEatleta;
	}

	public JTextField getTxtEatleta() {
		return txtEatleta;
	}

	public DefaultListModel<Clube> getModelClubes() {
		return modelClubes;
	}

	public JButton getBtnTelaPrincipal() {
		return btnTelaPrincipal;
	}

	public DefaultListModel<EAtleta> getModelEatletas() {
		return modelEatletas;
	}

	public JList<Clube> getJlstClubes() {
		return jlstClubes;
	}

	public JButton getBtnAdicionarClube() {
		return btnAdicionarClube;
	}

	public JButton getBtnAdicionarEatleta() {
		return btnAdicionarEatleta;
	}
	
	public JList<EAtleta> getJlstEatleta() {
		return jlstEatleta;
	}
	
	public JButton getBtnApagarClube() {
		return btnApagarClube;
	}
}