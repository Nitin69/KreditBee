/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Nitin.Spring1.controller;

import com.Nitin.Spring1.Dao.AlbumRepo;
import com.Nitin.Spring1.Dao.PhotosRepo;
import com.Nitin.Spring1.model.Album;
import com.Nitin.Spring1.model.Photos;
import com.Nitin.Spring1.service.AlbumService;
import com.Nitin.Spring1.service.PhotosService;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Asus06
 * 
 */
@Controller
public class AlbumController {
    @Autowired
    private AlbumRepo repo1;
    @Autowired
    private PhotosRepo repo2;
    @RequestMapping("/albums")
    @ResponseBody
    public List<Album> getAlbums() throws IOException{
        
        return repo1.findAll();
    }
    @RequestMapping(value = "albums", params = {"id","userId"})
    @ResponseBody
    public Album getAlbumsByIdAndUserId(int id, int userId){
        return repo1.findByIdAndUserId(id,userId);
    }
    @RequestMapping(value="albums", params={"id"})
    @ResponseBody
    public Album getAlbumById(int id){
        return repo1.findById(id).orElse(null);
    }
    @RequestMapping(value="albums", params={"userId"})
    @ResponseBody
    public List<Album> getAlbumsByUserId(int userId){
        return repo1.findByUserId(userId);
    }
    @RequestMapping("/photos")
    @ResponseBody
    public List<Photos> getPhotos() throws IOException{
        
        return repo2.findAll();
    }
    @RequestMapping(value = "photos",params = {"id"})
    @ResponseBody
    public Photos getPhotoById(int id){
       
        return repo2.findById(id).orElse(null);
    }
    @RequestMapping(value="photos",params={"albumId"})
    @ResponseBody
    public List<Photos> getByPhotosByAlbumId(int albumId){
        
        return repo2.findByAlbumId(albumId);
    }
    @RequestMapping(value="photos", params={"id","albumId"})
    @ResponseBody
    public Photos getByPhotoIdAndAlbumId(int id, int albumId){
        
        return repo2.findByIdAndAlbumId(id, albumId);
    }
    
    @RequestMapping(value="fetchAlbums")
    @ResponseBody
    public String fetchAlbums() throws IOException{
        AlbumService service = new AlbumService();
        List<Album> list = service.MyGetRequest("https://jsonplaceholder.typicode.com/albums");
       
        repo1.saveAll(list);
        return "fetching albums";
    }
    @RequestMapping(value ="fetchPhotos")
    @ResponseBody
    public String fetchPhotos() throws IOException{
        PhotosService service = new PhotosService();
        List<Photos> list = service.MyGetRequest("https://jsonplaceholder.typicode.com/photos");
       
        repo2.saveAll(list);
        return "fetching photos";
        
    }
}
