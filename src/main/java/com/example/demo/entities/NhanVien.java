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
@Component
@Entity
@Table(name = "NhanVien")
public class NhanVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "Ten")
    @NotBlank(message = "Không để trống")
    private String ten;
    @Column(name = "Ma")
    @NotBlank(message = "Không để trống")
    private String ma;
    @Column(name = "TenDangNhap")
    @NotBlank(message = "Không để trống")
    private String tenDN;
    @Column(name = "MatKhau")
    @NotBlank(message = "Không để trống")
    private String mk;
    @Column(name = "TrangThai")
    @NotNull(message = "không để null")
    private int trangThai;

}
