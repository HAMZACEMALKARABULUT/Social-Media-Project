package com.example.socialmediaproject.entities;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "comment")

public class Comment {
    @Id
    Long id;
    Long userId;
    Long postId;
    @Lob
    @Column(columnDefinition = "text")
    String text;
}
