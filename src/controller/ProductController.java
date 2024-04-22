package controller;

import entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import partner.ProductService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/product")
    public List<Product> getAllProduct(){
        return productService.listProduct();
    }

    @GetMapping("/product")
    public Product getProductByName(String name) {
        return productService.getProductByName(name);
    }

    @PostMapping("/product")
    public void addProduct(Product product){productService.createProduct(product);}

    @PostMapping("/product")
    public void deleteProduct(Long id){
        productService.deleteProduct(id);
    }

}
