package com.crmunibague.crmunibague.productiondetails;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin( origins = "http://localhost:4200", maxAge = 3600)
@RequestMapping("scm-unibague/ProductionDetails")
@RestController
public class ProductionDetailsRESTController {

    private ProductionDetailsService productionDetailsService;

    @Autowired
    public ProductionDetailsRESTController(ProductionDetailsService productionDetailsService) {
        this.productionDetailsService = productionDetailsService;
    }

    @PostMapping
    public ResponseEntity<ProductionDetails> save(@RequestBody ProductionDetails entity){
        return ResponseEntity.ok().body(this.productionDetailsService.save(entity));
    }

    @GetMapping
    public ResponseEntity<List<ProductionDetails>> getAll(){
        return ResponseEntity.ok().body(this.productionDetailsService.getAll());
    }

    /*
    @PostMapping(path = "/get")
    public ResponseEntity<ProductionDetails> getById(@RequestBody ProductionDetailsPk id){
        return ResponseEntity.ok().body(this.productionDetailsService.getById(id));
    }
*/
    @PostMapping(path = "/delete")
    public Map<String, Boolean> delete(@RequestBody  ProductionDetails id){
        this.productionDetailsService.delete(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Deleted", Boolean.TRUE);
        return response;
    }

    @PutMapping
    public ResponseEntity<ProductionDetails> update(@RequestBody ProductionDetails entity){
        return ResponseEntity.ok().body(this.productionDetailsService.update(entity));
    }
}
