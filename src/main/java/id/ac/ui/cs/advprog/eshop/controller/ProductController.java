package id.ac.ui.cs.advprog.eshop.controller;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    private final ProductService service;

    @Autowired
    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping("/create")
    public String createProductPage(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "CreateProduct";
    }

    @PostMapping("/create")
    public String createProductPost(@ModelAttribute Product product, Model model) {
        service.create(product);
        return "redirect:list";
    }

    @GetMapping("/list")
    public String productListPage(Model model) {
        List<Product> allProducts = service.findAll();
        model.addAttribute("products", allProducts);
        return "ProductList";
    }

    @GetMapping("/edit/{id}")
    public String editProductPage(@PathVariable("id") String id, Model model) {
        Product product = service.findById(Integer.parseInt(id));
        model.addAttribute("product", product);
        return "EditProduct";
    }

    @PutMapping("/edit")
    public String editProductPut(@ModelAttribute Product product, Model model) {
        Product currentProduct = service.findById(Integer.parseInt(product.getProductId()));
        service.edit(currentProduct, product);
        return "redirect:list";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") String id, Model model) {
        Product product = service.findById(Integer.parseInt(id));
        service.delete(product);
        return "redirect:../list";
    }
}
