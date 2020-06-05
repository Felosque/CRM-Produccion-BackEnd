package com.crmunibague.crmunibague.branchoffice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200",maxAge = 3600)
@RequestMapping("scm-unibague/BranchOffice")
@RestController
public class BranchOfficeRESTController {

    private BranchOfficeService branchOfficeService;

    @Autowired
    public BranchOfficeRESTController(BranchOfficeService branchOfficeService) {
        this.branchOfficeService = branchOfficeService;
    }

    @PostMapping
    public ResponseEntity<BranchOffice> save(@RequestBody BranchOffice entity){
        return ResponseEntity.ok().body(this.branchOfficeService.save(entity));
    }

    @GetMapping
    public ResponseEntity<List<BranchOffice>> getAll(){
        return ResponseEntity.ok().body(this.branchOfficeService.getAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<BranchOffice> getById(@PathVariable("id") int id){
        return ResponseEntity.ok().body(this.branchOfficeService.getById(id));
    }

    @DeleteMapping(path = "/{id}")
    public Map<String, Boolean> delete(@PathVariable("id") int id){
        this.branchOfficeService.delete(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Deleted", Boolean.TRUE);
        return response;
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<BranchOffice> update(@PathVariable("id") int id, @RequestBody BranchOffice entity){
        return ResponseEntity.ok().body(this.branchOfficeService.update(id,entity));
    }
}
