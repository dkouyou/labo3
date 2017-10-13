import static org.junit.Assert.*;

import org.junit.Test;

public class LectureFichierTest {

	/**
	 * Vérifie le résultat d'une addition
	 */
	@Test
	public void calculAddition() {
		
		int resultat = LectureFichier.calcul("1 + 1");
		assertEquals(2,resultat);
		
	}
	/**
	 * Vérifie le résultat d'une soustraction
	 */
	@Test
	public void calculSoustraction() {
		
		int resultat = LectureFichier.calcul("1 - 1");
		assertEquals(0,resultat);
		
	}
	/**
	 * Vérifie le résultat d'une multiplication
	 */
	@Test
	public void calculMultiplication() {
		
		int resultat = LectureFichier.calcul("12 * 12");
		assertEquals(144,resultat);
		
	}
	/**
	 * Vérifie le résultat entier d'une division
	 */
	@Test
	public void calculDivision() {
		
		int resultat = LectureFichier.calcul("144 / 12");
		assertEquals(12,resultat);
		
	}
	/**
	 * Vérifie le résultat entier d'une division par 0
	 */
	@Test
	public void calculDivisionZero() {
		
		int resultat = LectureFichier.calcul("144 / 0");
		assertEquals(0,resultat);
		
	}
	/**
	 * Vérifie si le calcul ne se fait pas avec un mauvais opérateur
	 */
	@Test
	public void calculErreur() {
		
		int resultat = LectureFichier.calcul("144 t 12");
		assertEquals(0,resultat);
		
	}
	/**
	 * Vérifie si le calcul ne se fait pas avec une mauvaise variable
	 */
	@Test
	public void calculNonNombre() {
		
		int resultat = LectureFichier.calcul("a + 12");
		assertEquals(0,resultat);
		
	}
	/**
	 * Permet de vérifier si les valeurs trop grandes, trop petites et non numérique sont rejetées par le code
	 */
	@Test
	public void entreValeurGrand() { 
		
		int resultat = LectureFichier.entrerValeur();
		assertEquals(resultat,99);
		
		
	}
	


}
