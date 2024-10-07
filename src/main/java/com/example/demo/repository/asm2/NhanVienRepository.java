package com.example.demo.repository.asm2;

import com.example.demo.entities.NhanVien;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NhanVienRepository extends JpaRepository<NhanVien,Integer> {
    //    @Query("SELECT sp FROM SanPham sp WHERE sp.ten LIKE :keyword")
//    public Page<SanPham> findByTenLike(@Param("keyword") String keyword, PageRequest p);

    public Page<NhanVien> findByTenLike(String keyword, PageRequest p);
}
