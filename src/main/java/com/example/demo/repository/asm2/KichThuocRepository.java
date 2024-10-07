package com.example.demo.repository.asm2;

import com.example.demo.entities.KichThuoc;
import com.example.demo.entities.NhanVien;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KichThuocRepository extends JpaRepository<KichThuoc,Integer> {
    public Page<KichThuoc> findByTenLike(String keyword, PageRequest p);
}
