package exercise05b;

// Die nachfolgende Klasse repraesentiert einen String. 
// Durch das Ueberschreiben der equals-Methode soll
// erreicht werden, dass zwei Instanzen der Klasse
// dann als gleich betrachtet werden, wenn sie sich
// nur in der Gross-/Kleinschreibung des repraesentierten
// Strings unterscheiden.

public class CaseInsensitiveString 
{
	// Hier wird der repraesentierte String gespeichert
	private String s;
	
	// Konstruktor, dem der jeweilige String uebergeben wird
	public CaseInsensitiveString(String s)
	{
		if (s == null)
			throw new NullPointerException("null-Literal uebergeben!!!");
		this.s = s;
	}
	
	// Getter, um den String ggf. auslesen zu koennen
	public String asString()
	{
		return s;
	}

	public String toString(){
		return s;
	}
// ***************************************************************************
// Hier fehlt die Implementierung einer passenden equals-Methode

	public boolean equals2(CaseInsensitiveString s) {
		if (s == null) {
			return false;
		}

		char[] thisLower = this.asString().toLowerCase().toCharArray();
		char[] otherLower = s.asString().toLowerCase().toCharArray();

		if (thisLower.length != otherLower.length) {
			return false;
		}
		for (int i = 0; i < thisLower.length; i++) {
			if (thisLower[i] != otherLower[i]) {
				return false;
			}
		}

		return true;

	}

	/**
	 * @author Patrick Budig 5115455
	 */
	public boolean equals(CaseInsensitiveString s) {

		if (s == null) {
			return false;
		}

		return this.asString().equalsIgnoreCase(s.asString());
	}

// ***************************************************************************

		public static void main (String [] args)
		{
			//NullPointerEcxeption erwartet
			try
			{
			CaseInsensitiveString cs1 = new CaseInsensitiveString(null);
			CaseInsensitiveString cs2 = new CaseInsensitiveString("ABCDe");
			
			if(cs1.equals(cs2))
				System.out.println("Beide Objekte sind gleich!\nErstes Objekt:  " + cs1.toString() + "\nZweites Objekt: " + cs2.toString());
			else
				System.out.println("Die Objekte sind nicht gleich!\nErstes Objekt:  " + cs1.toString() + "\nZweites Objekt: " + cs2.toString());
			}//endtry
			catch(NullPointerException e_ref)
			{
				System.out.println("NullPointerException geworfen: " + e_ref.getMessage());
			}//endcatch
			
			//ungleiche Objekte
			CaseInsensitiveString cs1 = new CaseInsensitiveString("ABCd");
			CaseInsensitiveString cs2 = new CaseInsensitiveString("ABCde");
			
			if(cs1.equals(cs2))
				System.out.println("\nBeide Objekte sind gleich!\nErstes Objekt:  " + cs1.toString() + "\nZweites Objekt: " + cs2.toString());
			else
				System.out.println("\nDie Objekte sind nicht gleich!\nErstes Objekt:  " + cs1.toString() + "\nZweites Objekt: " + cs2.toString());

			//gleiche Objekte
			cs1 = new CaseInsensitiveString("abcde");
			cs2 = new CaseInsensitiveString("ABCDE");
			
			//reflexiv?
			System.out.println("\nReflexiv?");
			if(cs1.equals(cs1))
				System.out.println("\nBeide Objekte sind gleich!\nErstes Objekt:  " + cs1.toString() + "\nZweites Objekt: " + cs2.toString());
			else
				System.out.println("\nDie Objekte sind nicht gleich!\nErstes Objekt:  " + cs1.toString() + "\nZweites Objekt: " + cs2.toString());

			//symmetrisch?
			System.out.println("\nTest auf Symmetrie!");
			if(cs1.equals(cs2))
				System.out.println("\nBeide Objekte sind gleich!\nErstes Objekt:  " + cs1.toString() + "\nZweites Objekt: " + cs2.toString());
			else
				System.out.println("\nDie Objekte sind nicht gleich!\nErstes Objekt:  " + cs1.toString() + "\nZweites Objekt: " + cs2.toString());

			if(cs2.equals(cs1))
				System.out.println("\nBeide Objekte sind gleich!\nErstes Objekt:  " + cs1.toString() + "\nZweites Objekt: " + cs2.toString());
			else
				System.out.println("\nDie Objekte sind nicht gleich!\nErstes Objekt:  " + cs1.toString() + "\nZweites Objekt: " + cs2.toString());

			
			//Test auf null?
			System.out.println("\nTest auf null");
			
			if(cs1.equals(null))
				System.out.println("\nBeide Objekte sind gleich!\nErstes Objekt:  " + cs1.toString() + "\nZweites Objekt: " + cs2.toString());
			else
				System.out.println("\nDie Objekte sind nicht gleich!\nErstes Objekt:  " + cs1.toString() + "\nZweites Objekt: " + cs2.toString());
	

		}//endmethod main

}//endclass CaseInsenstiveString