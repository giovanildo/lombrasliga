package view;

import javax.swing.AbstractListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;

public class FrameTorneios extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField txtNometorneio;
	private JTextField txtPorqueDoNome;
	private JTextField txtData;
	private JTextField txtClube;
	private JTextField txtEatleta;

	public FrameTorneios() {

		super("Torneio Lombra da Madrugada");
		getContentPane().setLayout(null);

		JList list = new JList();
		list.setModel(new AbstractListModel() {
			String[] values = new String[] { "Palmeiras", "São Paulo", "Santos", "Ceará", "Fortaleza" };

			public int getSize() {
				return values.length;
			}

			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setBounds(47, 73, 643, 114);
		getContentPane().add(list);

		JLabel lblTorneios = new JLabel("TORNEIOS");
		lblTorneios.setBounds(373, 35, 70, 15);
		getContentPane().add(lblTorneios);

		JButton btnNewButton = new JButton("Novo Torneio");
		btnNewButton.setBounds(57, 208, 643, 25);
		getContentPane().add(btnNewButton);

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

		JLabel lblClube = new JLabel("Clube");
		lblClube.setBounds(89, 369, 70, 15);
		getContentPane().add(lblClube);

		JLabel lblEatleta = new JLabel("EAtleta");
		lblEatleta.setBounds(69, 396, 70, 15);
		getContentPane().add(lblEatleta);

		txtClube = new JTextField();
		txtClube.setText("Clube");
		txtClube.setBounds(232, 354, 114, 19);
		getContentPane().add(txtClube);
		txtClube.setColumns(10);

		txtEatleta = new JTextField();
		txtEatleta.setText("EAtleta");
		txtEatleta.setBounds(232, 385, 114, 19);
		getContentPane().add(txtEatleta);
		txtEatleta.setColumns(10);

		JList list_1 = new JList();
		list_1.setModel(new AbstractListModel() {
			String[] values = new String[] { "çljsaçlkajsdfç", "çalskjdfçlasjkdlçkjasdf", "aslçfjkasçldkjsadlçfkj" };

			public int getSize() {
				return values.length;
			}

			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list_1.setBounds(505, 277, 1, 1);
		getContentPane().add(list_1);

		JList list_2 = new JList();
		list_2.setModel(new AbstractListModel() {
			String[] values = new String[] { "çjasdfçljasdçfljk", "sadlçfkjsdflçakjasçdlkf", "asçldfjçlasdfjfd" };

			public int getSize() {
				return values.length;
			}

			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list_2.setBounds(418, 245, 241, 166);
		getContentPane().add(list_2);

		JList list_3 = new JList();
		list_3.setBounds(63, 437, 627, 139);
		getContentPane().add(list_3);

	}
}
