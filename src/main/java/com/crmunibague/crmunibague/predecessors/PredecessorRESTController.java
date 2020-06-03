package com.crmunibague.crmunibague.predecessors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200",maxAge = 3600)
@RequestMapping("scm-unibague/predecessor")
@RestController
public class PredecessorRESTController {

    private PredecessorService predecessorService;

    @Autowired
    public PredecessorRESTController(PredecessorService predecessorService)
    {
        this.predecessorService = predecessorService;
    }

    @PostMapping
    public ResponseEntity<Predecessor> save(@RequestBody Predecessor predecessor) {
        return ResponseEntity.ok().body(this.predecessorService.save(predecessor));
    }

    @GetMapping
    public ResponseEntity<List<Predecessor>> getAll() {
        return ResponseEntity.ok().body(this.predecessorService.getAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Predecessor> getByID(@PathVariable("id") int id){
        return ResponseEntity.ok().body(this.predecessorService.getById(id));
    }

    @DeleteMapping(path = "/{id}")
    public Map<String, Boolean> delete(@PathVariable("id") int id){
        this.predecessorService.delete(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Delete", Boolean.TRUE);
        return response;
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Predecessor> update(@PathVariable int id, @RequestBody Predecessor predecessor){
        return ResponseEntity.ok().body(this.predecessorService.update(id, predecessor));
    }

}
