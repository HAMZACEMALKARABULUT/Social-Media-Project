package com.example.socialmediaproject.entities;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;


@Entity
@Table(name = "user")
@Data
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

@Column(name="user_name")
    String userName;
@Column(name="password")
    String password;

}


