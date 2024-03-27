package com.project.URL.Shortener.Repositories;

import com.project.URL.Shortener.Models.LongURL;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LongURLRepository extends JpaRepository<LongURL, Long> {


}
