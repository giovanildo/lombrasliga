package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
import model.Partida;

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
	private JList<EAtletaTorneio> jlstEatletaClube;
	private JButton btnRemoverJogador;
	private JButton btnAdicionarJogador;
	private JButton btnSalvarTorneio;
	
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

		listaTorneios = new ArrayList<Torneio>();
		listaEatletasTorneio = new ArrayList<EAtletaTorneio>();
		listaPartidas = new ArrayList<Partida>();

		JPanel panelTorneio = new JPanel();
		panelTorneio.setBackground(Color.LIGHT_GRAY);
		panelTorneio.setBounds(42, 214, 476, 186);
		getContentPane().add(panelTorneio);
		
		getContentPane().setLayout(null);
		modelTorneios = new DefaultListModel<Torneio>();
		final JList<Torneio> jlstTorneios = new JList<Torneio>(modelTorneios);

		jlstTorneios.setBounds(161, 11, 353, 134);
		getContentPane().add(jlstTorneios);
		panelTorneio.setLayout(null);

		btnNovoTorneio = new JButton("Novo Torneio");
		btnNovoTorneio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				habilitarPanelTorneio();
				modelEatletaTorneio.clear();
				//evita que adicione torneios com o mesmo nome
				for (int i = 0; i < jlstTorneios.getModel().getSize(); i++) {
					Torneio torneio = jlstTorneios.getModel().getElementAt(i);
					if (torneio.getNome().equals(txtNomeTorneio.getText())) {
						System.out.println("repetido");
						return;
					}
				}
			}
		});

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

		modelEatletaTorneio.addElement(
				new EAtletaTorneio(new EAtleta("Jogador"), new Torneio("Torneio", "Inicial"), new Clube("Clube")));

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
				btnAdicionarJogador.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						desabilitarCamposTorneio();
						//se for repetido EAtleta Torneio encerra o método
						for (int i = 0; i < jlstEatletaClube.getModel().getSize(); i++) {
							EAtletaTorneio eat = jlstEatletaClube.getModel().getElementAt(i);
							if (eat.getClube().getNome().equals(txtClube.getSelectedItem().toString())
									&& eat.geteAtleta().getNome().equals(txtEatleta.getSelectedItem().toString())
									&& eat.getTorneio().getNome().equals(txtNomeTorneio.getText())) {
								System.out.println("repetido");
								return;
							}
						}
						//se não for repetido adiciona tanto a JList como a lista EAtleta Torneio
						EAtletaTorneio eat = new EAtletaTorneio((EAtleta) getTxtEatleta().getSelectedItem(),
								new Torneio(getTxtNometorneio().getText(), getTxtPorqueDoNome().getText()),
								(Clube) getTxtClube().getSelectedItem());
						modelEatletaTorneio.addElement(eat);
						listaEatletasTorneio.add(eat);
					}
				});
				btnAdicionarJogador.setBounds(32, 45, 157, 23);
				panelTorneio.add(btnAdicionarJogador);
				
				

				

		btnEditarPartidas = new JButton("Editar Partidas");

		btnEditarPartidas.setBounds(42, 422, 145, 25);
		getContentPane().add(btnEditarPartidas);
		btnSalvarTorneio = new JButton("Salvar Torneio");
		btnSalvarTorneio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//evita que adicione torneios com o mesmo nome
				//salva edições do torneio 
				for (int i = 0; i < jlstTorneios.getModel().getSize();i++) {
					Torneio torneioDaVez = jlstTorneios.getModel().getElementAt(i);
					//verifica se o nome já existe o registro no JList
					if (torneioDaVez.getNome().equals(txtNomeTorneio.getText())) {
						//salva na JList dos torneios
						torneioDaVez.setPorqueDoNome(txtPorqueDoNome.getText());
						System.out.println("Esse registro existe, salvando os dados do objeto Torneio");
						//salva no lista Torneios
						for(Torneio torneioArray : listaTorneios) {
							if(torneioArray.getNome().equals(txtNomeTorneio.getText())) {
								torneioArray.setPorqueDoNome(txtPorqueDoNome.getText());
							}
						}
						return;
					}
				}
				
				System.out.println("novo torneio");
				
				//no caso de um novo torneio...
				
				Torneio torneio = new Torneio(getTxtNometorneio().getText(), getTxtPorqueDoNome().getText());

				//adiciona tanto na lista temporaria(jlist) como na lista permanente(arraylist)
				System.out.println("adicionando ao lista Torneios");
				listaTorneios.add(torneio);				
				
				modelTorneios.addElement(torneio);
				System.out.println("adicionando ao Jist Torneio");
				
				
			}
		});
		btnSalvarTorneio.setBounds(307, 180, 127, 23);
		getContentPane().add(btnSalvarTorneio);
		
		JButton btnDeletarTorneio = new JButton("Deletar Torneio");
		btnDeletarTorneio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int index = jlstTorneios.getSelectedIndex();
				Torneio torneio = jlstTorneios.getModel().getElementAt(index);
												
				modelEatletaTorneio.clear();
				listaTorneios.remove(index);
				modelTorneios.remove(index);
				
				//apagar todas as referencias do torneio na lista EAtletaTorneio
				
				for(int i = 0; i<listaEatletasTorneio.size();i++ ) {
					String torneioEAtleta = listaEatletasTorneio.get(i).getTorneio().getNome();
					if(torneioEAtleta.equals(torneio.getNome())) {
						System.out.println("apagando linha " + torneioEAtleta);
						listaEatletasTorneio.remove(i);
						
					}
				}
				
				System.out.println("deletado com sucesso " + index);
				
			}
		});
		btnDeletarTorneio.setBounds(551, 62, 127, 23);
		getContentPane().add(btnDeletarTorneio);
		
		JButton btnEditarTorneio = new JButton("Editar Torneio");
		btnEditarTorneio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
								 
				Torneio torneio = jlstTorneios.getModel().getElementAt(jlstTorneios.getSelectedIndex());
				txtNomeTorneio.setText(torneio.getNome());
				txtPorqueDoNome.setText(torneio.getPorqueDoNome());				
				habilitarPanelTorneio();
				//limpa JList EAtleta Torneio 
				modelEatletaTorneio.clear();
				
				//recuperar do arraylist e jogar no JList do EAtletaTorneio
				
				for(EAtletaTorneio eat : listaEatletasTorneio) {
					if(eat.getTorneio().getNome().equals(torneio.getNome())) {
						modelEatletaTorneio.addElement(eat);	
					}
					
				}
			}
		});
		btnEditarTorneio.setBounds(551, 96, 127, 23);
		getContentPane().add(btnEditarTorneio);
		
		desabilitarPanelTorneio();
	}
	
	protected void desabilitarCamposTorneio() {
		getTxtNometorneio().setEnabled(false);
		getTxtPorqueDoNome().setEnabled(false);		
	}

	public void desabilitarPanelTorneio() {
		
		btnSalvarTorneio.setEnabled(false);
		txtNomeTorneio.setEnabled(false);
		btnRemoverJogador.setEnabled(false);
		
		btnAdicionarJogador.setEnabled(false);
		txtClube.setEnabled(false);
		txtEatleta.setEnabled(false);
		jlstEatletaClube.setEnabled(false);
	}

	public void habilitarPanelTorneio() {
		txtNomeTorneio.setEnabled(true);
		txtPorqueDoNome.setEnabled(true);
		
		btnSalvarTorneio.setEnabled(true);
		txtNomeTorneio.setEnabled(true);
		txtPorqueDoNome.setEnabled(true);
		
		btnRemoverJogador.setEnabled(true);
		btnAdicionarJogador.setEnabled(true);
		txtClube.setEnabled(true);
		txtEatleta.setEnabled(true);
		jlstEatletaClube.setEnabled(true);
		
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
