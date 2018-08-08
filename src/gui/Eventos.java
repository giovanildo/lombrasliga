package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Eventos extends JFrame implements ActionListener {
	JButton botao;

	public Eventos() {
		super("Eventos");
		botao = new JButton("Clique Aqui");
		botao.addActionListener(this);
		getContentPane().add(botao);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(300, 300);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Eventos();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("clicou");
		botao.setText("foi Clicado");
	}

}
