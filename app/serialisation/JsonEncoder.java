package serialisation;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import kafka.serializer.Encoder;
import kafka.utils.VerifiableProperties;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by mike on 16/06/15.
 */
public class JsonEncoder implements Encoder<Object> {
    private static final Logger LOGGER = Logger.getLogger(JsonEncoder.class.toString());

    public JsonEncoder(VerifiableProperties verifiableProperties) {
        /* This constructor must be present for successful compile. */
    }

    @Override
    public byte[] toBytes(Object object) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(object).getBytes();
        } catch (JsonProcessingException e) {
            LOGGER.log(Level.SEVERE, String.format("Json processing failed for object: %s", object.getClass().getName()), e);
        }
        return "".getBytes();
    }
}
