package com.Nitin.Spring1;

import com.Nitin.Spring1.Dao.AlbumRepo;
import com.Nitin.Spring1.model.Album;
import com.Nitin.Spring1.service.AlbumService;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Spring1Application {
        
    
	public static void main(String[] args) throws IOException {
		SpringApplication.run(Spring1Application.class, args);
                
                
	}
        
}
