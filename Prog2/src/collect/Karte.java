package collect;

public class Karte implements Comparable<Karte>{
	
	public Integer wert;
	public Kartenfarbe farbe;
	
	@Override
	public int compareTo(Karte o) {
		int returnint = farbe.compareTo(o.farbe);
		if(returnint == 0){
			returnint = wert.compareTo(o.wert);
		}
		return returnint;
	}

}
