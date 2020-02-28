package net.jungfly.kda.dedupe;


import com.fasterxml.jackson.databind.node.ObjectNode;
import org.apache.flink.api.common.functions.MapFunction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StreamLog implements MapFunction<ObjectNode, String> {
    private static Logger log = LoggerFactory.getLogger(StreamLog.class);

    @Override
    public String map(ObjectNode s) throws Exception {
        return s.toString();
    }
}
