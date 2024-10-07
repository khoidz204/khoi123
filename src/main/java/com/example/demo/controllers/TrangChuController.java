package com.example.demo.controllers;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TrangChuController {
    @GetMapping("/trang-chu")
    public String trangChu(HttpSession session, Model model) {
       model.addAttribute("user", session.getAttribute("user"));
        return "trang_chu/index";
    }
}
