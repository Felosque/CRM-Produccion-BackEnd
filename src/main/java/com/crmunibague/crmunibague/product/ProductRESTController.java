package com.crmunibague.crmunibague.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200",maxAge = 3600)
@RequestMapping("scm-unibague/Product")
@RestController
public class ProductRESTController {


    private ProductService productService;

    @Autowired
    public ProductRESTController(ProductService productService)
    {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<Product> save(@RequestBody Product product)
    {
        return ResponseEntity.ok().body(productService.save(product));
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAll()
    {
        return ResponseEntity.ok().body(productService.getAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Product> getByID(@PathVariable("id") int id)
    {
        return ResponseEntity.ok().body(this.productService.getByID(id));
    }

    @DeleteMapping(path = "/{id}")
    public Map<String, Boolean> delete(@PathVariable("id") int id)
    {
        this.productService.delete(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Delete", Boolean.TRUE);
        return response;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@PathVariable("id") int id, @RequestBody Product product)
    {
        return ResponseEntity.ok().body(this.productService.update(id, product));
    }

    @GetMapping(path = "/TotalProductos")
    public Integer getTotalProductos()
    {
        return this.productService.getAll().size();
    }

}
