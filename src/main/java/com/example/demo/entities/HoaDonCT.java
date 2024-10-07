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
@Setter
@Getter
@Entity
@Component
@Table(name = "HoaDonChiTiet")
public class HoaDonCT {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "IdHoaDon")
    @NotNull(message = "Không để trống")
    private int idHoaDon;
    @Column(name = "IdSPCT")
    @NotNull(message = "Không để trống")
    private int idSPCT;
    @Column(name = "SoLuong")
    @NotNull(message = "Không để trống")
    private int soLuong;
    @Column(name = "DonGia")
    @NotNull(message = "Không để trống")
    private float donGia;
    @Column(name = "TrangThai")
    @NotNull(message = "không để null")
    private int trangThai;
}
