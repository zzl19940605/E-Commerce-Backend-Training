package com.mercury.SpringBootRestDemo.services;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mercury.SpringBootRestDemo.beans.Artwork;
import com.mercury.SpringBootRestDemo.beans.Product;
import com.mercury.SpringBootRestDemo.daos.ArtworkDao;

@Service

public class ArtworkService {
   @Autowired
   ArtworkDao artworkDao;

   public void save(Artwork artwork) {
       artworkDao.save(artwork);
   }
   
   public void delete(Artwork artwork) {
	   artworkDao.delete(artwork);
   }
   
   public List<Artwork> getAll() {
		return artworkDao.findAll();
   }
   
   public Map<Artwork, Integer> sortByprice(){
	   Map<Artwork, Integer> map = new TreeMap();
	   List<Artwork> ar= artworkDao.findAll();
	   for(int i=0; i<ar.size(); i++) {
		   map.put(ar.get(i), i);
	   }
	   return map;
   }
}