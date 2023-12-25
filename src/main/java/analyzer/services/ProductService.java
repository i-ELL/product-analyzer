package analyzer.services;

import java.util.List;

import analyzer.domain.models.Product;

public interface ProductService {

    boolean addProduct(Product product);

    List<Product> findAll();

    Product save(Product product);
}
