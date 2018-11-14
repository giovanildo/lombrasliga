package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.Anfitriao;
import model.Clube;
import model.EAtleta;
import model.EAtletaTorneio;
import model.Partida;
import model.Torneio;
import model.Visitante;
import view.FrameCadastros;
import view.FramePartidas;
import view.FrameTorneios;

public class TorneioController {

	/**
	 * view dos cadastros, clubes e jogadores
	 */
	private FrameCadastros frameCadastros;
	/**
	 * view dos torneios
	 */
	private FrameTorneios frameTorneios;
	/**
	 * view das partidas
	 */
	private FramePartidas framePartidas;
	/**
	 * Lista de torneios
	 */
	private ArrayList<Torneio> listaTorneios;
	/**
	 * Lista Jogadores e Clubes no Torneio
	 * 
	 */	
	private ArrayList<EAtletaTorneio> listaEatletasTorneio;
	/**
	 * Lista de Partidas geradas a partir da lista EatletasTorneio
	 */
	private ArrayList<Partida> listaPartidas;
	
	/**
	 * lista de Clubes
	 */
	private ArrayList<Clube> listaClubes;
	
	/**
	 * lista de EAtleta
	 */
	
	private ArrayList<EAtleta> listaEatleta;
	
	/**
	 * Inicializador de objetos 
	 */
	
	public TorneioController() {
		super();
		
		listaTorneios = new ArrayList<Torneio>();
		listaEatletasTorneio = new ArrayList<EAtletaTorneio>();
		listaPartidas = new ArrayList<Partida>();
		
		this.frameCadastros = new FrameCadastros();
		this.frameTorneios = new FrameTorneios();	
		this.framePartidas = new FramePartidas();	
		
	}

	
	public void confirmarPlacar(){
		int index = getFramePartidas().getJlstPartidas().getSelectedIndex();
		Partida partidaModel = getFramePartidas().getModelPartidas().getElementAt(index);
		
		int golsAnfitriao = Integer.parseInt(getFramePartidas().getTxtGolsAnfitriao().getText());
		int golsVisitante = Integer.parseInt(getFramePartidas().getTxtGolsVisitante().getText());				
		for(Partida partidaArray : listaPartidas) {
			if(partidaArray.equals(partidaModel)) {
				partidaArray.getAnfitriao().setGols(golsAnfitriao);
				partidaArray.getVisitante().setGols(golsVisitante);										
				
				System.out.println(partidaArray);
				
				partidaModel.getAnfitriao().setGols(golsAnfitriao);
				partidaModel.getVisitante().setGols(golsVisitante);
				
				System.out.println(partidaModel);
			}
		}
		getFramePartidas().getJlstPartidas().setModel(getFramePartidas().getModelPartidas());
	}
	
	/**
	 * gera array de partidas
	 */
	public void geraPartidas(ArrayList<EAtletaTorneio> listaEAtletaTorneioAtual) {
		// em caso de partidas clubes impares		
		if (listaEAtletaTorneioAtual.size() % 2 == 1) {
			listaEAtletaTorneioAtual.add(0, null);
		}
		
		// variaveis que serao base para gerar partidas
		int totalClubes = listaEAtletaTorneioAtual.size();
		int metadeClubes = totalClubes / 2;
		
		for (int turno = 0; turno <= 1; turno++) {
			for (int t = 0; t < (totalClubes - 1); t++) {// for das rodadas
				for (int m = 0; m < metadeClubes; m++) {// for dos jogos
					// Clube está de fora nessa rodada?
					if (listaEAtletaTorneioAtual.get(m) == null) {
						continue;
					}
					// Teste para ajustar o mando de campo
					if (m % 2 == 1 || t % 2 == 1 && m == 0) {
						if (turno == 0) {
							listaPartidas
									.add(new Partida(new Anfitriao(listaEAtletaTorneioAtual.get(totalClubes - m - 1), 0),
											new Visitante(listaEAtletaTorneioAtual.get(m), 0)));
						} else {
							listaPartidas.add(new Partida(new Anfitriao(listaEAtletaTorneioAtual.get(m), 0),
									new Visitante(listaEAtletaTorneioAtual.get(totalClubes - m - 1), 0)));
						}
					} else {
						if (turno == 1) {
							listaPartidas.add(new Partida(new Anfitriao(listaEAtletaTorneioAtual.get(m), 0),
									new Visitante(listaEAtletaTorneioAtual.get(totalClubes - m - 1), 0)));

						} else {
							listaPartidas
									.add(new Partida(new Anfitriao(listaEAtletaTorneioAtual.get(totalClubes - m - 1), 0),
											new Visitante(listaEAtletaTorneioAtual.get(m), 0)));
						}
					}
				}
				// Gira os clubes no sentido horário, mantendo o primeiro no lugar
				EAtletaTorneio remove = listaEAtletaTorneioAtual.remove(listaEAtletaTorneioAtual.size() - 1);
				listaEAtletaTorneioAtual.add(1, remove);				
			}
		}
		
	}
	
