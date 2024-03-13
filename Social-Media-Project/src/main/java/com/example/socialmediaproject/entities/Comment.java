package com.example.socialmediaproject.entities;


import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity

@Table(name = "comment")
@Data
public class Comment implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Long userId;
    Long postId;
    @Lob
    @Column(columnDefinition = "text")
    String text;
}
