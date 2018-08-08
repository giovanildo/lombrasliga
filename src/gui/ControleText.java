package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ControleText extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	JButton btnOk, btnCancela;
	JLabel lblLogin, lblSenha;
	JTextField txtLogin;
	JPasswordField passwordSenha;
	ListenerOk listenerOk;
	ListenerCancela listenerCancela;
	public ControleText() {
		super("Textos e senhas");
		btnOk = new JButton("Ok");
		btnCancela = new JButton("Cancela");
		
		listenerOk = new ListenerOk();
		listenerCancela = new ListenerCancela();
		btnOk.addActionListener(listenerOk);
		btnCancela.addActionListener(listenerCancela);

		lblLogin = new JLabel("Login: ");
		txtLogin = new JTextField();
		lblSenha = new JLabel("Senha: ");
		passwordSenha = new JPasswordField();

		Container c = getContentPane();
		c.setLayout(new GridLayout(3, 2));
		c.add(lblLogin);
		c.add(txtLogin);
		c.add(lblSenha);
		c.add(passwordSenha);
		c.add(btnOk);
		c.add(btnCancela);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(300, 200);
		setVisible(true);

	}

	public static void main(String[] args) {
		new ControleText();
	}

	class ListenerOk implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (txtLogin.getText().equals("gio") && new String(passwordSenha.getPassword()).equals("senha")) {
				System.out.println(new String(passwordSenha.getPassword()));
				System.out.println("Se garante");
				txtLogin.setText("");
				passwordSenha.setText("");

			} else {
				System.out.println("erou, erou");
			}
		}

	}
	class ListenerCancela implements ActionListener {
		

		@Override
		public void actionPerformed(ActionEvent e) {

			System.out.println("botão cancela");
			txtLogin.setText("");
			passwordSenha.setText("");
		}
		
	}


}
