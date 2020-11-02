/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Nitin.Spring1.service;

import com.Nitin.Spring1.model.Album;
import com.Nitin.Spring1.model.Photos;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Asus06
 */
public class PhotosService {
     public  List<Photos> MyGetRequest(String api) throws IOException{
       
        List<Photos> list =null;
       System.out.println("My get request called");
       URL urlForGetRequest = new URL(api);
       String readLine = null;
       HttpURLConnection connection = (HttpURLConnection)urlForGetRequest.openConnection();
       connection.setRequestMethod("GET");
       connection.setRequestProperty("id","userId");
      
       int responseCode = connection.getResponseCode();
       if(responseCode == HttpURLConnection.HTTP_OK){
           BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
           StringBuffer response = new StringBuffer();
           while((readLine = in.readLine())!=null){
               response.append(readLine);
           }
           in.close();
           System.out.println("OK"+response.toString());
            list = stringParse(response);
           
       }
       else{
           System.out.println("Get not worked");
       }
       return list;
   }
   public  List<Photos> stringParse(StringBuffer response){
       JSONArray photos = new JSONArray(response.toString());
       List<Photos> list = new ArrayList<Photos>();
       for(int i=0;i<photos.length();i++){
           JSONObject photo = photos.getJSONObject(i);
           int id = photo.getInt("id");
           int albumId = photo.getInt("albumId");
           String title  = photo.getString("title");
           String thumbnailUrl = photo.getString("thumbnailUrl");
           String url = photo.getString("url");
           Photos obj = new Photos();
           obj.setAlbumId(albumId);
           obj.setId(id);
           obj.setTitle(title);
           obj.setThumbnailUrl(thumbnailUrl);
           obj.setUrl(url);
           list.add(obj);
       }
       
        return list;
   }
  
}
