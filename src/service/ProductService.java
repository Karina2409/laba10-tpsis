package service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import repository.ProductRepository;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
}
