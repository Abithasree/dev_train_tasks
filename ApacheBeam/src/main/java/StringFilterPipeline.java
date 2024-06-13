import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.io.TextIO;
import org.apache.beam.sdk.transforms.DoFn;
import org.apache.beam.sdk.transforms.ParDo;
import org.apache.beam.sdk.values.PCollection;

public class StringFilterPipeline {

    public static void main(String[] args) {
        Pipeline p = Pipeline.create();

        // Step 2a: Read all lines in file
        PCollection<String> lines = p.apply(TextIO.read().from("file:///C:/Users/abith/eclipse-workspace/ApacheBeam/input.txt"
        		+ ""));

        // Step 2b.i: Filter lines starting with 'a'
        PCollection<String> linesStartingWithA = lines.apply("FilterA", ParDo.of(new DoFn<String, String>() {
            @ProcessElement
            public void processElement(ProcessContext c) {
                String line = c.element();
                if (line.startsWith("a")) {
//                	System.out.println(line);
                    c.output(line);
                }
            }
        }));
        
        // Step 2b.ii: Filter lines starting with 's'
        PCollection<String> linesStartingWithS = lines.apply("FilterS", ParDo.of(new DoFn<String, String>() {
            @ProcessElement
            public void processElement(ProcessContext c) {
                String line = c.element();
                if (line.startsWith("s")) {
//                	System.out.println(line);
                    c.output(line);
                }
            }
        }));

        // Step 3: Print lines from 2.b.i that start with 'ab'
        linesStartingWithA.apply("PrintAB", ParDo.of(new DoFn<String, Void>() {
            @ProcessElement
            public void processElement(ProcessContext c) {
                String line = c.element();
                if (line.startsWith("ab")) {
                	System.out.print("end output:");
                    System.out.println(line);
                }
            }
        }));

        // Step 4: Print lines from 2.b.ii that start with 'saa'
        linesStartingWithS.apply("PrintSAA", ParDo.of(new DoFn<String, Void>() {
            @ProcessElement
            public void processElement(ProcessContext c) {
                String line = c.element();
                if (line.startsWith("saa")) {
                	System.out.print("end output:");
                    System.out.println(line);
                }
            }
        }));

        p.run().waitUntilFinish();
    }
}
