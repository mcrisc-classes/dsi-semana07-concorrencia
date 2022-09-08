package edu.ifsp.dsi.exemplos;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.math.BigInteger;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BloqueioGUI {
	private JFrame frame;
	private JLabel labelStatus;
	private JTextField textNome;

	
	private void buildGUI() {
		JPanel panel = new JPanel(new FlowLayout());

		JLabel label = new JLabel("Nome: ");
		panel.add(label);
		
		textNome = new JTextField(20);
		panel.add(textNome);
		
		JButton botao = new JButton("Buscar");
		botao.addActionListener(this::onClick);
		panel.add(botao);
		
		labelStatus = new JLabel("Tente digitar seu nome após clicar no botão.");
		Font font = labelStatus.getFont().deriveFont(Font.PLAIN); // tirando o negrito		
		labelStatus.setFont(font);
		
		frame = new JFrame("Exemplo");
		frame.setLayout(new BorderLayout());
		frame.add(panel, BorderLayout.CENTER);
		frame.add(labelStatus, BorderLayout.SOUTH);
		
		// frame.pack();
		frame.setSize(400, 100);
		frame.setLocationRelativeTo(null);		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	/**
	 * Simula uma busca por dados.
	 * 
	 * A chamada a este método bloqueia a execução do programa por 5 segundos.
	 */
	private String buscar(String nome) {
		/* Simulando uma operação de 5s */
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			JOptionPane.showMessageDialog(frame, e);
			e.printStackTrace();
		}
		
		String chave = new BigInteger(128, new Random()).toString(16);
		return chave;
	}
	
	private void onClick(ActionEvent e) {
		String nome = textNome.getText();
		labelStatus.setText("Buscando...");
		String res = buscar(nome);
		labelStatus.setText("Encontrado: " + res);
	}
	
	public static void main(String[] args) {
		new BloqueioGUI().buildGUI();
	}

}
