package repository;

import entity.Product;

@Repository
public class ProductRepository extends JpaRepository<Product, Long> {
}
