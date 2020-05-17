package com.crmunibague.crmunibague.statebrachoffice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("crm-unibague/v1/produccion/StateBranchOffice")
@RestController
public class StateBrachRESTController {

    private StateBrachOfficeService stateBrachOfficeService;

    @Autowired
    public StateBrachRESTController(StateBrachOfficeService stateBrachOfficeService) {
        this.stateBrachOfficeService = stateBrachOfficeService;
    }

    @PostMapping
    public ResponseEntity<StateBrachOffice> save(@RequestBody StateBrachOffice entity){
        return ResponseEntity.ok().body(this.stateBrachOfficeService.save(entity));
    }

    @GetMapping
    public ResponseEntity<List<StateBrachOffice>> getAll(){
        return ResponseEntity.ok().body(this.stateBrachOfficeService.getAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<StateBrachOffice> getById(@PathVariable("id") int id){
        return ResponseEntity.ok().body(this.stateBrachOfficeService.getById(id));
    }

    @DeleteMapping(path = "/{id}")
    public Map<String, Boolean> delete(@PathVariable("id") int id){
        this.stateBrachOfficeService.delete(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Deleted", Boolean.TRUE);
        return response;
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<StateBrachOffice> update(@PathVariable("id") int id, @RequestBody StateBrachOffice entity){
        return ResponseEntity.ok().body(this.stateBrachOfficeService.update(id,entity));
    }
}
