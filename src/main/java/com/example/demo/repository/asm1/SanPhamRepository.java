package com.example.demo.repository.asm1;

import com.example.demo.entities.SPCT;
import com.example.demo.entities.SanPham;

import java.awt.image.SampleModel;
import java.util.ArrayList;
import java.util.List;

public class SanPhamRepository {
    private ArrayList<SanPham> ds;

    public SanPhamRepository() {
        this.ds = new ArrayList<>();
        this.ds.add(new SanPham(1, "SP01", "AO Ngan", 1));
        this.ds.add(new SanPham(2, "SP02", "AO Dai", 0));
        this.ds.add(new SanPham(2, "SP02", "AO blazer", 0));
    }

    public List<SanPham> findAll() {
        return this.ds;
    }


    public SanPham findById(int id) {
        for (int i = 0; i < this.ds.size(); i++) {
            SanPham p = this.ds.get(i);
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    public void create(SanPham sp) {
        this.ds.add(sp);
    }

    public void update(SanPham sp) {
        for (int i = 0; i < this.ds.size(); i++) {
            SanPham p = this.ds.get(i);
            if (p.getId() == sp.getId()) {
                this.ds.set(i, sp);
            }
        }
    }

    public void deleteById(int id) {
        for (int i = 0; i < this.ds.size(); i++) {
            SanPham p = this.ds.get(i);
            if (p.getId() == id) {
                this.ds.remove(i);
            }
        }
    }
}
