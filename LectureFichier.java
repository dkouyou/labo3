import java.io.*;
import java.util.Scanner;

public class LectureFichier {

	/**
	 * Programme qui fait la lecture de donn�es dans le fichierAvant. Ensuite, le
	 * programme fait le calcul (multiplication, soustraction ou addition) des deux
	 * nombres lus dans le fichier Ensuite, le programme �crit le r�sultat avec le
	 * calcul des deux nombres (par exemple: a + b = c) dans le fichierApres.txt
	 * 
	 */
	public static void main(String[] args) {

		int nombre = 0;
		// lecture du fichier de donn�es
		try {

			File monFichier = new File("fichierAvant.txt");
			FileReader lecture = new FileReader(monFichier);
			BufferedReader reader = new BufferedReader(lecture);

			String ligne = null;

			BufferedWriter bWriterCleaner = new BufferedWriter(new FileWriter("fichierApres.txt"));
			bWriterCleaner.write(" ");
			bWriterCleaner.close();

			// traitement de la ligne pour le calcul
			while ((ligne = reader.readLine()) != null && !ligne.isEmpty()) {

				/*
				 * ex�cution de la m�thode statique calcul qui lit une ligne du fichier et
				 * retourne le r�sultat du calcul dans la variable resultat
				 */
				System.out.println(ligne);

				int resultat = LectureFichier.calcul(ligne);
				ligne += " = " + resultat;
				FileWriter writer = null;
				BufferedWriter bWriter = null;

				// �criture des donn�es dans le fichier r�sultat.
				try {
					writer = new FileWriter("fichierApres.txt", true);
					bWriter = new BufferedWriter(writer);
					bWriter.write(ligne);
					bWriter.newLine();

				} catch (IOException ex) {
					ex.printStackTrace();
				} finally {
					bWriter.close();
					writer.close();
				}

			}

			reader.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		nombre = entrerValeur();
		System.out.println("\n" + nombre);

	}

	/**
	 * 
	 * @param ligne
	 *            Instrucion � calculer en provenance du fichier texte
	 *            fichierAvant.txt
	 * @return R�sultat du calcul re�ut en param�tre
	 */
	public static int calcul(String ligne) {
		String[] ligneChars = ligne.split(" ");
		int car1 = 0;
		int car2 = 0;
		try {

			car1 = Integer.parseInt(ligneChars[0]);
			car2 = Integer.parseInt(ligneChars[2]);

		} catch (Exception e) {

			System.out.println("\nVeuillez refaire votre s�lection, vous n'avez pas entr� un nombre entre 0 et 99!\n");

		}

		char operateur = ligneChars[1].charAt(0);
		double resultat = 0;

		switch (operateur) {

		case '+':
			resultat = car1 + car2;
			break;
		case '-':
			resultat = car1 - car2;
			break;
		case '*':
			resultat = car1 * car2;
			break;
		case '/':
			try {
				resultat = car1 / car2;
			} catch (Exception e) {
				System.out.println("Impossible de diviser par 0");
			}

			break;
		default:
			break;

		}

		return (int) resultat;
	}

	/**
	 * 
	 * @return Retourne le nombre que l'utilisation si celui-ci est compris entre 0
	 *         et 99 et n'est pas autre chose qu'un nombre.
	 */
	public static int entrerValeur() {

		Scanner kb = new Scanner(System.in);
		String entree = "";
		int nombre = 0;
		boolean ok = false;

		while (!ok) {
			System.out.print("Veuillez entrer un nombre entre 0 et 99 : ");
			entree = kb.nextLine();

			try {
				nombre = Integer.parseInt(entree);
				if (nombre < 0) {
					System.out.println("\nVeuillez refaire votre s�lection, ce nombre est inf�rieur � 0\n");
				} else if (nombre > 99) {
					System.out.println("\nVeuillez refaire votre s�lection, ce nombre est sup�rieur � 99\n");
				} else {
					ok = true;
				}

			} catch (Exception e) {
				System.out.println(
						"\nVeuillez refaire votre s�lection, vous n'avez pas entr� un nombre entre 0 et 99!\n");
			}

		}

		return nombre;

	}

}
