package utility;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import data.HumanBeing;

import java.lang.reflect.Type;

import java.time.LocalDateTime;
import java.util.TreeSet;

public final class JsonParser {
    private JsonParser() {
    }
    public static TreeSet<HumanBeing> toData(String json) {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeDeserializer())
                .setPrettyPrinting().create();
        Type typeToken = new TypeToken<TreeSet<HumanBeing>>() {
        }.getType();
        return gson.fromJson(json.trim(), typeToken);
    }

    public static String toJson(TreeSet<HumanBeing> collectionData) {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeSerializer())
                .setPrettyPrinting().create();
        return gson.toJson(collectionData);
    }
}
