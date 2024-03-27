package com.project.URL.Shortener.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
@Entity(name = "longurls")
public class LongURL {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String url;

    @OneToOne(cascade = CascadeType.ALL)
    private ShortURL shortURL;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
}
