package br.biblia;

public class Principal {

	// Variável global da classe principal
	private SplashScreen splashScreen;

	public Principal() {
		iniciaSplash();
	}

	public static void main(String[] args) {

		new Principal();

	}

	private void iniciaSplash() {
		new Thread() {
			public void run() {
				splashScreen = new SplashScreen(4000);
				splashScreen.showSplashAndExit();
			}

		}.start();
	}

}
