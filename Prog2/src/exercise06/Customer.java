package exercise06;
/**
 * @author Patrick Budig 5115455
 */
public class Customer extends Partner implements GoodsSink {

	private int count;
	
	public Customer(String name, String city) {
		super(name, city);
	}

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
		System.out.println("Anzahl Glühbirnen geliefert: " + count);
		count = 0;
	}
}
