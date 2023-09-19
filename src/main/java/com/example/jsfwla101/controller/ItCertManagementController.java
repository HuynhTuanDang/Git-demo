package com.example.jsfwla101.controller;

import com.example.jsfwla101.entity.Category;
import com.example.jsfwla101.entity.Cert;
import com.example.jsfwla101.service.CategoryService;
import com.example.jsfwla101.service.CertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/itCertManagement")
public class ItCertManagementController {

    @Autowired
    private CategoryService categoryService;
    @Autowired
    private CertService certService;


    @GetMapping("/show")
    public String showList(Model model, @ModelAttribute("id") String certId, BindResult bindResult) {
            Cert cert=new Cert();
            Cert cert1=new Cert();
            String certIdView="";
            String certName="";
        System.out.println("cert ID = " +certId);
            if (certId.length()>0) {
                System.out.println("certID ! = null");
                cert = certService.getById(certId);
            }
        System.out.println("ID = " + certIdView);
        System.out.println("Name = " + certName);
            List<Category> categories = categoryService.findAll();
            List<Cert> certs = certService.findAll();
            model.addAttribute("categories", categories);
            model.addAttribute("certs", certs);
            model.addAttribute("cert", cert);
            return "add_certView";
    }

    @PostMapping("/add")
    public String addCert(
            @ModelAttribute("cert") Cert cert,
            @RequestParam("selectedCategoryId") Long categoryId,
            Model model
             ){
        Category category=categoryService.getById(categoryId);
        List<Cert> certList=category.getCerts();
        certList.add(cert);
        category.setCerts(certList);
        cert.setCategory(category);
        categoryService.save(category);
//        certService.save(cert);
        return "redirect:/itCertManagement/show";
    }

    @RequestMapping("/delete")
    public String removeCert(@ModelAttribute("id") String certId){
        certService.deleteById(certId);
        return "redirect:/itCertManagement/show";
    }


}
