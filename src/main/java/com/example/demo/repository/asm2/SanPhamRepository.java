package com.example.demo.repository.asm2;

import com.example.demo.entities.NhanVien;
import com.example.demo.entities.SanPham;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SanPhamRepository extends JpaRepository<SanPham,Integer> {
    public Page<SanPham> findByTenLike(String keyword, PageRequest p);
}
