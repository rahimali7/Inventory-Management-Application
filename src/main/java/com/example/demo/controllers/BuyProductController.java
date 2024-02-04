package com.example.demo.controllers;



import com.example.demo.domain.Product;
import com.example.demo.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;


@Controller
public class BuyProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/buyProduct")
    public String buyProduct(@RequestParam("productID") int theId, Model model) {
        Long theidl = (long) theId;

        Optional<Product> result = productRepository.findById(theidl);

        Product theproduct = null;

        if (result.isPresent()) {
            theproduct = result.get();
        }
        assert theproduct != null;
        if (theproduct.getInv() > 0) {
            theproduct.setInv(theproduct.getInv() - 1);
            productRepository.save(theproduct);
            return displayPurchasePage();
        }
        else {
            return errorPurchasePage();
        }

    }

    @GetMapping("/displayPurchasePage")
    public String displayPurchasePage() {
        return "confirmationbuyproduct";
    }

    @GetMapping("/errorPurchasePage")
    public String errorPurchasePage() {
        return "producterrornavigator";
    }

}
