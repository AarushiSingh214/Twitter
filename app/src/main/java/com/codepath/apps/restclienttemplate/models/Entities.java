package com.codepath.apps.restclienttemplate.models;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcel;

@Parcel
public class Entities {
    public String ivUrl;

    public Entities() {}

    public static Entities fromJson(JSONObject jsonObject) throws JSONException{

        Entities entity = new Entities();
        Log.i("Entities", String.valueOf(jsonObject));

        try{
            if(jsonObject.has("media")) {
                Log.i("entities", "inside if");
                entity.ivUrl = jsonObject.getJSONArray("media").getJSONObject(0).getString("media_url_https");
            }else{
                entity.ivUrl = null;
            }
        }catch(JSONException e){
            entity.ivUrl = null;

        }
        return entity;
    }

}
