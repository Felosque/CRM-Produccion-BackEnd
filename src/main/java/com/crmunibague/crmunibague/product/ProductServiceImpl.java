package com.crmunibague.crmunibague.product;

import com.crmunibague.crmunibague.serviceexeption.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    private ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository)
    {
        this.productRepository = productRepository;
    }


    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAll() {
        return this.productRepository.findAll();
    }

    @Override
    public Product getByID(int id) {
        return this.productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("El producto de ID:" + id + " no existe."));
    }

    @Override
    public Product update(int id, Product product) {
        Product productToUpdate = getByID(id);
        productToUpdate.setName(product.getName());
        return save(productToUpdate);
    }

    @Override
    public void delete(int id) {
        Product productToDelete = getByID(id);
        this.productRepository.delete(productToDelete);
    }
}
