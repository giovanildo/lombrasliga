package view;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;

import model.Clube;
import model.EAtleta;
import model.EAtletaTorneio;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrameTorneios extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField txtNometorneio;
	private JTextField txtPorqueDoNome;
	private JTextField txtData;
	private JComboBox<Clube> txtClube;
	private JComboBox<EAtleta> txtEatleta;
	private JButton btnEditarPartidas;
	private JButton btnNovoTorneio;
	
	
	
	public JTextField getTxtNometorneio() {
		return txtNometorneio;
	}
	public JTextField getTxtPorqueDoNome() {
		return txtPorqueDoNome;
	}
	public JTextField getTxtData() {
		return txtData;
	}
	public JButton getBtnEditarPartidas() {
		return btnEditarPartidas;
	}
	public void setBtnEditarPartidas(JButton btnEditarPartidas) {
		this.btnEditarPartidas = btnEditarPartidas;
	}
	public FrameTorneios() {
		
		super("Torneio Lombra da Madrugada");
		getContentPane().setLayout(null);

		JList jlstTorneios = new JList();		
		jlstTorneios.setBounds(47, 73, 758, 65);
		getContentPane().add(jlstTorneios);

		JLabel lblTorneios = new JLabel("TORNEIOS");
		lblTorneios.setBounds(373, 35, 70, 15);
		getContentPane().add(lblTorneios);

		btnNovoTorneio = new JButton("Novo Torneio");

		btnNovoTorneio.setBounds(57, 150, 127, 25);
		getContentPane().add(btnNovoTorneio);

		JLabel lblNomeDoTorneio = new JLabel("Nome do Torneio");
		lblNomeDoTorneio.setBounds(67, 242, 145, 36);
		getContentPane().add(lblNomeDoTorneio);

		JLabel lblPorqueEsseNome = new JLabel("Porque esse nome?");
		lblPorqueEsseNome.setBounds(77, 290, 221, 36);
		getContentPane().add(lblPorqueEsseNome);

		JLabel lblData = new JLabel("Data:");
		lblData.setBounds(79, 321, 83, 36);
		getContentPane().add(lblData);

		txtNometorneio = new JTextField();
		txtNometorneio.setText("NomeTorneio");
		txtNometorneio.setBounds(232, 259, 114, 19);
		getContentPane().add(txtNometorneio);
		txtNometorneio.setColumns(10);

		txtPorqueDoNome = new JTextField();
		txtPorqueDoNome.setText("Porque do nome");
		txtPorqueDoNome.setBounds(232, 293, 114, 19);
		getContentPane().add(txtPorqueDoNome);
		txtPorqueDoNome.setColumns(10);

		txtData = new JTextField();
		txtData.setText("Data");
		txtData.setBounds(232, 330, 114, 19);
		getContentPane().add(txtData);
		txtData.setColumns(10);

		
//			Clube[] clubes = new Clube[jlstClubes.getModel().getSize()];
//			for (int i = 0; i < jlstClubes.getModel().getSize(); i++) {
//				clubes[i] = jlstClubes.getModel().getElementAt(i);
//			}
		
		
		
		JLabel lblClube = new JLabel("Clube");
		lblClube.setBounds(513, 242, 70, 15);
		getContentPane().add(lblClube);

		JLabel lblEatleta = new JLabel("EAtleta");
		lblEatleta.setBounds(502, 273, 70, 15);
		getContentPane().add(lblEatleta);

		txtClube = new JComboBox<Clube>();		
		txtClube.setBounds(581, 240, 114, 19);
		getContentPane().add(txtClube);

		txtEatleta = new JComboBox<EAtleta>();
		txtEatleta.setBounds(581, 271, 114, 19);
		getContentPane().add(txtEatleta);

		JList<EAtletaTorneio> jlstEatletaClube = new JList<>();
		jlstEatletaClube.setBounds(487, 343, 241, 128);
		getContentPane().add(jlstEatletaClube);

		JList jlstClassif = new JList();
		jlstClassif.setBounds(68, 512, 627, 97);
		getContentPane().add(jlstClassif);
		
		JButton btnAdicionarJogador = new JButton("Adicionar Jogador e Clube");
		btnAdicionarJogador.setBounds(502, 301, 226, 25);
		getContentPane().add(btnAdicionarJogador);
		
		btnEditarPartidas = new JButton("Editar Partidas");
		
		btnEditarPartidas.setBounds(67, 460, 145, 25);
		getContentPane().add(btnEditarPartidas);

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
}
