package com.example.demo.repository.asm2;

import com.example.demo.entities.MauSac;
import com.example.demo.entities.NhanVien;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MauSacRepository extends JpaRepository<MauSac,Integer> {
    public Page<MauSac> findByTenLike(String keyword, PageRequest p);
}
