package com.example.demo.controllers;

import com.example.demo.entities.NhanVien;
import com.example.demo.entities.SanPham;
import com.example.demo.repository.asm2.SanPhamRepository;
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
@RequestMapping("san-pham")
public class SanPhamController {
    @Autowired
    private SanPhamRepository spRepo;

    @GetMapping("create")
    public String create(HttpSession ses) {
        Integer quyen = (Integer) ses.getAttribute("quyentk");
        if (quyen == null || quyen != 0 && quyen != 1) {
            return "redirect:/trang-chu?error=phai dang nhap";
        }
        return "/san_pham/create";
    }

    @GetMapping("index")
    public String index(
            Model model,
            HttpSession ses,
            @RequestParam(name = "page", defaultValue = "1") int pageNo,
            @RequestParam(name = "limit", defaultValue = "10") int pageSize,
            @RequestParam(name = "keyword", defaultValue = "") String keyword
            ) {
        Integer quyen = (Integer) ses.getAttribute("quyentk");
        if (quyen == null || quyen != 0 && quyen != 1) {
            return "redirect:/trang-chu?error=phai dang nhap";
        }
        PageRequest p = PageRequest.of(pageNo - 1, pageSize);
        String s = "%" + keyword + "%";
        Page<SanPham> ds = this.spRepo.findByTenLike(s, p);
        model.addAttribute("data", ds);
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", ds.getTotalPages());
        return "/san_pham/index";
    }

    @PostMapping("store")
    public String store(
            Model model,
            @Valid SanPham sp,
            BindingResult vlResult
    ) {
        if (vlResult.hasErrors()) {
            List<FieldError> listError = vlResult.getFieldErrors();
            Map<String, String> errors = new HashMap<>();

            for (FieldError fe : listError) {
                errors.put(fe.getField(), fe.getDefaultMessage());
            }
            model.addAttribute("errors", errors);
            model.addAttribute("data", sp);
            return "/san_pham/create";
        }
        this.spRepo.save(sp);
        return "redirect:/san-pham/index";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        this.spRepo.deleteById(id);
        return "redirect:/san-pham/index";
    }

    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model,HttpSession ses) {
        Integer quyen = (Integer) ses.getAttribute("quyentk");
        if (quyen == null || quyen != 0 && quyen != 1) {
            return "redirect:/trang-chu?error=phai dang nhap";
        }
        SanPham sp = this.spRepo.findById(id).get();
        model.addAttribute("data", sp);
        return "/san_pham/edit";
    }

    @PostMapping("update/{id}")
    public String update(
            Model model,
            @Valid SanPham sp,
            BindingResult vlResult
    ) {
        if (vlResult.hasErrors()) {
            List<FieldError> listError = vlResult.getFieldErrors();
            Map<String, String> errors = new HashMap<>();

            for (FieldError fe : listError) {
                errors.put(fe.getField(), fe.getDefaultMessage());
            }
            model.addAttribute("errors", errors);
            model.addAttribute("data", sp);
            return "/san_pham/edit";
        }
        this.spRepo.save(sp);
        return "redirect:/san-pham/index";
    }
}
