package sample;
import java.util.*;
public class ExClass2 {
	public static void main (String args[]) {

		int sibling1=10;
		int sibling2=8;
		
		if (sibling1> sibling2) {
			System.out.println("sibling 1 is elder");
		}
		else {
			System.out.println("Sibling2 is elder");
		}

		
		String result= (sibling1==sibling2) ? "twins": "not Twins";
		
		System.out.println(result);
		
		int sibling=2;
		String sib_name;
		
		switch(sibling) {
		case 1:
			sib_name="abi";
			break;
		case 2:
			sib_name="juhi";
			break;
		default:
			sib_name="no one";
			
		}
		System.out.println("switch case: "+sib_name);
		
		//for loop
		int i=0;
		for(i=0;i<3;i++) {
			System.out.println(i);
		}
		
		//while loop
		i=0;
		while(i<3) {
			System.out.println("while: "+i);
			i++;
		}
		
		i=0;
		do {
			System.out.println("do while: "+i);
			i++;
		}while(i<3);
		
		int[] array = new int[5];
		array[0]=1;
		array[1]=2;
		array[2]=3;
		array[3]=4;
		array[4]=5;
		
		for(int item : array) {
			System.out.println("array items: "+item);
		}
		
		List<String> al = new ArrayList<>();
		al.add("array list items:");
		al.add("al 1");
		al.add("al 2");
		al.add("al 3");
		
		for(String ali: al) {
			System.out.println(ali);
		}
		
		List<Integer> ll = new LinkedList();
		ll.add(1);
		ll.add(2);
		ll.add(3);
		
		for(int lli : ll) {
			System.out.println("ll item: "+lli);
		}
		
		Map<String, String> testmap = new HashMap<>();
		testmap.put("map 1", "1");
		testmap.put("map 2", "2");
		testmap.put("map 3", "3");
		
		for(Map.Entry<String, String> e : testmap.entrySet()) {
			System.out.println(e.getKey()+":"+e.getValue());
		}
		
	}
 
}
