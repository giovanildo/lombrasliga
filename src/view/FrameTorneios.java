package view;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;

import model.Clube;
import model.EAtleta;

public class FrameTorneios extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField txtNometorneio;
	private JTextField txtPorqueDoNome;
	private JTextField txtData;
	private JComboBox<Clube> txtClube;
	private JComboBox<EAtleta> txtEatleta;

		
	public FrameTorneios() {
		
		super("Torneio Lombra da Madrugada");
		getContentPane().setLayout(null);

		JList jlstTorneios = new JList();		
		jlstTorneios.setBounds(47, 73, 643, 114);
		getContentPane().add(jlstTorneios);

		JLabel lblTorneios = new JLabel("TORNEIOS");
		lblTorneios.setBounds(373, 35, 70, 15);
		getContentPane().add(lblTorneios);

		JButton btnNovoTorneio = new JButton("Novo Torneio");
		btnNovoTorneio.setBounds(57, 208, 643, 25);
		getContentPane().add(btnNovoTorneio);

		JLabel lblNomeDoTorneio = new JLabel("Nome do Torneio");
		lblNomeDoTorneio.setBounds(69, 261, 145, 36);
		getContentPane().add(lblNomeDoTorneio);

		JLabel lblPorqueEsseNome = new JLabel("Porque esse nome?");
		lblPorqueEsseNome.setBounds(79, 290, 221, 36);
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
		lblClube.setBounds(89, 369, 70, 15);
		getContentPane().add(lblClube);

		JLabel lblEatleta = new JLabel("EAtleta");
		lblEatleta.setBounds(69, 396, 70, 15);
		getContentPane().add(lblEatleta);

		txtClube = new JComboBox<Clube>();		
		txtClube.setBounds(232, 354, 114, 19);
		getContentPane().add(txtClube);

		txtEatleta = new JComboBox<EAtleta>();
		txtEatleta.setBounds(232, 385, 114, 19);
		getContentPane().add(txtEatleta);

		JList jlstEatletaClube = new JList<>();
		jlstEatletaClube.setBounds(418, 245, 241, 166);
		getContentPane().add(jlstEatletaClube);

		JList jlstClassif = new JList();
		jlstClassif.setBounds(63, 437, 627, 139);
		getContentPane().add(jlstClassif);

	}
	public JComboBox<Clube> getTxtClube() {
		return txtClube;
	}
	public JComboBox<EAtleta> getTxtEatleta() {
		return txtEatleta;
	}
}
