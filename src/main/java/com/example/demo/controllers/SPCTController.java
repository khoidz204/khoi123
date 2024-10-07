package com.example.demo.controllers;

import com.example.demo.entities.HoaDon;
import com.example.demo.entities.SPCT;
import com.example.demo.repository.asm2.KichThuocRepository;
import com.example.demo.repository.asm2.MauSacRepository;
import com.example.demo.repository.asm2.SPCTRepository;
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
@RequestMapping("spct")
public class SPCTController {
    @Autowired
    private SPCTRepository spctRepo;
    @Autowired
    private SanPhamRepository spRepo;
    @Autowired
    private MauSacRepository msRepo;
    @Autowired
    private KichThuocRepository ktRepo;

    @GetMapping("index")
    public String index(
            Model model,
            HttpSession ses,
            @RequestParam(name = "page", defaultValue = "1") int pageNo,
            @RequestParam(name = "limit", defaultValue = "10") int pageSize
//            @RequestParam(name = "spId", defaultValue = "-1") Integer spId
    ) {
        Integer quyen = (Integer) ses.getAttribute("quyentk");
        if (quyen == null || quyen != 0 && quyen != 1) {
            return "redirect:/trang-chu?error=phai dang nhap";
        }
        PageRequest p = PageRequest.of(pageNo - 1, pageSize);
        Page<SPCT> ds = this.spctRepo.findAll(p);
        model.addAttribute("data", ds);
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", ds.getTotalPages());
//        model.addAttribute("listSP", this.spRepo.findAll());
//        List<SPCT> dsSP = spId == -1 ? new ArrayList<>() : this.spctRepo.findBySPId(spId);
//        model.addAttribute("data",this.spctRepo.findAll());
        return "sp_ct/index";
    }

//    @GetMapping("create")
//    public String create(Model model, HttpSession ses, @RequestParam(name = "msId", defaultValue = "-1") Integer msId, @RequestParam(name = "ktId", defaultValue = "-1") Integer ktId) {
//        Integer quyen = (Integer) ses.getAttribute("quyentk");
//        if (quyen == null || quyen != 0 && quyen != 1) {
//            return "redirect:/trang-chu?error=phai dang nhap";
//        }
//        model.addAttribute("listMS", this.msRepo.findAll());
//        model.addAttribute("listKT", this.ktRepo.findAll());
//        List<SPCT> dsMS = msId == -1 ? new ArrayList<>() : this.spctRepo.findByMsId(msId);
//        List<SPCT> dsKT = ktId == -1 ? new ArrayList<>() : this.spctRepo.findByKtId(ktId);
//        model.addAttribute("dataMS", dsMS);
//        model.addAttribute("dataKT", dsKT);
//        return "sp_ct/create";
//    }
//
//    @PostMapping("store")
//    public String store(SPCT spct) {
//        this.spctRepo.create(spct);
//        return "redirect:/spct/index";
//    }
//
    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model, HttpSession ses) {
        Integer quyen = (Integer) ses.getAttribute("quyentk");
        if (quyen == null || quyen != 0 && quyen != 1) {
            return "redirect:/trang-chu?error=phai dang nhap";
        }
        SPCT ms = this.spctRepo.findById(id).get();
        model.addAttribute("data", ms);
        return "/sp_ct/edit";
    }

    @PostMapping("update/{id}")
    public String update(
            Model model,
            @Valid SPCT ms,
            BindingResult vlResult
    ) {
        if (vlResult.hasErrors()) {
            List<FieldError> listError = vlResult.getFieldErrors();
            Map<String, String> errors = new HashMap<>();

            for (FieldError fe : listError) {
                errors.put(fe.getField(), fe.getDefaultMessage());
            }
            model.addAttribute("errors", errors);
            model.addAttribute("data", ms);
            return "/sp_ct/edit";
        }
        this.spctRepo.save(ms);
        return "redirect:/spct/index";
    }
    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        this.spctRepo.deleteById(id);
        return "redirect:/spct/index";
    }
}
