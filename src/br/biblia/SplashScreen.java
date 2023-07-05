package br.biblia;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.io.InputStream;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JWindow;

import br.com.empresa.view.TelaInicial;

public class SplashScreen extends JWindow {

	private int duration;

	public SplashScreen(int d) {
		duration = d;
	}

	// Este é um método simples para mostrar uma tela de apresentção

	// no centro da tela durante a quantidade de tempo passada no construtor

	public void showSplash() {
		try {
			JPanel content = (JPanel) getContentPane();
			content.setBackground(Color.white);

			// Configura a posição e o tamanho da janela
			int width = 400;
			int height = 700;
			Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
			int x = (screen.width - width) / 2;
			int y = (screen.height - height) / 2;
			setBounds(x, y, width, height);

			// Constrói o splash screen
			//InputStream streamSplash = getClass().getResourceAsStream("lazyload.gif");
			URL urlToImage = getClass().getResource("XOsX.gif");
			//ImageIcon imagemSplash = new ImageIcon(ImageIO.read(streamSplash));
			ImageIcon imagemSplash = new ImageIcon(urlToImage);

			JLabel label = new JLabel(imagemSplash);
			//JLabel label = new JLabel(new ImageIcon("/usr/local/workspace/Teste/src/lazyload.gif"));
			JLabel copyrt = new JLabel("Copyright 2006, DevMedia", JLabel.CENTER);
			copyrt.setFont(new Font("Sans-Serif", Font.BOLD, 12));
			content.add(label, BorderLayout.CENTER);
			//content.add(copyrt, BorderLayout.SOUTH);

			// Torna visível
			setVisible(true);

			// Espera ate que os recursos estejam carregados
			try {
				Thread.sleep(duration);
			} catch (Exception e) {
				e.printStackTrace();
			}
			setVisible(false);
			TelaInicial frame = new TelaInicial();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void showSplashAndExit() {
		showSplash();
	}

}