/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Nitin.Spring1.service;

import com.Nitin.Spring1.Dao.AlbumRepo;
import com.Nitin.Spring1.model.Album;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Asus06
 */

public class AlbumService {
   
   public  List<Album> MyGetRequest(String api) throws IOException{
       //"https://jsonplaceholder.typicode.com/albums"
        List<Album> list =null;
       System.out.println("My get request called");
       URL urlForGetRequest = new URL(api);
       String readLine = null;
       HttpURLConnection connection = (HttpURLConnection)urlForGetRequest.openConnection();
       connection.setRequestMethod("GET");
       connection.setRequestProperty("id","userId");
       //ResponseEntity<String> responseJson = restTemplate.exchange("https://jsonplaceholder.typicode.com/albums", HttpMethod.GET, String.class);
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
   public  List<Album> stringParse(StringBuffer response){
       JSONArray albums = new JSONArray(response.toString());
       List<Album> list = new ArrayList<Album>();
       for(int i=0;i<albums.length();i++){
           JSONObject album = albums.getJSONObject(i);
           int id = album.getInt("id");
           int userId = album.getInt("userId");
           String title  = album.getString("title");
           Album obj = new Album();
           obj.setUserId(userId);
           obj.setId(id);
           obj.setTitle(title);
           list.add(obj);
       }
       
        return list;
   }
  
  
}
