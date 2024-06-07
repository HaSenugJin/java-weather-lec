package gson;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class Gson {
    public JsonArray Json(String responseBody) {
        com.google.gson.Gson gson = new com.google.gson.Gson();
        JsonObject jsonObject = gson.fromJson(responseBody, JsonObject.class);

        JsonObject body = jsonObject.getAsJsonObject("response").getAsJsonObject("body");
        JsonObject items = body.getAsJsonObject("items");
        return items.getAsJsonArray("item");
    }
}
