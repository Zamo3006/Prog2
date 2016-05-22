package exercise06;
/**
 * @author Patrick Budig 5115455
 */
public class Stock implements GoodsSink, GoodsSource {

	private int count;

	@Override
	public boolean deliver(int count) {
		boolean deliverable = false;
		if (this.count >= count) {
			this.count -= count;
			deliverable = true;
		}
		return deliverable;
	}

	@Override
	public void receive(int count) {
		this.count += count;
	}

	public String toString() {
		String returnString = "Lager: Anzahl Glühbirnen: " + count;
		return returnString;
	}

}
