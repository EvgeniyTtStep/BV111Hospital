package com.example.bv111hospital.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "images")
public class Image {

    @Id
    @Column(name = "id_images")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idImages;

    private String name;

    private String contentType;

    @Lob
    private byte[] content;

    private Long doctorId;
}