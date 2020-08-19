package com.mercury.SpringBootRestDemo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mercury.SpringBootRestDemo.beans.Artwork;
import com.mercury.SpringBootRestDemo.beans.Product;
import com.mercury.SpringBootRestDemo.services.ArtworkService;

@RestController
@RequestMapping("/artworks")
public class ArtworkController {
    @Autowired
    ArtworkService artworkService;
    
    @GetMapping
	public List<Artwork> getAll() {
		return artworkService.getAll();
	}
    
    public void saveArtWork(@RequestBody Artwork artWork) {
    	artworkService.save(artWork);
    }
   
    public void deleteArtWork(@RequestBody Artwork artWork) {
        artworkService.delete(artWork);
    }
}