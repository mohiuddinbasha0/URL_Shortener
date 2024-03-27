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
@Entity(name = "shorturls")
public class ShortURL {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "domain", nullable = false)
    private String domain = "localhost:8080";

    @Column(name = "protocol", nullable = false)
    private String protocol = "http";

    @OneToOne(cascade = CascadeType.ALL)
    private LongURL longURL;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
}
