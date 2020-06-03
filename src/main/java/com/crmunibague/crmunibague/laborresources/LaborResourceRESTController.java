package com.crmunibague.crmunibague.laborresources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200",maxAge = 3600)
@RequestMapping("scm-unibague/laborresource")
@RestController
public class LaborResourceRESTController {

    private LaborResourceService laborResourceService;

    @Autowired
    public LaborResourceRESTController(LaborResourceService laborResourceService)
    {
        this.laborResourceService = laborResourceService;
    }

    @PostMapping
    public ResponseEntity<LaborResource> save(@RequestBody LaborResource laborResource) {
        return ResponseEntity.ok().body(this.laborResourceService.save(laborResource));
    }

    @GetMapping
    public ResponseEntity<List<LaborResource>> getAll() {
        return ResponseEntity.ok().body(this.laborResourceService.getAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<LaborResource> getByID(@PathVariable("id") int id){
        return ResponseEntity.ok().body(this.laborResourceService.getById(id));
    }

    @DeleteMapping(path = "/{id}")
    public Map<String, Boolean> delete(@PathVariable("id") int id){
        this.laborResourceService.delete(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Delete", Boolean.TRUE);
        return response;
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<LaborResource> update(@PathVariable int id, @RequestBody LaborResource laborResource){
        return ResponseEntity.ok().body(this.laborResourceService.update(id, laborResource));
    }

}
