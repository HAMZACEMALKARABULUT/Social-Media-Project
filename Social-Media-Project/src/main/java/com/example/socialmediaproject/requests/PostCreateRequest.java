package com.example.socialmediaproject.requests;


import lombok.Data;

@Data
public class PostCreateRequest {
    String text;
    String title;
    Long userId;


}
