package task1;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.*;

public class CallTask {
	
	static class MyCallable implements Callable<String>{
		String name;
		int num;
		
		public MyCallable(String name, int num) {
			this.name= name;
			this.num=num;
		}
		public String call() throws Exception {
		    String output = String.format("(%s/%d)", name, num);
		    System.out.println(output);
		    return output;
		}

	}
	
	public static void main(String args[]) throws Exception{
		ExecutorService executor = Executors.newFixedThreadPool(10);
		List<Callable<String>> callables = new ArrayList<>();
		
		for(int i=0; i<5;i++) {
			String name = "rand string" + i;
			int num = i*27;
			callables.add(new MyCallable(name,num));
		}
		
		List<Future<String>> futures = executor.invokeAll(callables);
		// to me, invokeall returns a value back in future type but unlike submit it can have more than one callable
		for( Future<String> f : futures) {
			System.out.println("future outpt: "+f.get());
		}
		
		executor.shutdown();
		
	}

}


