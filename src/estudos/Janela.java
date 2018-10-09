package gui;

import javax.swing.*;

public class Janela extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static void main(String[] args) {
		new Janela();

	}
	public Janela() {
		super("Minha Janela");
		
		JButton botao = new JButton("Clique");

		getContentPane().add(botao);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 300);
		setVisible(true);
	}
}
