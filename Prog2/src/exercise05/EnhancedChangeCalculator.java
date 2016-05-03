package exercise05;

// Ihre Aufgabe ist es, in der nachfolgenden Klasse die geerbte
// Methode getChange zu ueberschreiben. Natuerlich muss der
// Softwarevertrag der Oberklasse eingehalten werden. Ihre
// Spezialisierung soll aber darueber hinaus sicherstellen,
// dass die Anzahl der ausgegeben Muenzen minimal ist.

public class EnhancedChangeCalculator extends SimpleChangeCalculator {

	/**
	 * @author Patrick Budig 5115455
	 */
	
	@Override
	public int[] getChange(int euros, int cent) {
		int[] returnCoins = new int[8];

		int _2Euro = euros / 2;
		int _1Euro = euros % 2;

		int _50Cent = cent / 50;
		cent = cent % 50;
		int _20Cent = cent / 20;
		cent = cent % 20;
		int _10Cent = cent / 10;
		cent = cent % 10;
		int _5Cent = cent / 5;
		cent = cent % 5;
		int _2Cent = cent / 2;
		cent = cent % 2;
		int _1Cent = cent;

		returnCoins[7] = _2Euro;
		returnCoins[6] = _1Euro;
		returnCoins[5] = _50Cent;
		returnCoins[4] = _20Cent;
		returnCoins[3] = _10Cent;
		returnCoins[2] = _5Cent;
		returnCoins[1] = _2Cent;
		returnCoins[0] = _1Cent;

		return returnCoins;

	}

	// Die nachfolgende main-Methode kann genutzt werden, um das
	// Ergebnis zu ueberpruefen.
	public static void main(String[] args) {

		EnhancedChangeCalculator calc = new EnhancedChangeCalculator();

		calc.test(calc, 1, 70);
		calc.test(calc, 3, 88);
		calc.test(calc, 2, 90);
		calc.test(calc, 5, 7);
		calc.test(calc, 10, 99);

	}// endmethod main

	public void test(EnhancedChangeCalculator calc, int euro, int cent) {
		int j = 0;
		System.out.println("\nZuerst ein simpler Fall: Es sollen " + euro + " Euro und " + cent
				+ " Cent Wechselgeld zurückgegeben werden:");
		int[] result = calc.getChange(euro, cent);

		System.out.println("\nDer Automat gibt folgende Muenzen zurueck:");
		j = 0;
		for (int i = 0; i < Coin.availableCoins.length; i++) {
			System.out.println(result[i] + " x " + Coin.availableCoins[i].getName());
			j += result[i];
		} // endfor
		System.out.println("Anzahl der Münzen: " + j);
	}

}// endclass EnhancedChangeCalculator
