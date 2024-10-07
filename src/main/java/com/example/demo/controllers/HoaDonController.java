package com.example.demo.controllers;

import com.example.demo.entities.HoaDon;
import com.example.demo.entities.MauSac;
import com.example.demo.repository.asm2.HoaDonRepository;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("hoa-don")
public class HoaDonController {
    @Autowired
    private HoaDonRepository hdRepo;

    @GetMapping("index")
    public String index(
            Model model,
            HttpSession ses,
            @RequestParam(name = "page", defaultValue = "1") int pageNo,
            @RequestParam(name = "limit", defaultValue = "10") int pageSize
    ) {
        Integer quyen = (Integer) ses.getAttribute("quyentk");
        if (quyen == null || quyen != 1) {
            return "redirect:/trang-chu?error=phai dang nhap";
        }
        PageRequest p = PageRequest.of(pageNo - 1, pageSize);
        Page<HoaDon> ds = this.hdRepo.findAll(p);
        model.addAttribute("data", ds);
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", ds.getTotalPages());
        return "hoa_don/index";
    }

    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model, HttpSession ses) {
        Integer quyen = (Integer) ses.getAttribute("quyentk");
        if (quyen == null || quyen != 0 && quyen != 1) {
            return "redirect:/trang-chu?error=phai dang nhap";
        }
        HoaDon sp = this.hdRepo.findById(id).get();
        model.addAttribute("data", sp);
        return "/hoa_don/edit";
    }

    @PostMapping("update/{id}")
    public String update(
            Model model,
            @Valid HoaDon kh,
            BindingResult vlResult
    ) {
        if (vlResult.hasErrors()) {
            List<FieldError> listError = vlResult.getFieldErrors();
            Map<String, String> errors = new HashMap<>();

            for (FieldError fe : listError) {
                errors.put(fe.getField(), fe.getDefaultMessage());
            }
            model.addAttribute("errors", errors);
            model.addAttribute("data", kh);
            return "/hoa_don/edit";
        }
        this.hdRepo.save(kh);
        return "redirect:/hoa-don/index";
    }
}
