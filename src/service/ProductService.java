package service;

import entity.Product;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import repository.ProductRepository;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public List<Product> listProduct() {
        return productRepository.findAll();
    }

    public Product getProductByName(String name){
        return productRepository.findProductByName(name);
    }

    public void createProduct(Product product) { productRepository.createProduct(product); }

    public void deleteProduct(Long id){
        productRepository.deleteById(id);
    }
}
