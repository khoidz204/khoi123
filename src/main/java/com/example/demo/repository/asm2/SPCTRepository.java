package com.example.demo.repository.asm2;

import com.example.demo.entities.NhanVien;
import com.example.demo.entities.SPCT;
import com.example.demo.entities.SanPham;
import com.example.demo.entities.SpctCustom;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SPCTRepository extends JpaRepository<SPCT, Integer> {
//    @Query("SELECT new SpctCustom(spct.id, spct.idMS, spct.idKT, sp.ten, spct.ma, " +
//            " spct.soLuong, spct.donGia, spct.trangThai) FROM SPCT spct JOIN SanPham sp ON spct.idSP = sp.id")
//    public List<SpctCustom> findAllWithPropName();
}
