package sample;

public class child extends ExampleClass{
	public void access_pv() {
		System.out.println("protected_var");
	}
public static void main(String args[]) {
	child c = new child();
	c.access_pv();
}
}
