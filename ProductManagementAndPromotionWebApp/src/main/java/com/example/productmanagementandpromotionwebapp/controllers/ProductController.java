package com.example.productmanagementandpromotionwebapp.controllers;

import com.example.productmanagementandpromotionwebapp.entities.Product;
import com.example.productmanagementandpromotionwebapp.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequiredArgsConstructor
public class ProductController {

    final ProductService productService;

    private Long updateId = 0l;

    @GetMapping("/")
    public String allProducts(Model model, @RequestParam(defaultValue = "0") int page){

        model.addAttribute("products", productService.allProduct(page));
        updateId = 0l;

        return "productHome";
    }

    @GetMapping("/productAddPage")
    public String productAddPage(){

        return "productAdd";
    }

    @PostMapping("/productSave")
    public String productSave(Product product){

        productService.save(product);

        return "redirect:/";
    }

    @GetMapping("/productDelete/{stPid}")
    public String productDelete(@PathVariable String stPid){
        boolean status = productService.productDelete(stPid);
        return "redirect:/";
    }

    @GetMapping("/{pid}")
    public String dashboardUpdate(Model model,@PathVariable Long pid,@RequestParam(defaultValue = "0") int page){
        updateId = pid;
        model.addAttribute("products",productService.allProduct(page));
        model.addAttribute("product",productService.getSingleProduct(pid));
        return "productUpdate";


    }

    @PostMapping("/productUpdate")
    public String productUpdate(Product product){
        product.setPid(updateId);
        productService.updateProduct(product);
        return "redirect:/";
    }



}
