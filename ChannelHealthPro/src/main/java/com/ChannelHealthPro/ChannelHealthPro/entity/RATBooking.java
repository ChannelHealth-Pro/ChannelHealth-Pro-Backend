package com.ChannelHealthPro.ChannelHealthPro.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "RATBooking")
@Data
public class RATBooking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "PatientName")
    private String patientName;

    @Column(name = "Email")
    private String email;

    @Column(name = "Phone Number")
    private Long phoneNumber;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
}
