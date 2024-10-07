package com.example.demo.controllers;

import com.example.demo.entities.MauSac;
import com.example.demo.entities.User;
import com.example.demo.repository.asm1.UserRepository;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {

    private UserRepository userRepository = new UserRepository();
    public List<User> taikh = new ArrayList<>();

    public UserController() {
        taikh.add(new User(1, "khoi123", "1", 1));
        taikh.add(new User(2, "1", "1", 1));
        taikh.add(new User(2, "a", "a", 0));
    }

    @PostMapping("login/formdn")
    public String formdangnhap() {
        return "user/formdn";
    }

    @GetMapping("login/formdn")
    public String formdangnhapG() {
        return "user/formdn";
    }

    @GetMapping("login/formdk")
    public String formdangky() {
        return "user/formdk";
    }

    @PostMapping("login/dn")
    public String dangnhap(HttpSession ses, Model model, @RequestParam(required = false, value = "usern") String usern, @RequestParam(required = false, value = "passw") String passw) {
        if (taikh.size() < 1) {
            model.addAttribute("er", "Chưa có tài khoản nào");
            return "user/formdn";
        } else {
            for (User user : taikh) {
                if (usern.equals(user.getTk()) && passw.equals(user.getMk())) {
                    ses.setAttribute("tentk", usern);
                    ses.setAttribute("quyentk", user.getPq());
                    model.addAttribute("user", usern);
                    model.addAttribute("quyen", user.getPq());
                    return "/trang_chu/index";
                }
            }
        }
        model.addAttribute("er", "Tài khoản không đúng");
        return "user/formdn";
    }

    @PostMapping("login/dk")
    public String dangky(@RequestParam("usern") String usern, @RequestParam(required = false, value = "passw") String passw, @RequestParam(required = false, value = "quyen") int quyen, Model model
    ) {

        for (User user : taikh) {
            if (usern.equals(user.getTk())) {
                model.addAttribute("er", "Tài khoản đã tồn tại");
                return "user/formdk";
            }
        }
        taikh.add(new User(null, usern, passw, quyen));
        return "user/formdn";
    }
}
