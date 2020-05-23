package com.crmunibague.crmunibague.production;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("scm-unibague/Production")
@RestController
public class ProductionRESTController {

    private ProductionService productionService;

    @Autowired
    public ProductionRESTController(ProductionService productionService) {
        this.productionService = productionService;
    }

    @PostMapping
    public ResponseEntity<Production> save(@RequestBody Production entity){
        return ResponseEntity.ok().body(this.productionService.save(entity));
    }

    @GetMapping
    public ResponseEntity<List<Production>> getAll(){
        return ResponseEntity.ok().body(this.productionService.getAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Production> getById(@PathVariable("id") int id){
        return ResponseEntity.ok().body(this.productionService.getById(id));
    }

    @DeleteMapping(path = "/{id}")
    public Map<String, Boolean> delete(@PathVariable("id") int id){
        this.productionService.delete(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Deleted", Boolean.TRUE);
        return response;
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Production> update(@PathVariable("id") int id, @RequestBody Production entity){
        return ResponseEntity.ok().body(this.productionService.update(id,entity));
    }
}
