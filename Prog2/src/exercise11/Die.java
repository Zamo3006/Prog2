package exercise11;

import java.util.Iterator;

public class Die extends AbstractDie{
	
	public static void main(String[] args) {
		test(new Die());
	}

	@Override
	public Iterator<Integer> iterator() {
		DieIterator dieIterator = new DieIterator(this);
		return dieIterator;
	}
	
	public int roll(){
		int dieRoll = (int) (Math.random()*6)+1;
		return dieRoll;
	}
}
