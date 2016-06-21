package exercise11;

import java.util.Iterator;

public class DieIterator implements Iterator<Integer>{
	
	private Die die = null;
	
	 public DieIterator(Die die) {
		 this.die = die;
	 }

	@Override
	public boolean hasNext() {
		return true;
	}

	@Override
	public Integer next() {
		int next = die.roll();
		return next;
		
	}
	
	@Override
	public void remove(){
		throw new UnsupportedOperationException("Methode nicht sinnvoll.");
	}

}
