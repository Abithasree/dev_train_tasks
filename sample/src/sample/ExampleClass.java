package sample;

public class ExampleClass {
	public ExampleClass() {
		System.out.println("constructor class created");
	}
	private int abi= 2004;
	void display() {
		System.out.println(abi);
	}
	
	void modifyVar(int var) {
		this.abi= var;
	}
	
	protected void protected_method() {
		String protected_var="Protected var";
		
	}
	public static void main(String args[]) {
		
		int integer_val=27;
		long long_val=23434342231L;
		double doub_val= 1.27;
		float float_val= 1.232434f;
		
		//single line comment
		/* multiline comment*/
		
//		System.out.println(abi); 
		
		ExampleClass obj = new ExampleClass();
		obj.display();
		obj.modifyVar(2006);
		obj.display();
		
		int i = 5;
		System.out.println("post increment: "+ i++);
		System.out.println("pre increment: "+ ++i);

		
	}

}
