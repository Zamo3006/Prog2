package exercise06;

public class Customer extends Partner implements GoodsSink {

	public Customer(String name, String city) {
		super(name, city);
	}

	private int count;

	@Override
	public void receive(int count) {
		this.count += count;

	}

	@Override
	public String toString() {
		String returnString = "Kunde: " + super.toString();
		return returnString;
	}

	public void sendInvoice() {
		System.out.println(toString());
		System.out.println("Anzahl Glühbirnen: " + count);
		count = 0;
	}
}
