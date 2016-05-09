package exercise06;

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
		String returnString = "Anzahl Glühbirnen im Lager: " + count;
		return returnString;
	}

}
