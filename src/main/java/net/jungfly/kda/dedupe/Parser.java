package net.jungfly.kda.dedupe;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.apache.flink.api.common.functions.MapFunction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Parser implements MapFunction<String, ObjectNode> {
    private static Logger log = LoggerFactory.getLogger(Parser.class);
    private static ObjectMapper mapper = new ObjectMapper();

    @Override
    public ObjectNode map(String s) throws Exception {
        log.info(s);
        ObjectNode node = (ObjectNode) mapper.readTree(s);
        return node;
    }
}