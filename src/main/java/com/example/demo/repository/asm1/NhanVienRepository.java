package com.example.demo.repository.asm1;

import com.example.demo.entities.NhanVien;

import java.util.ArrayList;
import java.util.List;

public class NhanVienRepository {
    private ArrayList<NhanVien> ds;

    public NhanVienRepository() {
        this.ds = new ArrayList<>();
        this.ds.add(new NhanVien(1, "khoi", "nv01", "khoi123", "1234", 1));
        this.ds.add(new NhanVien(2, "minh", "nv02", "khoi", "khoi", 0));
        this.ds.add(new NhanVien(3, "thao", "nv03", "12", "12", 0));
    }

    public List<NhanVien> findAll() {
        return this.ds;
    }

    public NhanVien findById(int id) {
        for (int i = 0; i < this.ds.size(); i++) {
            NhanVien nv = this.ds.get(i);
            if (nv.getId() == id) {
                return nv;
            }
        }
        return null;
    }

    public void create(NhanVien nv) {
        this.ds.add(nv);
    }
    public void update(NhanVien nv){
        for (int i = 0; i < this.ds.size(); i++) {
            NhanVien n = this.ds.get(i);
            if(n.getId() == nv.getId()){
                this.ds.set(i,nv);
            }
        }
    }
    public void delete(int id){
        for (int i = 0; i < this.ds.size(); i++) {
            NhanVien n = this.ds.get(i);
            if(n.getId() == id){
                this.ds.remove(i);
            }
        }
    }
}
