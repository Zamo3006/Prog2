package exercise06;

public abstract class Partner {
	protected String name;
	protected String city;
	
	public Partner(String name, String city){
		this.city = city;
		this.name = name;
	}
	
	public String toString(){
		return name;
	}
}
