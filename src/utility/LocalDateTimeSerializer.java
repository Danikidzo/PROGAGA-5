package utility;

import com.google.gson.JsonElement;
import java.lang.reflect.Type;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.time.LocalDateTime;

public class LocalDateTimeSerializer implements JsonSerializer<LocalDateTime> {
    @Override
    public JsonElement serialize(LocalDateTime Date, Type srcType, JsonSerializationContext context) {
        return new JsonPrimitive(Date.toString());
    }
}
