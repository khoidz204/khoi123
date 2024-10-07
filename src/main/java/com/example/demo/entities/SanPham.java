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
@Component
@Table(name = "SanPham")
@Entity
public class SanPham{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "Ma")
    @NotBlank(message = "Không để trống")
    private String ma;
    @Column(name = "Ten")
    @NotBlank(message = "Không để trống")
    private String ten;
    @Column(name = "TrangThai")
    @NotNull(message = "không để null")
    private int trangThai;
}
