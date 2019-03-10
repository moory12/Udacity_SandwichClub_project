package com.udacity.sandwichclub.utils;

import android.util.Log;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {

        Sandwich sandwich = null;
        try {
            JSONObject jsonObject = new JSONObject(json);

            ArrayList alsoKnowsAs = jsonToArrayList(jsonObject.getJSONObject("name").getJSONArray("alsoKnownAs"));
            ArrayList ingredients = jsonToArrayList(jsonObject.getJSONArray("ingredients"));
            sandwich = new Sandwich(jsonObject.getJSONObject("name").getString("mainName"),
                                    alsoKnowsAs,
                                    jsonObject.getString("placeOfOrigin"),
                                    jsonObject.getString("description"),
                                    jsonObject.getString("image"),
                                    ingredients);

        } catch (JSONException e) {
            Log.e("JsonUtil","Error parsing JSON");
            e.printStackTrace();
        }
        return sandwich;
    }

    public static ArrayList jsonToArrayList(JSONArray jsonArray){
        ArrayList<String> temp = new ArrayList<>();
        try {
            for(int i =0;i<jsonArray.length();i++){

                temp.add(jsonArray.get(i).toString());
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }


        return temp;
    }




}
