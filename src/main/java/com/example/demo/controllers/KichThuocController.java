package com.example.demo.controllers;

import com.example.demo.entities.KichThuoc;
import com.example.demo.entities.MauSac;
import com.example.demo.entities.NhanVien;
import com.example.demo.entities.SanPham;
import com.example.demo.repository.asm2.KichThuocRepository;
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
@RequestMapping("kich-thuoc")
public class KichThuocController {
    @Autowired
    private KichThuocRepository ktRepo;

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
        Page<KichThuoc> ds = this.ktRepo.findByTenLike(s, p);
        model.addAttribute("dataKT", ds);
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", ds.getTotalPages());
        return "kich_thuoc/index";
    }

    @GetMapping("create")
    public String create(HttpSession ses) {

        return "kich_thuoc/create";
    }

    @PostMapping("store")
    public String store(
            Model model,
            @Valid KichThuoc kt,
            BindingResult vlResult
    ) {
        if (vlResult.hasErrors()) {
            List<FieldError> listError = vlResult.getFieldErrors();
            Map<String, String> errors = new HashMap<>();

            for (FieldError fe : listError) {
                errors.put(fe.getField(), fe.getDefaultMessage());
            }
            model.addAttribute("errors", errors);
            model.addAttribute("dataKT", kt);
            return "/kich_thuoc/create";
        }
        this.ktRepo.save(kt);
        return "redirect:/kich-thuoc/index";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        this.ktRepo.deleteById(id);
        return "redirect:/kich-thuoc/index";
    }

    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model, HttpSession ses) {
        Integer quyen = (Integer) ses.getAttribute("quyentk");
        if (quyen == null || quyen != 0 && quyen != 1) {
            return "redirect:/trang-chu?error=phai dang nhap";
        }
        KichThuoc kt = this.ktRepo.findById(id).get();
        model.addAttribute("dataKT", kt);
        return "/kich_thuoc/edit";
    }

    @PostMapping("update/{id}")
    public String update(
            Model model,
            @Valid KichThuoc kt,
            BindingResult vlResult
    ) {
        if (vlResult.hasErrors()) {
            List<FieldError> listError = vlResult.getFieldErrors();
            Map<String, String> errors = new HashMap<>();

            for (FieldError fe : listError) {
                errors.put(fe.getField(), fe.getDefaultMessage());
            }
            model.addAttribute("errors", errors);
            model.addAttribute("dataKT", kt);
            return "/kich_thuoc/edit";
        }
        this.ktRepo.save(kt);
        return "redirect:/kich-thuoc/index";
    }

}
