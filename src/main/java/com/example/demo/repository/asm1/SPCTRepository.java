package com.example.demo.repository.asm1;

import com.example.demo.entities.MauSac;
import com.example.demo.entities.SPCT;
import com.example.demo.entities.SanPham;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class SPCTRepository {
    private ArrayList<SPCT> ds;

//    public SPCTRepository() {
//        this.ds = new ArrayList<>();
//        this.ds.add(new SPCT(1, "01", "red", "ngan", 20, 2000, 1));
//        this.ds.add(new SPCT(2, "02", "blue", "dai", 5, 50000, 0));
//        this.ds.add(new SPCT(3, "03", "yellow", "tb", 10, 2999, 0));
//    }

    public List<SPCT> findAll() {
        return this.ds;
    }
    public SPCT findById(int id){
        for (int i = 0; i < this.ds.size(); i++) {
            SPCT m = this.ds.get(i);
            if(m.getId() == id){
                return m;
            }
        }
        return null;
    }

    public List<SPCT> findBySPId(int spId) {
        List<SPCT> kq = new ArrayList<>();
        for (SPCT sp : ds) {
            if (sp.getId() == spId) {
                kq.add(sp);
            }
        }
        return kq;
    }

    public List<SPCT> findByMsId(int msId) {
        List<SPCT> kq = new ArrayList<>();
        for (SPCT sp : ds) {
            if (sp.getId() == msId) {
                kq.add(sp);
            }
        }
        return kq;
    }

    public List<SPCT> findByKtId(int ktId) {
        List<SPCT> kq = new ArrayList<>();
        for (SPCT sp : ds) {
            if (sp.getId() == ktId) {
                kq.add(sp);
            }
        }
        return kq;
    }
    public void create(SPCT sp){
        this.ds.add(sp);
    }
    public void update(SPCT kh) {
        for (int i = 0; i < this.ds.size(); i++) {
            SPCT m = this.ds.get(i);
            if (m.getId() == kh.getId()) {
                this.ds.set(i, kh);
            }
        }
    }

}
