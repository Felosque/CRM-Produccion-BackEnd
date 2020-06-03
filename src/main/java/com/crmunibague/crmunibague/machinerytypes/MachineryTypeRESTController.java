package com.crmunibague.crmunibague.machinerytypes;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200",maxAge = 3600)
@RequestMapping("scm-unibague/machinerytype")
@RestController
public class MachineryTypeRESTController {

    private MachineryTypeService machineryTypeService;

    @Autowired
    public MachineryTypeRESTController(MachineryTypeService machineryTypeService){
        this.machineryTypeService = machineryTypeService;
    }

    @PostMapping
    public ResponseEntity<MachineryType> save(@RequestBody MachineryType machineryType) {
        return ResponseEntity.ok().body(this.machineryTypeService.save(machineryType));
    }

    @GetMapping
    public ResponseEntity<List<MachineryType>> getAll() {
        return ResponseEntity.ok().body(this.machineryTypeService.getAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<MachineryType> getByID(@PathVariable("id") int id){
        return ResponseEntity.ok().body(this.machineryTypeService.getById(id));
    }

    @DeleteMapping(path = "/{id}")
    public Map<String, Boolean> delete(@PathVariable("id") int id){
        this.machineryTypeService.delete(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Delete", Boolean.TRUE);
        return response;
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<MachineryType> update(@PathVariable int id, @RequestBody MachineryType machineryType){
        return ResponseEntity.ok().body(this.machineryTypeService.update(id, machineryType));
    }

}
