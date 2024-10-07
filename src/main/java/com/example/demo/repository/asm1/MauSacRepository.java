package com.example.demo.repository.asm1;

import com.example.demo.entities.MauSac;

import java.util.ArrayList;
import java.util.List;

public class MauSacRepository {
    private ArrayList<MauSac> ds;

    public MauSacRepository() {
        this.ds = new ArrayList<>();
        this.ds.add(new MauSac(1, "ms01", "mau red", 1));
        this.ds.add(new MauSac(2, "ms02", "mau blue", 0));
        this.ds.add(new MauSac(3, "ms03", "mau yellow", 0));
    }

    public List<MauSac> findAll() {
        return this.ds;
    }
    public MauSac findById(int id){
        for (int i = 0; i < this.ds.size(); i++) {
            MauSac m = this.ds.get(i);
            if(m.getId() == id){
                return m;
            }
        }
        return null;
    }


    public void create(MauSac kh) {
        this.ds.add(kh);
    }

    public void update(MauSac kh) {
        for (int i = 0; i < this.ds.size(); i++) {
            MauSac m = this.ds.get(i);
            if (m.getId() == kh.getId()) {
                this.ds.set(i, kh);
            }
        }
    }

    public void delete(int id) {
        for (int i = 0; i < this.ds.size(); i++) {
            MauSac m = this.ds.get(i);
            if (m.getId() == id) {
                this.ds.remove(i);
            }
        }
    }
}
