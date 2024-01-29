package com.ChannelHealthPro.ChannelHealthPro.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "User")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "Name")
    private String name;
    @Column(name = "Email")
    private String email;
    @Column(name = "Phone Number")
    Long phoneNumber;
    @Column(name = "Password")
    String password;
}
