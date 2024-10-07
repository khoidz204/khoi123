package com.example.demo.repository.asm2;

import com.example.demo.entities.KhachHang;
import com.example.demo.entities.NhanVien;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KhachHangRepository extends JpaRepository<KhachHang,Integer> {
    public Page<KhachHang> findByTenLike(String keyword, PageRequest p);
}
