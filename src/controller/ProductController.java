package controller;

import org.springframework.beans.factory.annotation.Autowired;
import service.ProductService;

@RestController
@RequestMapping("/api/v1/")
public class ProductController {
    @Autowired
    private ProductService productService;
}
