package com.project.URL.Shortener.Repositories;

import com.project.URL.Shortener.Models.ShortURL;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShortURLRepository extends JpaRepository<ShortURL, Long> {


}
