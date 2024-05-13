package task1;
import java.io.File;  
import java.io.FileWriter;
import java.util.Scanner;

public class RW {
	public static void main(String[] args) {
	    try {
	        File o = new File("abi.txt");
	        FileWriter w = new FileWriter("abi.txt");
	        w.write("Writing to file successfully :)");
	        w.close(); // had error before here. Close FileWriter after writing
	        
	        Scanner r = new Scanner(o);
	        while (r.hasNextLine()) {
	            String data = r.nextLine();
	            System.out.println(data);
	        }
	        r.close(); 
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

}