	public void iniciar() {
		iniciarFrameTorneios();
		preencherComboBox();
		desabilitarPanelTorneio();
		getFrameTorneios().getBtnNovoJogadorClube().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				iniciarFrameCadastros();
			}
		});
		
		//Editar EAtleta
		getFrameCadastros().getBtnEditarEatleta().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String eatleta = getFrameCadastros().getTxtEatleta().getText();
				getFrameCadastros().getJlstEatleta().getSelectedValue().setNome(eatleta);
				getFrameCadastros().getJlstEatleta().setModel(getFrameCadastros().getModelEatletas());
			}
		});
		
		getFrameCadastros().getJlstEatleta().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				getFrameCadastros().getTxtEatleta().requestFocus();
			}
		});

		
		//editar Clube
		getFrameCadastros().getBtnEditarClube().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String clube = getFrameCadastros().getTxtClube().getText();
				getFrameCadastros().getJlstClubes().getSelectedValue().setNome(clube);
				getFrameCadastros().getJlstClubes().setModel(getFrameCadastros().getModelClubes());
			}
		});
		
		getFrameCadastros().getJlstClubes().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				getFrameCadastros().getTxtClube().requestFocus();	
			}
		});
		
		getFrameTorneios().getBtnNovoTorneio().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				habilitarPanelTorneio();
				getFrameTorneios().getModelEatletaTorneio().clear();
				//evita que adicione torneios com o mesmo nome
				for (int i = 0; i < getFrameTorneios().getJlstTorneios().getModel().getSize(); i++) {
					Torneio torneio = getFrameTorneios().getJlstTorneios().getModel().getElementAt(i);
					if (torneio.getNome().equals(getFrameTorneios().getTxtNomeTorneio().getText())) {
						System.out.println("repetido");
						return;
					}
				}
			}
		});
		//remove EAtelta Torneio
		getFrameTorneios().getBtnRemoverJogador().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {				
				int index = getFrameTorneios().getJlstEatletaClube().getSelectedIndex();
				EAtletaTorneio eatDoModel = getFrameTorneios().getModelEatletaTorneio().getElementAt(index);
				//removendo do array
				for(int i =0;i<listaEatletasTorneio.size();i++) {
					EAtletaTorneio eatDoArray = listaEatletasTorneio.get(i);
					if(eatDoModel.equals(eatDoArray)) {
						listaEatletasTorneio.remove(i);
					}
				}				
				getFrameTorneios().getModelEatletaTorneio().remove(index);
			}
		});
		
		//adiciona EAtletaTorneio
		getFrameTorneios().getBtnAdicionarJogador().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				desabilitarCamposTorneio();
				//se for repetido EAtleta Torneio encerra o método
				for (int i = 0; i < getFrameTorneios().getJlstEatletaClube().getModel().getSize(); i++) {
					EAtletaTorneio eat = getFrameTorneios().getJlstEatletaClube().getModel().getElementAt(i);
					if (eat.getClube().getNome().equals(getFrameTorneios().getTxtClube().getSelectedItem().toString())
							&& eat.geteAtleta().getNome().equals(getFrameTorneios().getTxtEatleta().getSelectedItem().toString())
							&& eat.getTorneio().getNome().equals(getFrameTorneios().getTxtNomeTorneio().getText())) {
						System.out.println("repetido");
						return;
					}
				}
				//se não for repetido adiciona tanto a JList como a lista EAtleta Torneio
				EAtletaTorneio eat = new EAtletaTorneio((EAtleta) getFrameTorneios().getTxtEatleta().getSelectedItem(),
						new Torneio(getFrameTorneios().getTxtNomeTorneio().getText(), getFrameTorneios().getTxtPorqueDoNome().getText()),
						(Clube) getFrameTorneios().getTxtClube().getSelectedItem());
				getFrameTorneios().getModelEatletaTorneio().addElement(eat);
				listaEatletasTorneio.add(eat);
			}
		});
		//Salva Torneio
		getFrameTorneios().getBtnSalvarTorneio().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//evita que adicione torneios com o mesmo nome
				//salva edições do torneio 
				for (int i = 0; i < getFrameTorneios().getJlstTorneios().getModel().getSize();i++) {
					Torneio torneioDaVez = getFrameTorneios().getJlstTorneios().getModel().getElementAt(i);
					//verifica se o nome já existe o registro no JList
					if (torneioDaVez.getNome().equals(getFrameTorneios().getTxtNomeTorneio().getText())) {
						//salva na JList dos torneios
						torneioDaVez.setPorqueDoNome(getFrameTorneios().getTxtPorqueDoNome().getText());
						System.out.println("Esse registro existe, salvando os dados do objeto Torneio");
						//salva no lista Torneios
						for(Torneio torneioArray : listaTorneios) {
							if(torneioArray.getNome().equals(getFrameTorneios().getTxtNomeTorneio().getText())) {
								torneioArray.setPorqueDoNome(getFrameTorneios().getTxtPorqueDoNome().getText());
							}
						}
						return;
					}
				}
				System.out.println("novo torneio");
				//no caso de um novo torneio...
				Torneio torneio = new Torneio(getFrameTorneios().getTxtNomeTorneio().getText(), getFrameTorneios().getTxtPorqueDoNome().getText());
				//adiciona tanto na lista temporaria(jlist) como na lista permanente(arraylist)
				System.out.println("adicionando ao lista Torneios");
				listaTorneios.add(torneio);				
				getFrameTorneios().getModelTorneios().addElement(torneio);
				System.out.println("adicionando ao Jist Torneio");
			}
		});
		//Gera Partidas e Edita Partidas
		
		getFrameTorneios().getBtnEditarPartidas().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				

				getFramePartidas().getModelPartidas().clear();
				
				// saber se já existe o torneio já foi disputado ou não - comparar a lista das partidas com a lista dos eats

				ArrayList <EAtletaTorneio> listaTorneioAtual = new ArrayList<>();
				String torneioTxtField = getFrameTorneios().getTxtNomeTorneio().getText();
				
				for(EAtletaTorneio eat : listaEatletasTorneio ) {
					String torneioEat = eat.getTorneio().getNome();
					if(torneioEat.equals(torneioTxtField)) {
						listaTorneioAtual.add(eat);
					}
				}
				// caso não exista gera normalmente - código já montado
				if(!seTorneioFoiDisputado()) {
					geraPartidas(listaTorneioAtual);
				}

				// caso exista seleciona as partidas existentes e joga para o model list - fazer um for selecionando
		
				int metadeClubes = listaTorneioAtual.size();
				for(Partida partida : listaPartidas) {
					String torneioPartida = partida.getAnfitriao().geteAtletaTorneio().getTorneio().getNome();
					if(torneioPartida.equals(torneioTxtField)){
						getFramePartidas().getModelPartidas().addElement(partida);
					} 
				}
			
				
				iniciarFramePartidas();
			}
		});
		//Deleta Torneio
		getFrameTorneios().getBtnDeletarTorneio().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int index = getFrameTorneios().getJlstTorneios().getSelectedIndex();
				Torneio torneio = getFrameTorneios().getJlstTorneios().getModel().getElementAt(index);
												
				getFrameTorneios().getModelEatletaTorneio().clear();				
				getFrameTorneios().getModelTorneios().remove(index);
				
				listaTorneios.remove(index);
				
				//apagar todas as referencias do torneio na lista EAtletaTorneio
				
				for(int i = 0; i<listaEatletasTorneio.size();i++) {
					String torneioEAtleta = listaEatletasTorneio.get(i).getTorneio().getNome();
					if(torneioEAtleta.equals(torneio.getNome())) {
						System.out.println("apagando linha " + torneioEAtleta);
						listaEatletasTorneio.remove(i);
						
					}
				}
				System.out.println("deletado com sucesso " + index);
			}
		});
		
