package exercise05b;

public class Test {
	
	private int i;
	
	public Test(int i){
		this.i = i;
	}
	public int getI() {
		return i;
	}
public void setI(int i) {
	this.i = i;
}
public static void main(String[] args)  {
//	Test a = new Test(1);
//	Test b = a;
//	System.out.println(a.getI());
//	System.out.println(b.getI());
//	
//	a.setI(3);
//	System.out.println(a.getI());
//	System.out.println(b.getI());
//	b.setI(5);
//	System.out.println(a.getI());
//	System.out.println(b.getI());
	CaseInsensitiveString cs1 = new CaseInsensitiveString("");
	CaseInsensitiveString cs2 = new CaseInsensitiveString("a");
	System.out.println(cs2.equals(cs1));
}
}

