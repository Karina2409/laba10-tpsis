package repository;

import entity.Product;

@Repository
public class ProductRepository extends JpaRepository<Product, Long> {

    Product findAll(String name);

    Product findProductByName(String name);

    void createProduct(Product product);

    void deleteById(Long id);

}
