package com.mercury.SpringBootRestDemo.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mercury.SpringBootRestDemo.beans.Artwork;

public interface ArtworkDao extends JpaRepository<Artwork, Integer> {

}