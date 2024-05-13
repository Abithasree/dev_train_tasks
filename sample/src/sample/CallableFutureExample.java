package sample;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class CallableFutureExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // List to hold Future objects
        List<Future<Integer>> futures = new ArrayList<>();

        // Submitting multiple Callable tasks
        for (int i = 0; i < 5; i++) {
            Callable<Integer> task = new MyCallable(i);
            Future<Integer> future = executor.submit(task);
            futures.add(future);
        }

        // Perform other operations while tasks are being executed
        System.out.println("Performing unrelated operations...");

        // Retrieve results from Future objects
        for (Future<Integer> future : futures) {
            try {
                Integer result = future.get(); // Blocking operation to get task result
                System.out.println("Result from task: " + result);
            } catch (InterruptedException | ExecutionException e) {
                // Handle exceptions
                e.printStackTrace();
            }
        }

        // Shutdown the executor
        executor.shutdown();
    }

    static class MyCallable implements Callable<Integer> {
        private int taskId;

        public MyCallable(int taskId) {
            this.taskId = taskId;
        }

        @Override
        public Integer call() throws Exception {
            // Simulate task execution (e.g., performing complex computation)
            Thread.sleep(1000); // Simulate task processing time
            return taskId * 10; // Return a calculated result
        }
    }
}
