package com.example.demo.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Component
@Table(name = "MauSac")
public class MauSac {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "Ma")
    @NotBlank(message = "Không để trống")
    private String maMS;
    @Column(name = "Ten")
    @NotBlank(message = "Không để trống")
    private String ten;
    @Column(name = "TrangThai")
    @NotNull(message = "không để null")
    private int trangThai;
}
