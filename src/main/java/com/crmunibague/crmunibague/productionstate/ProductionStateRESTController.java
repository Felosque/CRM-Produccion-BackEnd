package com.crmunibague.crmunibague.productionstate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("crm-unibague/ProductionState")
@RestController
public class ProductionStateRESTController {

    private ProductionStateService productionStateService;

    @Autowired
    public ProductionStateRESTController(ProductionStateService productionStateService) {
        this.productionStateService = productionStateService;
    }

    @PostMapping
    public ResponseEntity<ProductionState> save(@RequestBody ProductionState entity){
        return ResponseEntity.ok().body(this.productionStateService.save(entity));
    }

    @GetMapping
    public ResponseEntity<List<ProductionState>> getAll(){
        return ResponseEntity.ok().body(this.productionStateService.getAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ProductionState> getById(@PathVariable("id") int id){
        return ResponseEntity.ok().body(this.productionStateService.getById(id));
    }

    @DeleteMapping(path = "/{id}")
    public Map<String, Boolean> delete(@PathVariable("id") int id){
        this.productionStateService.delete(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Deleted", Boolean.TRUE);
        return response;
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<ProductionState> update(@PathVariable("id") int id, @RequestBody ProductionState entity){
        return ResponseEntity.ok().body(this.productionStateService.update(id,entity));
    }
}
