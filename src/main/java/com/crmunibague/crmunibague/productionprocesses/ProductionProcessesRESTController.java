package com.crmunibague.crmunibague.productionprocesses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin( origins = "http://localhost:4200", maxAge = 3600)
@RequestMapping("scm-unibague/ProductionProcesses")
@RestController
public class ProductionProcessesRESTController {

    private ProductionProcessesService productionProcessesService;

    @Autowired
    public ProductionProcessesRESTController(ProductionProcessesService productionProcessesService) {
        this.productionProcessesService = productionProcessesService;
    }

    @GetMapping
    public ResponseEntity<List<ProductionProcesses>> getAll(){
        return ResponseEntity.ok().body(this.productionProcessesService.getAll());
    }


    @GetMapping(path = "/{id}")
    public ResponseEntity<ProductionProcesses> getById(@PathVariable("id") int id){
        return ResponseEntity.ok().body(this.productionProcessesService.getById(id));
    }
    @PostMapping
    public ResponseEntity<ProductionProcesses> save(@RequestBody ProductionProcesses entity){
        return ResponseEntity.ok().body(this.productionProcessesService.save(entity));
    }

    @DeleteMapping(path = "/{id}")
    public Map<String, Boolean> delete(@PathVariable("id") int id){
        this.productionProcessesService.delete(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Deleted", Boolean.TRUE);
        return response;
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<ProductionProcesses> update(@PathVariable("id") int id, @RequestBody ProductionProcesses entity){
        return ResponseEntity.ok().body(this.productionProcessesService.update(id,entity));
    }

}
