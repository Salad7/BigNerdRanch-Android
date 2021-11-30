package com.example.photogallery;

import android.net.Uri;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class FlickFetchr {
    private static final String API_KEY = "5a41159f5104f8853b23adafce7bc988";
    private static final String TAG = "FlickFetchr";

    public ArrayList<GalleryItem> fetchItems(){
        try {
            ArrayList<GalleryItem> items = new ArrayList<>();
            String url = Uri.parse("https://api.flickr.com/services/rest/")
                    .buildUpon()
                    .appendQueryParameter("method","flickr.photos.getRecent")
                    .appendQueryParameter("api_key",API_KEY)
                    .appendQueryParameter("formant","json")
                    .appendQueryParameter("nojsoncallback", "1")
                    .appendQueryParameter("extras", "url_s")
                    .build().toString();
            Log.i(TAG,"FlickFetchr Pre URL: "+url);

            String jsonString = getUrlString(url);
//            Log.i(TAG,"FlickFetchr URL: "+url);

            Log.i(TAG,"Received JSON: "+jsonString);
            JSONObject jsonBody = new JSONObject(jsonString);
            parseItems(items,jsonBody);
            return items;

        }
        catch (JSONException je){
            Log.e(TAG,"Failed to parse JSON");
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }


    private void parseItems(ArrayList<GalleryItem> items, JSONObject jsonBody)throws  IOException, JSONException{
        JSONObject photosJsonObject = jsonBody.getJSONObject("photos");
        JSONArray photoJsonArray = photosJsonObject.getJSONArray("photo");
        for(int i = 0; i < photoJsonArray.length(); i++){
            JSONObject photoJsonObject = photoJsonArray.getJSONObject(i);
            GalleryItem item = new GalleryItem();
            item.setmId(photoJsonObject.getString("id"));
            item.setmCaption(photoJsonObject.getString("title"));
            if(!photoJsonObject.has("url_s")){
                continue;
            }
            item.setmUrl(photoJsonObject.getString("url_s"));
            Log.d("FlickFetchr","Adding item: title = "+item.getmCaption());
            items.add(item);
        }

    }
    public byte[] getUrlBytes(String urlSpec) throws IOException {
        URL url = new URL(urlSpec);
        HttpURLConnection connection = (HttpURLConnection)url.openConnection();
        try {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            InputStream in = connection.getInputStream();
            if (connection.getResponseCode() != HttpURLConnection.HTTP_OK){
                throw new IOException(connection.getResponseMessage() +": with "+urlSpec);
            }
            int bytesRead = 0;
            byte[] buffer = new byte[1024];
            while ((bytesRead = in.read(buffer)) > 0){
                out.write(buffer, 0 , bytesRead);
            }
            out.close();
            return out.toByteArray();
        } finally {
            connection.disconnect();
        }
    }

    public String getUrlString(String urlSpec) throws IOException {
        return new String(getUrlBytes(urlSpec));
    }

}
