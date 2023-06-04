package com.example.productmanagementandpromotionwebapp.services;

import com.example.productmanagementandpromotionwebapp.entities.Product;
import com.example.productmanagementandpromotionwebapp.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    final ProductRepository productRepository;
    final HttpServletRequest req;

    public Page<Product> allProduct(int page){
        Long cid = (Long) req.getSession().getAttribute("cid");
        Pageable pageable = PageRequest.of(page,10);
        Page<Product> productPage = productRepository.findByCidEqualsAllIgnoreCaseOrderByPidDesc(cid,pageable);
        // productPage.getContent(); // list<product>
        // productPage.getTotalElements(); toplam eleman sayısı
        // productPage.getTotalPages(); // toplam sayfa sayısı
        // productPage.getNumberOfElements(); //kaçıncı sayfada
        //productPage.getPageable().getPageNumber();
        return productPage;
    }

    public Product save(Product product){
        Long cid = (Long) req.getSession().getAttribute("cid");
        product.setCid(cid);
        return productRepository.save(product);
    }

    public boolean productDelete(String stPid){
        try{
            Long pid = Long.parseLong(stPid);
            Long cid = (Long) req.getSession().getAttribute("cid");
            boolean status = productRepository.existsByPidEqualsAndCidEquals(pid,cid);

            if (status) {
                productRepository.deleteById(pid);
                return true;
            }


        }catch (Exception ex){
            System.err.println("Delete Error: "+ ex);

        }

        return false;
    }
    public Product getSingleProduct(Long pid){
        Optional<Product> optionalProduct = productRepository.findById(pid);
        if (optionalProduct.isPresent()) {
            return optionalProduct.get();
        }
        return null;
    }

    public boolean updateProduct(Product product){
        try {
            productRepository.saveAndFlush(product);
            return true;
        }catch (Exception ex){
            return false;
        }

    }




}
