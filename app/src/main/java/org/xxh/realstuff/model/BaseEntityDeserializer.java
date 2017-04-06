package org.xxh.realstuff.model;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * @author xiexinhong (xiexinhong@meituan.com) on 16/11/18.
 */

public class BaseEntityDeserializer implements JsonDeserializer<BaseEntity> {


    @Override
    public BaseEntity deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext
            context) throws JsonParseException {
        if(json.isJsonObject()) {
            return null;
        }
        BaseEntity entity = new BaseEntity();
        JsonObject jsonObject = (JsonObject) json;
        if(jsonObject.has("msg") && jsonObject.get("msg").isJsonPrimitive()) {
            entity.msg = jsonObject.get("msg").getAsString();
        }
        if(jsonObject.has("error") && jsonObject.get("error").isJsonPrimitive()) {
            entity.error = jsonObject.get("error").getAsBoolean();
        }
        if (jsonObject.has("results") && jsonObject.get("results").isJsonArray() && typeOfT instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) typeOfT;
                Type dataType = parameterizedType.getActualTypeArguments()[0];
                JsonArray array = jsonObject.get("results").getAsJsonArray();
                int len = array.size();
                ArrayList list = new ArrayList();
                for (int i = 0; i < len; i++) {
                    JsonElement je = array.get(i);
                    list.add(context.deserialize(je, dataType));
                }
                entity.results = list;
        }
        return entity;
    }
}
