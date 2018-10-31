package view;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;

import model.Classificacao;
import model.Clube;
import model.EAtleta;
import model.EAtletaTorneio;
import model.Partida;
import model.Torneio;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class FrameTorneios extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField txtNomeTorneio;
	private JTextField txtPorqueDoNome;
	private JComboBox<Clube> txtClube;
	private JComboBox<EAtleta> txtEatleta;
	private JButton btnEditarPartidas;
	private JButton btnNovoTorneio;
	private DefaultListModel<Torneio> modelTorneios;
	private DefaultListModel<EAtletaTorneio> modelEatletaTorneio;

	private ArrayList<Torneio> listaTorneios;
	private ArrayList<EAtletaTorneio> listaEatletasTorneio;
	private ArrayList<Partida> listaPartidas;

	public JTextField getTxtNometorneio() {
		return txtNomeTorneio;
	}

	public JTextField getTxtPorqueDoNome() {
		return txtPorqueDoNome;
	}

	public JButton getBtnEditarPartidas() {
		return btnEditarPartidas;
	}

	public void setBtnEditarPartidas(JButton btnEditarPartidas) {
		this.btnEditarPartidas = btnEditarPartidas;
	}

	public FrameTorneios() {

		super("Torneio Lombra da Madrugada");

		final ArrayList<Torneio> listaTorneios = new ArrayList<>();
		final ArrayList<EAtletaTorneio> listaEatletasTorneio = new ArrayList<>();
		final ArrayList<Partida> listaPartidas = new ArrayList<>();

		getContentPane().setLayout(null);
		modelTorneios = new DefaultListModel<Torneio>();
		final JList<Torneio> jlstTorneios = new JList<Torneio>(modelTorneios);
		jlstTorneios.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				Torneio torneio = jlstTorneios.getModel().getElementAt(jlstTorneios.getSelectedIndex());
				txtNomeTorneio.setText(torneio.getNome());
				txtPorqueDoNome.setText(torneio.getPorqueDoNome());

				for (int i = 0; i < modelEatletaTorneio.getSize(); i++) {
					EAtletaTorneio eat = modelEatletaTorneio.getElementAt(i);
					if (eat.getTorneio().getNome().equals(torneio.getNome())) {
						System.out.println(eat.getClube());
					}
				}

			}
		});
		jlstTorneios.setBounds(38, 61, 821, 134);
		getContentPane().add(jlstTorneios);

		JLabel lblTorneios = new JLabel("TORNEIOS");
		lblTorneios.setBounds(373, 35, 70, 15);
		getContentPane().add(lblTorneios);

		btnNovoTorneio = new JButton("Novo Torneio");
		btnNovoTorneio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtNomeTorneio.setEnabled(true);
				txtPorqueDoNome.setEnabled(true);

				modelEatletaTorneio.clear();

				for (int i = 0; i < jlstTorneios.getModel().getSize(); i++) {
					Torneio torneio = jlstTorneios.getModel().getElementAt(i);
					if (torneio.getNome().equals(txtNomeTorneio.getText())) {
						System.out.println("repetido");
						return;
					}

				}
				modelTorneios.addElement(new Torneio(getTxtNometorneio().getText(), getTxtPorqueDoNome().getText()));
			}
		});

		btnNovoTorneio.setBounds(57, 218, 127, 25);
		getContentPane().add(btnNovoTorneio);

		JLabel lblNomeDoTorneio = new JLabel("Nome do Torneio");
		lblNomeDoTorneio.setBounds(67, 242, 145, 36);
		getContentPane().add(lblNomeDoTorneio);

		modelTorneios.addElement(new Torneio("Escolha um dos torneios abaixo...", "Escolher"));

		JLabel lblPorqueEsseNome = new JLabel("Porque esse nome?");
		lblPorqueEsseNome.setBounds(77, 290, 221, 36);
		getContentPane().add(lblPorqueEsseNome);

		txtNomeTorneio = new JTextField();
		txtNomeTorneio.setText("NomeTorneio");
		txtNomeTorneio.setBounds(232, 259, 114, 19);
		getContentPane().add(txtNomeTorneio);
		txtNomeTorneio.setColumns(10);

		txtPorqueDoNome = new JTextField();
		txtPorqueDoNome.setText("Porque do nome");
		txtPorqueDoNome.setBounds(232, 293, 114, 19);
		getContentPane().add(txtPorqueDoNome);
		txtPorqueDoNome.setColumns(10);

		// Clube[] clubes = new Clube[jlstClubes.getModel().getSize()];
		// for (int i = 0; i < jlstClubes.getModel().getSize(); i++) {
		// clubes[i] = jlstClubes.getModel().getElementAt(i);
		// }

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

		modelEatletaTorneio = new DefaultListModel<EAtletaTorneio>();
		final JList<EAtletaTorneio> jlstEatletaClube = new JList<>(modelEatletaTorneio);

		jlstEatletaClube.setBounds(487, 343, 241, 128);
		// getContentPane().add(jlstEatletaClube);

		modelEatletaTorneio.addElement(
				new EAtletaTorneio(new EAtleta("Jogador"), new Torneio("Torneio", "Inicial"), new Clube("Clube")));

		JList<Classificacao> jlstClassif = new JList<>();
		jlstClassif.setBounds(68, 536, 627, 97);
		getContentPane().add(jlstClassif);

		JButton btnAdicionarJogador = new JButton("Adicionar Jogador e Clube");
		btnAdicionarJogador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getTxtNometorneio().setEnabled(false);
				getTxtPorqueDoNome().setEnabled(false);
				getTxtClube().getSelectedItem();

				// EAtletaTorneio[] clubes = new
				// EAtletaTorneio[jlstEatletaClube.getModel().getSize()];
				for (int i = 0; i < jlstEatletaClube.getModel().getSize(); i++) {
					EAtletaTorneio eat = jlstEatletaClube.getModel().getElementAt(i);
					if (eat.getClube().getNome().equals(txtClube.getSelectedItem().toString())
							&& eat.geteAtleta().equals(txtEatleta.getSelectedItem())
							&& eat.getTorneio().getNome().equals(txtNomeTorneio.getText())) {
						System.out.println("repetido");
						return;
					}
				}
				modelEatletaTorneio.addElement(new EAtletaTorneio((EAtleta) getTxtEatleta().getSelectedItem(),
						new Torneio(getTxtNometorneio().getText(), getTxtPorqueDoNome().getText()),
						(Clube) getTxtClube().getSelectedItem()));
			}
		});
		btnAdicionarJogador.setBounds(502, 301, 226, 25);
		getContentPane().add(btnAdicionarJogador);

		btnEditarPartidas = new JButton("Editar Partidas");

		btnEditarPartidas.setBounds(57, 500, 145, 25);
		getContentPane().add(btnEditarPartidas);

		JScrollPane scrollEatletaClube = new JScrollPane();
		scrollEatletaClube.setBounds(487, 343, 241, 128);
		scrollEatletaClube.setViewportView(jlstEatletaClube);
		getContentPane().add(scrollEatletaClube);

		JButton btnSalvarTorneio = new JButton("Salvar Torneio");
		btnSalvarTorneio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				for (Torneio daVez : listaTorneios) {
					if (daVez.getNome().equals(txtNomeTorneio.getText())) {
						System.out.println("repetido");
						return;
					}
				}

				Torneio torneio = new Torneio(getTxtNometorneio().getText(), getTxtPorqueDoNome().getText());
				EAtletaTorneio eat = new EAtletaTorneio((EAtleta) getTxtEatleta().getSelectedItem(),
						new Torneio(getTxtNometorneio().getText(), getTxtPorqueDoNome().getText()),
						(Clube) getTxtClube().getSelectedItem());
				listaTorneios.add(torneio);
				modelTorneios.addElement(torneio);

				listaEatletasTorneio.add(eat);
				modelEatletaTorneio.addElement(eat);
				System.out.println("registrou");
			}
		});
		btnSalvarTorneio.setBounds(194, 219, 121, 23);
		getContentPane().add(btnSalvarTorneio);

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
