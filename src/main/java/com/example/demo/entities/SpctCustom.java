package com.example.demo.entities;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SpctCustom {
    @Id
    private Integer id;
    private Integer idMS;
    private Integer idKT;
    private String tenSP;
    private String maSPCT;
    private Integer soLuong;
    private double donGia;
    private Integer trangThai;
}
