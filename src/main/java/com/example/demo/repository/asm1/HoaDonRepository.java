package com.example.demo.repository.asm1;

import com.example.demo.entities.HoaDon;

import java.util.ArrayList;
import java.util.List;

public class HoaDonRepository {
    private ArrayList<HoaDon> ds;

//    public HoaDonRepository() {
//        this.ds = new ArrayList<>();
//        this.ds.add(new HoaDon(1, 1, 1, "2023-03-19", 1));
//        this.ds.add(new HoaDon(2, 2, 2, "2024-04-09", 1));
//        this.ds.add(new HoaDon(3, 3, 3, "2022-03-16", 0));
//        this.ds.add(new HoaDon(4, 4, 4, "2023-07-24", 1));
//        this.ds.add(new HoaDon(5, 5, 5, "2021-04-09", 0));
//        this.ds.add(new HoaDon(6, 6, 6, "2022-03-16", 1));
//        this.ds.add(new HoaDon(7, 7, 7, "2022-03-16", 0));
//        this.ds.add(new HoaDon(8, 8, 8, "2022-03-16", 1));
//        this.ds.add(new HoaDon(9, 9, 9, "2022-03-16", 0));
//        this.ds.add(new HoaDon(10, 10, 10, "2022-03-16", 1));
//        this.ds.add(new HoaDon(11, 11, 11, "2022-03-16", 0));
//        this.ds.add(new HoaDon(12, 12, 12, "2022-03-16", 1));
//        this.ds.add(new HoaDon(13, 13, 13, "2022-03-16", 0));
//        this.ds.add(new HoaDon(14, 14, 14, "2022-03-16", 1));
//        this.ds.add(new HoaDon(15, 15, 15, "2022-03-16", 0));
//    }

    public List<HoaDon> findAll() {
        return this.ds;
    }
    public List<HoaDon> findAllPage(int page,int limit) {
        List<HoaDon> hoaDons= new ArrayList<>();
        int offset= (page-1)*limit; // trang thu nhat se chay tu 0, trang thu 2 chay tu 10
        for(int i= offset==0?offset:offset+1;i<findAll().size();i++){
            if(hoaDons.size()<=limit)
                hoaDons.add(findAll().get(i));
            else break;
        }
        return hoaDons;
    }
    public void create(HoaDon hd) {
        this.ds.add(hd);
    }

    public int totalpage(int limit){
        return  ds.size()/limit;
    }
    public void deleteById(int id) {
        for (int i = 0; i < this.ds.size(); i++) {
            HoaDon hd = this.ds.get(i);
            if (hd.getId().equals(id)) {
                this.ds.remove(i);
                break;
            }
        }
    }

    public HoaDon findById(int id) {
        for (int i = 0; i < this.ds.size(); i++) {
            HoaDon k = this.ds.get(i);
            if (k.getId() == id) {
                return k;
            }
        }
        return null;
    }


    public void update(HoaDon kh) {
        for (int i = 0; i < this.ds.size(); i++) {
            HoaDon k = this.ds.get(i);
            if (k.getId() == kh.getId()) {
                this.ds.set(i, kh);
            }
        }
    }
}
