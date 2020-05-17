package com.crmunibague.crmunibague.statebrachoffice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("crm-unibague/v1/produccion/StateBranchOffice")
@RestController
public class StateBranchRESTController {

    private StateBranchOfficeService stateBranchOfficeService;

    @Autowired
    public StateBranchRESTController(StateBranchOfficeService stateBranchOfficeService) {
        this.stateBranchOfficeService = stateBranchOfficeService;
    }

    @PostMapping
    public ResponseEntity<StateBranchOffice> save(@RequestBody StateBranchOffice entity){
        return ResponseEntity.ok().body(this.stateBranchOfficeService.save(entity));
    }

    @GetMapping
    public ResponseEntity<List<StateBranchOffice>> getAll(){
        return ResponseEntity.ok().body(this.stateBranchOfficeService.getAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<StateBranchOffice> getById(@PathVariable("id") int id){
        return ResponseEntity.ok().body(this.stateBranchOfficeService.getById(id));
    }

    @DeleteMapping(path = "/{id}")
    public Map<String, Boolean> delete(@PathVariable("id") int id){
        this.stateBranchOfficeService.delete(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Deleted", Boolean.TRUE);
        return response;
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<StateBranchOffice> update(@PathVariable("id") int id, @RequestBody StateBranchOffice entity){
        return ResponseEntity.ok().body(this.stateBranchOfficeService.update(id,entity));
    }
}
