package estudos;

import java.awt.*;

import javax.swing.*;

public class Calculadora extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0, btnMais, btnMenos, btnDeVezes,
			btnDivisao, btnPonto, btnIgual;
	private JTextField txtVisor;

	public Calculadora() {
		super("Calculadora");
		Container c = getContentPane();
		txtVisor = new JTextField();
		txtVisor.setFont(new Font("serif",Font.PLAIN, 26));
		c.add(BorderLayout.NORTH, txtVisor);
		Container c2 = new JPanel();

		btn1 = new JButton("1");
		btn2 = new JButton("2");
		btn3 = new JButton("3");
		btn4 = new JButton("4");
		btn5 = new JButton("5");
		btn6 = new JButton("6");
		btn7 = new JButton("7");
		btn8 = new JButton("8");
		btn9 = new JButton("9");
		btn0 = new JButton("0");
		btnMais = new JButton("+");
		btnMenos = new JButton("-");
		btnDeVezes = new JButton("*");
		btnDivisao = new JButton("/");
		btnPonto = new JButton(".");
		btnIgual = new JButton("=");
		

		c2.add(btn7);
		c2.add(btn8);
		c2.add(btn9);
		c2.add(btnDivisao);
		c2.add(btn4);
		c2.add(btn5);
		c2.add(btn6);
		c2.add(btnDeVezes);

		c2.add(btn1);
		c2.add(btn2);
		c2.add(btn3);
		c2.add(btnMenos);

		c2.add(btn0);
		c2.add(btnPonto);
		c2.add(btnIgual);
		c2.add(btnMais);

		c2.setLayout(new GridLayout(4, 4));
		
		c.add(BorderLayout.CENTER, c2);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(400, 400);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Calculadora();
	}

}
