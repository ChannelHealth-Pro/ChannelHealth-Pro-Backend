package com.ChannelHealthPro.ChannelHealthPro.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Time;
import java.util.Date;

@Entity
@Table(name = "DoctorsBooking")
@Data
public class DoctorsBooking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "doctorName")
    private String doctorName;

    @Column(name = "Date")
    private Date date;

    @Column(name = "Time")
    private Time time;

    @Column(name = "Fee")
    private Long Fee;

    @Column(name = "PatientName")
    private String patientName;

    @Column(name = "Email")
    private String email;

    @Column(name = "Phone Number")
    private Long phoneNumber;

    @ManyToOne
    @JoinColumn(name = "doctorId",nullable = false)
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "customerId",nullable = false)
    private Customer customer;



}
