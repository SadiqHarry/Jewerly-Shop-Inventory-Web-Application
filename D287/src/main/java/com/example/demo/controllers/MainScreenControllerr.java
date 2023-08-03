package com.example.demo.controllers;

import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.repositories.PartRepository;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.service.PartService;
import com.example.demo.service.ProductService;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

/**
 *
 *
 *
 *
 */

@Controller
public class MainScreenControllerr {
   // private final PartRepository partRepository;
   private final ProductRepository productRepository;

    private PartService partService;
    private ProductService productService;
    private List<Part> theParts;
    private List<Product> theProducts;

 /*   public MainScreenControllerr(PartRepository partRepository, ProductRepository productRepository) {
        this.partRepository = partRepository;
        this.productRepository = productRepository;
    }*/

    public MainScreenControllerr(PartService partService,ProductService productService, ProductRepository productRepository){
        this.partService=partService;
        this.productService=productService;
        this.productRepository = productRepository;
    }
    @GetMapping("/mainscreen")
    public String listPartsandProducts(Model theModel, @Param("partkeyword") String partkeyword, @Param("productkeyword") String productkeyword){
        //add to the sprig model
        List<Part> partList=partService.listAll(partkeyword);
        theModel.addAttribute("parts",partList);
        theModel.addAttribute("partkeyword",partkeyword);
    //    theModel.addAttribute("products",productService.findAll());
        List<Product> productList=productService.listAll(productkeyword);
        theModel.addAttribute("products", productList);
        theModel.addAttribute("productkeyword",productkeyword);
        return "mainscreen";
    }
    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @RequestMapping("/buyNow")
    public String buyNow(@RequestParam("productID") int theId, RedirectAttributes redirectAttributes) {

        // Retrieve the product from the service
        Product theProduct = productService.findById(theId);

        // Check if the product was found
        if (theProduct == null) {
            throw new RuntimeException("Did not find product id - " + theId);
        }

        // Print inventory and name before decrement
        System.out.println("Product name: " + theProduct.getName());
        System.out.println("Inventory before decrement: " + theProduct.getInv());

        // Decrement the product's inventory
        int currentInventory = theProduct.getInv();
        if (currentInventory > 0) {
            theProduct.setInv(currentInventory - 1);
            // Save the product back to the service
            productService.save(theProduct);
            // Add success message to flash attributes
            redirectAttributes.addFlashAttribute("successMessage", "Purchase successful!");
        } else {
            // Handle the case where the product is out of stock
            // Add failure message to flash attributes
            redirectAttributes.addFlashAttribute("failureMessage", "Product is out of stock");
        }

        // Print inventory and name after decrement
        System.out.println("Product name: " + theProduct.getName());
        System.out.println("Inventory after decrement: " + theProduct.getInv());

        // Redirect back to the product list
        return "redirect:/mainscreen";
    }

}









