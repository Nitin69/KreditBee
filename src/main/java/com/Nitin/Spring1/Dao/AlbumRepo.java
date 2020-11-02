/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Nitin.Spring1.Dao;

import com.Nitin.Spring1.model.Album;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Asus06
 */
@Repository
public interface AlbumRepo extends JpaRepository<Album,Integer>{
    @Query("select a from Album a where id=?1 and userId=?2")
    public Album findByIdAndUserId(int id, int userId);

    public List<Album> findByUserId(int userId);
}
