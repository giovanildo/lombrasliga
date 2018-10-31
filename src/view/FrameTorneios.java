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
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import java.awt.Panel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

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

		JPanel panelTorneio = new JPanel();
		panelTorneio.setBackground(Color.LIGHT_GRAY);
		panelTorneio.setBounds(42, 214, 476, 186);
		getContentPane().add(panelTorneio);
			
		getContentPane().setLayout(null);
		modelTorneios = new DefaultListModel<Torneio>();
		final JList<Torneio> jlstTorneios = new JList<Torneio>(modelTorneios);
		jlstTorneios.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
//				Torneio torneio = jlstTorneios.getModel().getElementAt(jlstTorneios.getSelectedIndex());
//				txtNomeTorneio.setText(torneio.getNome());
//				txtPorqueDoNome.setText(torneio.getPorqueDoNome());
//
//				for (int i = 0; i < modelEatletaTorneio.getSize(); i++) {
//					EAtletaTorneio eat = modelEatletaTorneio.getElementAt(i);
//					if (eat.getTorneio().getNome().equals(torneio.getNome())) {
//						System.out.println(eat.getClube());
//					}
//				}
				

			}
		});
		jlstTorneios.setBounds(38, 11, 353, 134);
		getContentPane().add(jlstTorneios);
		panelTorneio.setLayout(null);

		btnNovoTorneio = new JButton("Novo Torneio");
		btnNovoTorneio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtNomeTorneio.setEnabled(true);
				txtPorqueDoNome.setEnabled(true);

				modelEatletaTorneio.clear();
				//evita que adicione torneios com o mesmo nome
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

		btnNovoTorneio.setBounds(428, 11, 127, 25);
		getContentPane().add(btnNovoTorneio);

		JLabel lblNomeDoTorneio = new JLabel("Nome do Torneio");
		lblNomeDoTorneio.setBackground(Color.WHITE);
		lblNomeDoTorneio.setBounds(42, 185, 81, 14);
		getContentPane().add(lblNomeDoTorneio);

		modelTorneios.addElement(new Torneio("Escolha um dos torneios abaixo...", "Escolher"));

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

		// Clube[] clubes = new Clube[jlstClubes.getModel().getSize()];
		// for (int i = 0; i < jlstClubes.getModel().getSize(); i++) {
		// clubes[i] = jlstClubes.getModel().getElementAt(i);
		// }

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

		modelEatletaTorneio.addElement(
				new EAtletaTorneio(new EAtleta("Jogador"), new Torneio("Torneio", "Inicial"), new Clube("Clube")));

		JList<Classificacao> jlstClassif = new JList<>();
		jlstClassif.setBounds(42, 458, 746, 97);
		getContentPane().add(jlstClassif);
		
		JButton btnRemoverJogador = new JButton("Remover Jogador e Clube");
		btnRemoverJogador.setBounds(32, 11, 157, 23);
		panelTorneio.add(btnRemoverJogador);

		final JList <EAtletaTorneio> jlstEatletaClube = new JList(modelEatletaTorneio);
		jlstEatletaClube.setBounds(217, 11, 220, 155);
		panelTorneio.add(jlstEatletaClube);
		
				
		panelTorneio.add(jlstEatletaClube);
		
		
		
		
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
				btnAdicionarJogador.setBounds(32, 45, 157, 23);
				panelTorneio.add(btnAdicionarJogador);
				
				

				

		btnEditarPartidas = new JButton("Editar Partidas");

		btnEditarPartidas.setBounds(42, 422, 145, 25);
		getContentPane().add(btnEditarPartidas);
		
		JButton btnSalvarTorneio = new JButton("Salvar Torneio");
		btnSalvarTorneio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//verifica se já tem um torneio com o mesmo nome
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
				//adiciona tanto na lista temporaria(jlist) como na lista permanente(arraylist)
				listaTorneios.add(torneio);
				modelTorneios.addElement(torneio);

				listaEatletasTorneio.add(eat);
				modelEatletaTorneio.addElement(eat);
				
				System.out.println("registrou");
			}
		});
		btnSalvarTorneio.setBounds(428, 47, 127, 23);
		getContentPane().add(btnSalvarTorneio);
		
		JButton btnDeletarTorneio = new JButton("Deletar Torneio");
		btnDeletarTorneio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = jlstTorneios.getSelectedIndex();
				System.out.println("deletado com sucesso " + index);
				modelTorneios.remove(index);
			}
		});
		btnDeletarTorneio.setBounds(428, 81, 127, 23);
		getContentPane().add(btnDeletarTorneio);
		
		JButton btnEditarTorneio = new JButton("Editar Torneio");
		btnEditarTorneio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEditarTorneio.setBounds(428, 115, 127, 23);
		getContentPane().add(btnEditarTorneio);
		

		


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
