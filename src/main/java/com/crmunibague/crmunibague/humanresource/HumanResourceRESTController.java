package com.crmunibague.crmunibague.humanresource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200",maxAge = 3600)
@RequestMapping("scm-unibague/humanresource")
@RestController
public class HumanResourceRESTController {

    private HumanResourceService humanResourceService;

    @Autowired
    public HumanResourceRESTController(HumanResourceService humanResourceService) {
        this.humanResourceService = humanResourceService;
    }

    @PostMapping
    public ResponseEntity<HumanResource> save(@RequestBody HumanResource humanResource) {
        return ResponseEntity.ok().body(this.humanResourceService.save(humanResource));
    }

    @GetMapping
    public ResponseEntity<List<HumanResource>> getAll() {
        return ResponseEntity.ok().body(this.humanResourceService.getAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<HumanResource> getByID(@PathVariable("id") int id){
        return ResponseEntity.ok().body(this.humanResourceService.getById(id));
    }

    @DeleteMapping(path = "/{id}")
    public Map<String, Boolean> delete(@PathVariable("id") int id){
        this.humanResourceService.delete(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Delete", Boolean.TRUE);
        return response;
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<HumanResource> update(@PathVariable int id, @RequestBody HumanResource humanResource){
        return ResponseEntity.ok().body(this.humanResourceService.update(id, humanResource));
    }

}
