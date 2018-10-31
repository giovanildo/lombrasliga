package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import model.Clube;
import model.EAtleta;

import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrameCadastros extends JFrame {

	private static final long serialVersionUID = 1L;

	private JTextField txtClube;
	private JTextField txtEatleta;
	private DefaultListModel<Clube> modelClubes;
	private JList<Clube> jlstClubes;

	public FrameCadastros() {

		getContentPane().setLayout(null);

		JLabel lblCadastros = new JLabel("CADASTROS");
		lblCadastros.setBounds(398, 12, 103, 15);
		getContentPane().add(lblCadastros);

		JLabel lblClube = new JLabel("Clube");
		lblClube.setBounds(56, 70, 70, 15);
		getContentPane().add(lblClube);

		txtClube = new JTextField();
		txtClube.setText("");
		txtClube.setBounds(130, 68, 114, 19);
		getContentPane().add(txtClube);
		txtClube.setColumns(10);

		JLabel lblEatleta = new JLabel("EAtleta");
		lblEatleta.setBounds(515, 70, 70, 15);
		getContentPane().add(lblEatleta);

		txtEatleta = new JTextField();
		txtEatleta.setText("");
		txtEatleta.setBounds(612, 68, 114, 19);
		getContentPane().add(txtEatleta);
		txtEatleta.setColumns(10);

		modelClubes = new DefaultListModel<Clube>();
		jlstClubes = new JList<Clube>(modelClubes);

		jlstClubes.setBounds(56, 176, 206, 263);
		getContentPane().add(jlstClubes);

		final DefaultListModel<EAtleta> modelEatletas = new DefaultListModel<>();
		final JList<EAtleta> jlstEatleta = new JList<>(modelEatletas);
		jlstEatleta.setBounds(515, 176, 243, 263);
		getContentPane().add(jlstEatleta);

		JButton btnAdicionarClube = new JButton("Adicionar");
		btnAdicionarClube.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modelClubes.addElement(new Clube(txtClube.getText()));
				txtClube.setText("");
				//listaClubes();
			}
		});
		btnAdicionarClube.setBounds(66, 97, 178, 25);
		getContentPane().add(btnAdicionarClube);

		JButton btnAdicionarEatleta = new JButton("Adicionar");
		btnAdicionarEatleta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modelEatletas.addElement(new EAtleta(txtEatleta.getText()));
				txtEatleta.setText("");

			}
		});
		btnAdicionarEatleta.setBounds(515, 89, 221, 25);
		getContentPane().add(btnAdicionarEatleta);

		JButton btnApagarClube = new JButton("Apagar");
		btnApagarClube.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = jlstClubes.getSelectedIndex();
				modelClubes.remove(index);
			}
		});
		btnApagarClube.setBounds(56, 134, 178, 25);
		getContentPane().add(btnApagarClube);

		JButton btnApagarEatleta = new JButton("Apagar");
		btnApagarEatleta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modelEatletas.remove(jlstEatleta.getSelectedIndex());
			}
		});
		btnApagarEatleta.setBounds(515, 126, 221, 25);
		getContentPane().add(btnApagarEatleta);

		JButton btnTelaPrincipal = new JButton("Tela Principal");
		btnTelaPrincipal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new FrameTorneios();
			}
		});
		btnTelaPrincipal.setBounds(295, 465, 150, 25);
		getContentPane().add(btnTelaPrincipal);

	}
}
