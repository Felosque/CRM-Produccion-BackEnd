package com.crmunibague.crmunibague.machinery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("scm-unibague/Machinery")
@RestController
public class MachineryRESTController {

    private MachineryService machineryService;

    @Autowired
    public MachineryRESTController(MachineryService machineryService)
    {
        this.machineryService = machineryService;
    }

    @PostMapping
    public ResponseEntity<Machinery> save(@RequestBody Machinery machinery) {
        return ResponseEntity.ok().body(this.machineryService.save(machinery));
    }

    @GetMapping
    public ResponseEntity<List<Machinery>> getAll() {
        return ResponseEntity.ok().body(this.machineryService.getAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Machinery> getByID(@PathVariable("id") int id){
        return ResponseEntity.ok().body(this.machineryService.getById(id));
    }

    @DeleteMapping(path = "/{id}")
    public Map<String, Boolean> delete(@PathVariable("id") int id){
        this.machineryService.delete(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Delete", Boolean.TRUE);
        return response;
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Machinery> update(@PathVariable int id, @RequestBody Machinery machinery){
        return ResponseEntity.ok().body(this.machineryService.update(id, machinery));
    }

}
