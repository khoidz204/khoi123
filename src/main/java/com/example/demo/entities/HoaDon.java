package com.example.demo.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Component
@Table(name = "HoaDon")
public class HoaDon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "IdNV")
    @NotNull(message = "Không để trống")
    private int idNhanVien;
    @Column(name = "IdKH")
    @NotNull(message = "Không để trống")
    private int idKhachHang;
    @Column(name = "NgayMuaHang")
    @NotBlank(message = "Không để trống")
    private String ngayMua;
    @Column(name = "TrangThai")
    @NotNull(message = "không để null")
    private int trangThai;
}
