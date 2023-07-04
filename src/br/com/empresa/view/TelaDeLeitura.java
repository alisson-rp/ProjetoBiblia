package br.com.empresa.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

import br.com.empresa.exception.BOException;
import br.com.empresa.view.util.ButtonGradient;
import br.com.empresa.view.util.TextFormatter;
import br.com.empresa.vo.BibliaVO;

public class TelaDeLeitura extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TelaDeLeitura(List<BibliaVO> aux) throws BOException {
		JFrame frame = new JFrame("Modo Leitura");
		frame.setSize(600, 493);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 586, 411);
		frame.getContentPane().add(scrollPane);

		JTextPane textPane = new JTextPane();
		textPane.setFont(new Font("Tahoma", Font.BOLD, 10));
		textPane.setEditable(false);
		textPane.setContentType("text/html");
		scrollPane.setViewportView(textPane);

		ButtonGradient btnFechar = new ButtonGradient();
		btnFechar.setText("fechar");
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		btnFechar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnFechar.setForeground(new Color(255, 255, 255));
		btnFechar.setBackground(new Color(255, 51, 51));
		btnFechar.setBounds(473, 421, 85, 25);
		frame.getContentPane().add(btnFechar);

		frame.setVisible(true);

		StringBuffer sb = new StringBuffer();
		sb.append(aux.get(0).getLivroVO().getEscritor() + " - " + aux.get(0).getCapitulo());

		StringBuffer sb2 = new StringBuffer();
		for (int i = 0; i < aux.size(); i++) {
			sb2.append(" " + aux.get(i).getVersiculo() + " - " + aux.get(i).getTexto());
		}

		TextFormatter textof = new TextFormatter(sb.toString(), sb2.toString());
		String txt = textof.format();

		textPane.setText(txt);
		frame.revalidate();

	}
}
