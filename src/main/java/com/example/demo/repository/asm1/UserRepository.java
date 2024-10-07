package com.example.demo.repository.asm1;

import com.example.demo.entities.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    private List<User> ds = new ArrayList<>();

    public UserRepository(){
        ds = new ArrayList<>();
        ds.add(new User(1,"khoi123","1",1));
        ds.add(new User(2,"1","1",1));
        ds.add(new User(2,"a","a",0));
    }
    public void create(User us ){
        us.setId(ds.size()+1);
        ds.add(us);
    }
    public List<User> getAll(){
        return ds;
    }
}
