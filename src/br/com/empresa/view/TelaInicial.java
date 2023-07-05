package br.com.empresa.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.empresa.view.util.ButtonGradient;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.Window.Type;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaInicial extends JFrame{
	
	private JPanel contentPane;
	
	public TelaInicial() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setTitle("Iniciar");
		setSize(771, 708);
		setBounds(100, 100, 850, 600);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width /2, 
				dim.height / 2 - this.getSize().height / 2);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(TelaInicial.class.getResource("/br/com/empresa/view/image/logo.png")));
		lblNewLabel.setBounds(249, 95, 324, 304);
		getContentPane().add(lblNewLabel);
		
		ButtonGradient btnNewButton = new ButtonGradient();
		btnNewButton.setText("Entrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaConsultaBiblia tcb = new TelaConsultaBiblia();
				tcb.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(255, 51, 51));
		btnNewButton.setBounds(310, 392, 186, 67);
		getContentPane().add(btnNewButton);

		try {
			
			InputStream streamLogo = getClass()
					.getResourceAsStream("image/wepik-linear-monocolor-special-grace-church-logo-20230704211943mF3N.png");
			
			BufferedImage img = ImageIO.read(streamLogo);
			ImageIcon imageIcon = new ImageIcon(img);
			
			JLabel centerLabel = new JLabel(imageIcon);
			
		}catch (Exception e) {
			JOptionPane.showMessageDialog(
					null, "Ocorreu um erro ao abrir a tela.",
					"Erro!", JOptionPane.ERROR_MESSAGE);
		}
	}
}
