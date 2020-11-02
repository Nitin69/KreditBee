/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Nitin.Spring1.Dao;

import com.Nitin.Spring1.model.Photos;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Asus06
 */
public interface PhotosRepo extends JpaRepository<Photos,Integer>{
    
    @Query("select p from Photos p where id=?1 and albumId=?2")
    public Photos findByIdAndAlbumId(int id, int albumId);
    public List<Photos> findByAlbumId(int albumId);
}
