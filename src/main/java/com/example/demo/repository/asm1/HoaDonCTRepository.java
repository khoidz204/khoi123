package com.example.demo.repository.asm1;


import com.example.demo.entities.HoaDon;
import com.example.demo.entities.HoaDonCT;

import java.util.ArrayList;
import java.util.List;

public class HoaDonCTRepository {
    private ArrayList<HoaDonCT> ds;

    public HoaDonCTRepository() {
        this.ds = new ArrayList<>();
        this.ds.add(new HoaDonCT(1, 1, 1, 20, 33333, 1));
        this.ds.add(new HoaDonCT(2, 2, 2, 60, 99999, 0));
        this.ds.add(new HoaDonCT(3, 3, 3, 3, 10000, 1));
        this.ds.add(new HoaDonCT(4, 4, 4, 78, 10000, 1));
        this.ds.add(new HoaDonCT(5, 5, 5, 67, 10000, 0));
        this.ds.add(new HoaDonCT(6, 6, 6, 6, 20000, 1));
        this.ds.add(new HoaDonCT(7, 7, 7, 54, 10000, 0));
        this.ds.add(new HoaDonCT(8, 8, 8, 323, 10000, 1));
        this.ds.add(new HoaDonCT(9, 9, 9, 12, 10000, 0));
        this.ds.add(new HoaDonCT(10, 10, 10, 2, 10000, 1));
        this.ds.add(new HoaDonCT(11, 11, 11, 22, 10000, 0));
        this.ds.add(new HoaDonCT(12, 12, 12, 23, 10000, 1));
        this.ds.add(new HoaDonCT(13, 13, 13, 7, 10000, 0));
        this.ds.add(new HoaDonCT(14, 14, 14, 99, 10000, 1));
    }

    public List<HoaDonCT> findAll() {
        return this.ds;
    }

    public HoaDonCT findById(int id) {
        for (int i = 0; i < this.ds.size(); i++) {
            HoaDonCT k = this.ds.get(i);
            if (k.getId() == id) {
                return k;
            }
        }
        return null;
    }

    public void update(HoaDonCT kh) {
        for (int i = 0; i < this.ds.size(); i++) {
            HoaDonCT k = this.ds.get(i);
            if (k.getId() == kh.getId()) {
                this.ds.set(i, kh);
            }
        }
    }
    public List<HoaDonCT> findAllPage(int page, int limit) {
        List<HoaDonCT> hoaDons= new ArrayList<>();
        int offset= (page-1)*limit; // trang thu nhat se chay tu 0, trang thu 2 chay tu 10
        for(int i= offset==0?offset:offset+1;i<findAll().size();i++){
            if(hoaDons.size()<=limit)
                hoaDons.add(findAll().get(i));
            else break;
        }
        return hoaDons;
    }
    public void create(HoaDonCT hd) {
        this.ds.add(hd);
    }

    public int totalpage(int limit){
        return  ds.size()/limit;
    }
    public void deleteById(int id) {
        for (int i = 0; i < this.ds.size(); i++) {
            HoaDonCT hd = this.ds.get(i);
            if (hd.getId().equals(id)) {
                this.ds.remove(i);
                break;
            }
        }
    }
}
