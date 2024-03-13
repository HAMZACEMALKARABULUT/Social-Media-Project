package com.example.socialmediaproject.entities;


import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Table(name="post")
@Data
public class Post  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Long userId;
    String title;
    @Lob
    @Column(columnDefinition = "text")
    String text;
}
