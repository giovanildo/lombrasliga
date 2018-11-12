package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;

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

	private ArrayList<Torneio> listaTorneios;
	private ArrayList<EAtletaTorneio> listaEatletasTorneio;
	private ArrayList<Partida> listaPartidas;
	
	
	/**
	 * gera array de partidas
	 */
	public ArrayList<Partida> geraPartidas(ArrayList<EAtletaTorneio> listaEAtletaTorneio) {
		
		int totalClubes;
		int metadeClubes;
		
		// variaveis que serao base para gerar tabela
		totalClubes = listaEAtletaTorneio.size();
		metadeClubes = totalClubes / 2;
		ArrayList<Partida> listaPartidas = new ArrayList<Partida>();
		for (int turno = 0; turno <= 1; turno++) {
			for (int t = 0; t < (totalClubes - 1); t++) {// for das rodadas
				for (int m = 0; m < metadeClubes; m++) {// for dos jogos
					// Clube está de fora nessa rodada?
					if (listaEAtletaTorneio.get(m) == null) {
						continue;
					}
					// Teste para ajustar o mando de campo
					if (m % 2 == 1 || t % 2 == 1 && m == 0) {
						if (turno == 0) {
							listaPartidas
									.add(new Partida(new Anfitriao(listaEAtletaTorneio.get(totalClubes - m - 1), 0),
											new Visitante(listaEAtletaTorneio.get(m), 0)));
						} else {
							listaPartidas.add(new Partida(new Anfitriao(listaEAtletaTorneio.get(m), 0),
									new Visitante(listaEAtletaTorneio.get(totalClubes - m - 1), 0)));
						}
					} else {
						if (turno == 1) {
							listaPartidas.add(new Partida(new Anfitriao(listaEAtletaTorneio.get(m), 0),
									new Visitante(listaEAtletaTorneio.get(totalClubes - m - 1), 0)));

						} else {
							listaPartidas
									.add(new Partida(new Anfitriao(listaEAtletaTorneio.get(totalClubes - m - 1), 0),
											new Visitante(listaEAtletaTorneio.get(m), 0)));
						}
					}
				}
				// Gira os clubes no sentido horário, mantendo o primeiro no lugar
				EAtletaTorneio remove = listaEAtletaTorneio.remove(listaEAtletaTorneio.size() - 1);
				listaEAtletaTorneio.add(1, remove);				
			}
		}
		return listaPartidas;

	}

	
	
	
	public TorneioController() {
		super();
		
		listaTorneios = new ArrayList<Torneio>();
		listaEatletasTorneio = new ArrayList<EAtletaTorneio>();
		listaPartidas = new ArrayList<Partida>();
		
		this.frameCadastros = new FrameCadastros();
		this.frameTorneios = new FrameTorneios();
		this.framePartidas = new FramePartidas();
	}

	public FrameCadastros getFrameCadastros() {
		return frameCadastros;
	}

	public void setFrameCadastros(FrameCadastros frameCadastros) {
		this.frameCadastros = frameCadastros;
	}

	public FrameTorneios getFrameTorneios() {
		return frameTorneios;
	}

	public void setFrameTorneios(FrameTorneios frameTorneios) {
		this.frameTorneios = frameTorneios;
	}

	public FramePartidas getFramePartidas() {
		return framePartidas;
	}

	public void setFramePartidas(FramePartidas framePartidas) {
		this.framePartidas = framePartidas;
	}

	public void iniciarFrameTorneios() {
		getFrameTorneios().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getFrameTorneios().setSize(800, 600);
		getFrameTorneios().setVisible(true);
	}

	public void iniciarFramePartidas() {
		getFramePartidas().setVisible(true);
		getFramePartidas().setSize(800, 600);
		getFramePartidas().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void preencherComboBox() {
		getFrameTorneios().getTxtClube().addItem(new Clube("barcelona"));
		getFrameTorneios().getTxtClube().addItem(new Clube("real"));
		getFrameTorneios().getTxtEatleta().addItem(new EAtleta("fabiano"));
		getFrameTorneios().getTxtEatleta().addItem(new EAtleta("giovanildo"));
	}

	public void iniciar() {

		iniciarFrameTorneios();
		preencherComboBox();
		desabilitarPanelTorneio();
		
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
		
		
		getFrameTorneios().getBtnEditarPartidas().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				
				//pegar o arraylist o eatletaTorneio e jogar dentro da função gerar partidas
				
				
				
				
				//pegar o arraylist de partidas geradas e jogar dentro JList de partidas
				
				iniciarFramePartidas();
				
				
				
			}
		});
		
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
		
		getFrameTorneios().getBtnEditarPartidas().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//selecionar tudo que tiver o nome do torneio na array list do atleta torneio
				
				
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
		
	}
	protected void desabilitarCamposTorneio() {		                   
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
