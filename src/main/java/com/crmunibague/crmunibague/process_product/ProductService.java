package com.crmunibague.crmunibague.process_product;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    public Product save(Product product);

    public List<Product> getAll();

    public Product getByID(int id);

    public Product update(int id, Product product);

    public void delete(int id);

}
