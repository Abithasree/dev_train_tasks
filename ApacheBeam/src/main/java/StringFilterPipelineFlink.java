import org.apache.beam.runners.flink.FlinkPipelineOptions;
import org.apache.beam.runners.flink.FlinkRunner;
import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.PipelineResult;
import org.apache.beam.sdk.io.TextIO;
import org.apache.beam.sdk.options.PipelineOptionsFactory;
import org.apache.beam.sdk.transforms.DoFn;
import org.apache.beam.sdk.transforms.ParDo;
import org.apache.beam.sdk.values.PCollection;

public class StringFilterPipelineFlink {

    public static void main(String[] args) {
        // Create pipeline options for Flink
        FlinkPipelineOptions options = PipelineOptionsFactory.fromArgs(args).withValidation().as(FlinkPipelineOptions.class);
        options.setRunner(FlinkRunner.class);
        options.setJobName("StringFilterPipeline");
        options.setParallelism(1);

        // Create the pipeline with Flink options
        Pipeline p = Pipeline.create(options);

        // Step 2a: Read all lines in file
        PCollection<String> lines = p.apply(TextIO.read().from("file:///C:/Users/abith/eclipse-workspace/ApacheBeam/input.txt"));

        // Step 2b.i: Filter lines starting with 'a'
        PCollection<String> linesStartingWithA = lines.apply("FilterA", ParDo.of(new DoFn<String, String>() {
            @ProcessElement
            public void processElement(ProcessContext c) {
                String line = c.element();
                if (line.startsWith("a")) {
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
                	System.out.print("flink output: ");
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
                	System.out.print("flink output: ");
                    System.out.println(line);
                }
            }
        }));

        // Run the pipeline
        PipelineResult result = p.run();
        result.waitUntilFinish();
    }
}
