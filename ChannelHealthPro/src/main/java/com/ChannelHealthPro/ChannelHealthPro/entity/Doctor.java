package com.ChannelHealthPro.ChannelHealthPro.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Table(name = "Doctor")
@Data
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "specialty")
    private String specialty;

    @Column(name="Fee")
    private Long fee;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;


    @OneToMany(mappedBy = "doctor")
    private Set<DoctorAvailability> doctorAvailabilities;

    @OneToMany(mappedBy = "doctor")
    private Set<DoctorsBooking> doctorsBookings;
}
