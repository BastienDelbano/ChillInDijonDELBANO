package org.diiage.delbano.chillindijondelbano;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Bastien on 16/03/2018.
 */

public class JSONParser {
    public Signboard JsonToSignboard(JSONObject json) throws JSONException {
        Signboard signboard = new Signboard(json.getString("id"), json.getString("type"), json.getString("name"), JsonToLocation(json.getJSONObject("location")));
        return signboard;
    }

    public Location JsonToLocation(JSONObject json) throws JSONException {
        android.location.Location position = new android.location.Location("");
        position.setLatitude(json.getJSONObject("position").getDouble("lat"));
        position.setLongitude(json.getJSONObject("position").getDouble("lon"));
        return new Location(json.getString("adress"), json.getString("postalCode"), json.getString("city"), position);
    }
}
