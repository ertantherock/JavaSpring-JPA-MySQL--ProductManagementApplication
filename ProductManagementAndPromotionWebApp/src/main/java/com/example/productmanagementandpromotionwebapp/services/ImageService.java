package com.example.productmanagementandpromotionwebapp.services;

import com.example.productmanagementandpromotionwebapp.entities.ProductImage;
import com.example.productmanagementandpromotionwebapp.repositories.ProductImageRepository;
import com.example.productmanagementandpromotionwebapp.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ImageService {

    final ProductImageRepository productImageRepository;
    final ProductRepository productRepository;
    final HttpServletRequest req;

    public ProductImage addImage(ProductImage productImage){

        productImageRepository.save(productImage);
        return productImage;
    }

    public List<ProductImage> listImages(Long pid){
        return productImageRepository.findByPidEquals(pid);

    }

    public boolean imageDelete(String stPid, Long iid) {
        try {
            long pid = Long.parseLong(stPid);

            if (productRepository.existsByPidEqualsAndCidEquals(iid, pid)) {
                productRepository.deleteById(pid);
                return true;
            }
        } catch (IllegalArgumentException ex) {
            // Handle the case where stPid is not a valid number
            ex.printStackTrace();
        } catch (Exception ex) {
            // Handle any other exceptions that might occur
            ex.printStackTrace();
        }

        return false;
    }
}
