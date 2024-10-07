package com.example.demo.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity

@Table(name="SanPhamChiTiet")
public class SPCT {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private Integer id;
    @Column(name="MaSPCT")
    @NotBlank(message = "Không để trống")
    private String ma;
    @NotBlank(message = "Không để trống")
    @ManyToOne
    @JoinColumn(name = "IdSanPham")
    private SanPham sp;
    @NotBlank(message = "Không để trống")
    @ManyToOne
    @JoinColumn(name = "IdMauSac")
    private MauSac ms;
    @NotBlank(message = "Không để trống")
    @ManyToOne
    @JoinColumn(name = "IdKichThuoc")
    private KichThuoc kt;
    @Column(name="SoLuong")
    @NotNull(message = "Không để trống")
    private int soLuong;
    @Column(name="DonGia")
    @NotNull(message = "Không để trống")
    private double donGia;
    @Column(name="TrangThai")
    @NotNull(message = "không để null")
    private int trangThai;
}
