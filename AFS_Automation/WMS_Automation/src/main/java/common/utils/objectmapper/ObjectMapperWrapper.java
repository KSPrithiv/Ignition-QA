package common.utils.objectmapper;
import java.io.File;
import java.io.IOException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectMapperWrapper {
    ObjectMapper objectMapper = null;

    public <T> T getObject(String pathToFile, Class<T> clazz) {
        objectMapper = new ObjectMapper();
        T obj = null;
        try {
            obj = objectMapper.readValue(new File(pathToFile), clazz);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return obj;
    }
}
