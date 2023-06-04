package com.example.productmanagementandpromotionwebapp.controllers;

import com.example.productmanagementandpromotionwebapp.entities.Product;
import com.example.productmanagementandpromotionwebapp.services.SearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
@RequiredArgsConstructor
public class SearchController {

    final SearchService searchService;

    @GetMapping("/searchProduct")
    public String searchProduct(@RequestParam(defaultValue = "") String title,String detail, Model model){

        List<Product> ls = searchService.searchList(title,detail);
        model.addAttribute("products",ls);
        model.addAttribute("title", title);



        return "searchPage";
    }
}
