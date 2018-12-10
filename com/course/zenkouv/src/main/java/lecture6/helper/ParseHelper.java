package lecture6.helper;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import lecture6.exception.ParseException;

public class ParseHelper {

    private ParseHelper() {
    }

    public static <T> List<T> parse(String data, Class<T> clazz) {
        ObjectMapper mapper = new ObjectMapper();
        TypeFactory typeFactory = mapper.getTypeFactory();
        try {
            return mapper.readValue(data, typeFactory.constructCollectionType(List.class, clazz));
        } catch (IOException e) {
            throw new ParseException(String.format("Can't parse: %s \n to %S class", data, clazz.getName()));
        }
    }
}