//		//Altera Placar
//		getFramePartidas().getBtnAlterarPlacar().addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				int index = getFramePartidas().getJlstPartidas().getSelectedIndex();
//				Partida partida = getFramePartidas().getJlstPartidas().getModel().getElementAt(index);
//				getFramePartidas().getLblAnfitriao().setText(partida.getAnfitriao().geteAtletaTorneio().getClube().getNome());
//				getFramePartidas().getLblVisitante().setText(partida.getVisitante().geteAtletaTorneio().getClube().getNome());
//			}
//		});
		
		getFramePartidas().getJlstPartidas().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				getFramePartidas().getTxtGolsAnfitriao().requestFocus();
				getFramePartidas().getTxtGolsAnfitriao().setText("0");
				getFramePartidas().getTxtGolsVisitante().setText("0");
			}
		});
		
		getFramePartidas().getTxtGolsVisitante().addKeyListener(new KeyAdapter() {
			public void keyPressed(java.awt.event.KeyEvent e) {
				if (e.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
					confirmarPlacar();				
				}
			}

		});

		getFramePartidas().getBtnConfirmar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				confirmarPlacar();
			}
		});
		
		getFrameTorneios().getBtnEditarTorneio().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
								 
				Torneio torneio = getFrameTorneios().getJlstTorneios().getModel().getElementAt(getFrameTorneios().getJlstTorneios().getSelectedIndex());
				
				getFrameTorneios().getTxtNomeTorneio().setText(torneio.getNome());
				getFrameTorneios().getTxtPorqueDoNome().setText(torneio.getPorqueDoNome());				
				
				habilitarPanelTorneio();
				//limpa JList EAtleta Torneio 
				getFrameTorneios().getModelEatletaTorneio().clear();
				
				//recuperar do arraylist e jogar no JList do EAtletaTorneio
				
				for(EAtletaTorneio eat : listaEatletasTorneio) {
					if(eat.getTorneio().getNome().equals(torneio.getNome())) {
						getFrameTorneios().getModelEatletaTorneio().addElement(eat);	
					}
				}
			}
		});
		
		//frame Cadastros
		getFrameCadastros().getBtnAdicionarClube().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Clube clube = new Clube(getFrameCadastros().getTxtClube().getText());
				listaClubes.add(clube);
				getFrameCadastros().getModelClubes().addElement(clube);
				getFrameCadastros().getTxtClube().setText("");
			}
		});
		
		getFrameCadastros().getBtnAdicionarEatleta().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EAtleta eAtleta = new EAtleta(getFrameCadastros().getTxtEatleta().getText());
				listaEatleta.add(eAtleta);
				getFrameCadastros().getModelEatletas().addElement(eAtleta);
				getFrameCadastros().getTxtEatleta().setText("");

			}
		});

		
		getFrameCadastros().getBtnApagarClube().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = getFrameCadastros().getJlstClubes().getSelectedIndex();
				getFrameCadastros().getModelClubes().remove(index);
				
			}
		});
		

		
		getFrameCadastros().getBtnApagarEatleta().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getFrameCadastros().getModelEatletas().remove(getFrameCadastros().getJlstEatleta().getSelectedIndex());
			}
		});
		

		
		getFrameCadastros().getBtnTelaPrincipal().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				iniciarFrameTorneios();
			}
		});

		
		
	}

	private boolean seTorneioFoiDisputado() {
		boolean foiDisputado = false;
		for(Partida partida : listaPartidas) {
			String torneioTxtField = getFrameTorneios().getTxtNomeTorneio().getText();
			String torneioPartida = partida.getAnfitriao().geteAtletaTorneio().getTorneio().getNome();
			if(torneioPartida.equals(torneioTxtField)){
				foiDisputado = true;
				break;
			} 
		}
		return foiDisputado;
	}


	public FrameCadastros getFrameCadastros() {
		return frameCadastros;
	}

	
	public FrameTorneios getFrameTorneios() {
		return frameTorneios;
	}

	public FramePartidas getFramePartidas() {
		return framePartidas;
	}

	public void iniciarFrameTorneios() {
		getFrameTorneios().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getFrameTorneios().setSize(800, 600);
		getFrameTorneios().setVisible(true);
	}
	public void iniciarFrameCadastros() {
		getFrameCadastros().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getFrameCadastros().setSize(800, 600);
		getFrameCadastros().setVisible(true);
	}

	public void iniciarFramePartidas() {
		getFramePartidas().setVisible(true);
		getFramePartidas().setSize(800, 600);
		getFramePartidas().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void preencherComboBox() {
		getFrameTorneios().getTxtClube().addItem(new Clube("barcelona"));
		getFrameTorneios().getTxtClube().addItem(new Clube("real"));
		getFrameTorneios().getTxtClube().addItem(new Clube("atletico de madrid"));
		getFrameTorneios().getTxtClube().addItem(new Clube("Chelsea"));
		getFrameTorneios().getTxtClube().addItem(new Clube("Juventus"));		
		getFrameTorneios().getTxtEatleta().addItem(new EAtleta("giovanildo"));
		getFrameTorneios().getTxtEatleta().addItem(new EAtleta("fabiano"));
		getFrameTorneios().getTxtEatleta().addItem(new EAtleta("zaldir"));
		getFrameTorneios().getTxtEatleta().addItem(new EAtleta("genilson"));
		getFrameTorneios().getTxtEatleta().addItem(new EAtleta("Nen"));
	}


	public void desabilitarCamposTorneio() {		                   
		getFrameTorneios().getTxtNomeTorneio().setEnabled(false);
		getFrameTorneios().getTxtPorqueDoNome().setEnabled(false);		
	}

	public void desabilitarPanelTorneio() {
		getFrameTorneios().getBtnSalvarTorneio().setEnabled(false);
		getFrameTorneios().getTxtNomeTorneio().setEnabled(false);
		getFrameTorneios().getBtnRemoverJogador().setEnabled(false);
		
		getFrameTorneios().getBtnAdicionarJogador().setEnabled(false);
		getFrameTorneios().getTxtClube().setEnabled(false);
		getFrameTorneios().getTxtEatleta().setEnabled(false);
		getFrameTorneios().getJlstEatletaClube().setEnabled(false);
	}

	public void habilitarPanelTorneio() {
		getFrameTorneios().getTxtNomeTorneio().setEnabled(true);
		getFrameTorneios().getTxtPorqueDoNome().setEnabled(true);
		
		getFrameTorneios().getBtnSalvarTorneio().setEnabled(true);
		getFrameTorneios().getTxtNomeTorneio().setEnabled(true);
		getFrameTorneios().getTxtPorqueDoNome().setEnabled(true);
		
		getFrameTorneios().getBtnRemoverJogador().setEnabled(true);
		getFrameTorneios().getBtnAdicionarJogador().setEnabled(true);
		getFrameTorneios().getTxtClube().setEnabled(true);
		getFrameTorneios().getTxtEatleta().setEnabled(true);
		getFrameTorneios().getJlstEatletaClube().setEnabled(true);
		
	}	
}
