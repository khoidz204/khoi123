package com.example.demo.repository.asm1;


import com.example.demo.entities.HoaDonCT;
import com.example.demo.entities.KichThuoc;

import java.util.ArrayList;
import java.util.List;

public class KichThuocRepository {
    private ArrayList<KichThuoc> ds;

    public KichThuocRepository() {
        this.ds = new ArrayList<>();
        this.ds.add(new KichThuoc(1, "kt01", "ngan", 1));
        this.ds.add(new KichThuoc(2, "kt02", "dai", 0));
        this.ds.add(new KichThuoc(3, "kt03", "vua", 0));
        this.ds.add(new KichThuoc(3, "kt03", "vua", 0));
        this.ds.add(new KichThuoc(3, "kt03", "vua", 0));
        this.ds.add(new KichThuoc(3, "kt03", "vua", 0));
        this.ds.add(new KichThuoc(3, "kt03", "vua", 0));
        this.ds.add(new KichThuoc(3, "kt03", "vua", 0));
        this.ds.add(new KichThuoc(3, "kt03", "vua", 0));
        this.ds.add(new KichThuoc(3, "kt03", "vua", 0));
        this.ds.add(new KichThuoc(3, "kt03", "vua", 0));
        this.ds.add(new KichThuoc(3, "kt03", "vua", 0));
        this.ds.add(new KichThuoc(3, "kt03", "vua", 0));
        this.ds.add(new KichThuoc(3, "kt03", "vua", 0));
        this.ds.add(new KichThuoc(3, "kt03", "vua", 0));
        this.ds.add(new KichThuoc(3, "kt03", "vua", 0));
    }

    public List<KichThuoc> findAll() {
        return this.ds;
    }

    public KichThuoc findById(int id) {
        for (int i = 0; i < this.ds.size(); i++) {
            KichThuoc k = this.ds.get(i);
            if (k.getId() == id) {
                return k;
            }
        }
        return null;
    }

    public void create(KichThuoc kt) {
        this.ds.add(kt);
    }

    public void update(KichThuoc kt) {
        for (int i = 0; i < this.ds.size(); i++) {
            KichThuoc m = this.ds.get(i);
            if (m.getId() == kt.getId()) {
                this.ds.set(i, kt);
            }
        }
    }

    public void delete(int id) {
        for (int i = 0; i < this.ds.size(); i++) {
            KichThuoc m = this.ds.get(i);
            if (m.getId() == id) {
                this.ds.remove(i);
            }
        }
    }

    public List<KichThuoc> findAllPage(int page, int limit) {
        List<KichThuoc> hoaDons = new ArrayList<>();
        int offset = (page - 1) * limit;
        for (int i = offset == 0 ? offset : offset + 1; i < findAll().size(); i++) {
            if (hoaDons.size() <= limit)
                hoaDons.add(findAll().get(i));
            else break;
        }
        return hoaDons;
    }

    public int totalpage(int limit) {
        return ds.size() / limit;
    }
}
