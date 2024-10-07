package com.example.demo.repository.asm1;

import com.example.demo.entities.HoaDonCT;
import com.example.demo.entities.KhachHang;

import java.util.ArrayList;
import java.util.List;

public class KhachHangRepository {
    private ArrayList<KhachHang> ds;
    public KhachHangRepository(){
        this.ds = new ArrayList<>();
        this.ds.add(new KhachHang(1,"kh01","Anh Khoi","0977276646",1));
        this.ds.add(new KhachHang(2,"kh02","Anh Minh","0998765435",0));
        this.ds.add(new KhachHang(3,"kh03","Nguyen Khoi","0987234562",0));
        this.ds.add(new KhachHang(3,"kh03","Nguyen Khoi","0987234562",0));
        this.ds.add(new KhachHang(3,"kh03","Nguyen Khoi","0987234562",0));
        this.ds.add(new KhachHang(3,"kh03","Nguyen Khoi","0987234562",0));
        this.ds.add(new KhachHang(3,"kh03","Nguyen Khoi","0987234562",0));
        this.ds.add(new KhachHang(3,"kh03","Nguyen Khoi","0987234562",0));
        this.ds.add(new KhachHang(3,"kh03","Nguyen Khoi","0987234562",0));
        this.ds.add(new KhachHang(3,"kh03","Nguyen Khoi","0987234562",0));
        this.ds.add(new KhachHang(3,"kh03","Nguyen Khoi","0987234562",0));
        this.ds.add(new KhachHang(3,"kh03","Nguyen Khoi","0987234562",0));
        this.ds.add(new KhachHang(3,"kh03","Nguyen Khoi","0987234562",0));
        this.ds.add(new KhachHang(3,"kh03","Nguyen Khoi","0987234562",0));
        this.ds.add(new KhachHang(3,"kh03","Nguyen Khoi","0987234562",0));
    }
    public List<KhachHang> findAll(){
        return this.ds;
    }

    public KhachHang findById(int id){
        for (int i = 0; i < this.ds.size(); i++) {
            KhachHang k = this.ds.get(i);
            if(k.getId() == id){
                return k;
            }
        }
        return null;
    }

    public void create(KhachHang kh){
        this.ds.add(kh);
    }
    public void update(KhachHang kh){
        for (int i = 0; i < this.ds.size(); i++) {
            KhachHang k = this.ds.get(i);
            if (k.getId() == kh.getId()){
                this.ds.set(i,kh);
            }
        }
    }public void delete(int id){
        for (int i = 0; i < this.ds.size(); i++) {
            KhachHang k = this.ds.get(i);
            if (k.getId() == id){
                this.ds.remove(i);
            }
        }
    }
    public List<KhachHang> findAllPage(int page, int limit) {
        List<KhachHang> hoaDons= new ArrayList<>();
        int offset= (page-1)*limit; // trang thu nhat se chay tu 0, trang thu 2 chay tu 10
        for(int i= offset==0?offset:offset+1;i<findAll().size();i++){
            if(hoaDons.size()<=limit)
                hoaDons.add(findAll().get(i));
            else break;
        }
        return hoaDons;
    }
    public int totalpage(int limit){
        return  ds.size()/limit;
    }
}
