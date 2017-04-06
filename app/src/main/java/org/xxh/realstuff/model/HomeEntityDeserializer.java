package org.xxh.realstuff.model;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xiexinhong (xiexinhong@meituan.com) on 16/11/18.
 */

public class HomeEntityDeserializer implements JsonDeserializer<HomeEntity> {


    @Override
    public HomeEntity deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext
            context) throws JsonParseException {
        if (json.isJsonObject()) {
            return null;
        }
        HomeEntity entity = new HomeEntity();
        JsonObject jsonObject = (JsonObject) json;
        if (jsonObject.has("msg") && jsonObject.get("msg").isJsonPrimitive()) {
            entity.msg = jsonObject.get("msg").getAsString();
        }
        if (jsonObject.has("error") && jsonObject.get("error").isJsonPrimitive()) {
            entity.error = jsonObject.get("error").getAsBoolean();
        }
        if (jsonObject.has("results") && typeOfT instanceof ParameterizedType) {
            entity.results = context.deserialize(jsonObject.get("results"),new
                    TypeToken<LinkedHashMap<String,List<Recommend>>>(){}.getType());
        }
        if (jsonObject.has("category") && jsonObject.get("category").isJsonArray()) {
            List<String> category = new ArrayList<>();
            JsonArray array = jsonObject.get("category").getAsJsonArray();
            int len = array.size();
            for (int i = 0; i < len; i++) {
                JsonElement je = array.get(i);
                category.add(context.deserialize(je, String.class));
            }
        }
        return entity;
    }
}
