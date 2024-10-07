package com.example.demo.controllers;

import com.example.demo.entities.NhanVien;
import com.example.demo.repository.asm2.NhanVienRepository;
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
@RequestMapping("nhan-vien")
public class NhanVienController {
    @Autowired
    private NhanVienRepository nvRepo;

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
        Page<NhanVien> ds = this.nvRepo.findByTenLike(s, p);
        model.addAttribute("data", ds);
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", ds.getTotalPages());
        return "nhan_vien/index";
    }

    @GetMapping("create")
    public String create(HttpSession ses) {
        Integer quyen = (Integer) ses.getAttribute("quyentk");
        if (quyen == null || quyen != 0 && quyen != 1) {
            return "redirect:/trang-chu?error=phai dang nhap";
        }
        return "nhan_vien/create";
    }

    @PostMapping("store")
    public String store(
            Model model,
            @Valid NhanVien nv,
            BindingResult vlResult
    ) {
        if (vlResult.hasErrors()) {
            List<FieldError> listError = vlResult.getFieldErrors();
            Map<String, String> errors = new HashMap<>();

            for (FieldError fe : listError) {
                errors.put(fe.getField(), fe.getDefaultMessage());
            }
            model.addAttribute("errors", errors);
            model.addAttribute("data", nv);
            return "/nhan_vien/create";
        }
        this.nvRepo.save(nv);
        return "redirect:/nhan-vien/index";
    }

    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model, HttpSession ses) {
        Integer quyen = (Integer) ses.getAttribute("quyentk");
        if (quyen == null || quyen != 0 && quyen != 1) {
            return "redirect:/trang-chu?error=phai dang nhap";
        }
        NhanVien nv = this.nvRepo.findById(id).get();
        model.addAttribute("data", nv);
        return "nhan_vien/edit";
    }

    @PostMapping("update/{id}")
    public String update(
            Model model,
            @Valid NhanVien nv,
            BindingResult vlResult
    ) {
        if (vlResult.hasErrors()) {
            List<FieldError> listError = vlResult.getFieldErrors();
            Map<String, String> errors = new HashMap<>();

            for (FieldError fe : listError) {
                errors.put(fe.getField(), fe.getDefaultMessage());
            }
            model.addAttribute("errors", errors);
            model.addAttribute("data", nv);
            return "/nhan_vien/edit";
        }
        this.nvRepo.save(nv);
        return "redirect:/nhan-vien/index";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        this.nvRepo.deleteById(id);
        return "redirect:/nhan-vien/index";
    }
}
