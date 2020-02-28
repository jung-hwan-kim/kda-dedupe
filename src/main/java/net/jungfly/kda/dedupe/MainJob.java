package net.jungfly.kda.dedupe;

import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.functions.sink.SinkFunction;
import org.apache.flink.streaming.api.functions.source.SourceFunction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainJob {
    private static Logger log = LoggerFactory.getLogger(MainJob.class);

    public static void main(String[] args) throws Exception {
        final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();


        SourceFunction<String> src = Configurator.createSource();
        SinkFunction<String> sink = Configurator.createSink();

        env.addSource(src).name("in")
                .map(new Parser()).name("parser")
                .map(new StreamLog()).name("logger")
                .addSink(sink).name("out");
        env.execute("dedup");
    }
}
