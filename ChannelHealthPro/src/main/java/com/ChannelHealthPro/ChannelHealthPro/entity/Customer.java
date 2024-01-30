package com.ChannelHealthPro.ChannelHealthPro.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Customer")
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToMany(mappedBy = "customer")
    private Set<DoctorsBooking> doctorsBookings;

    @OneToMany(mappedBy = "customer")
    private List<RATBooking> ratBookings;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
