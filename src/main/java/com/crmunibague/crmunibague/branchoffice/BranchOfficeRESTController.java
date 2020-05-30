package com.crmunibague.crmunibague.branchoffice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("scm-unibague/branchoffice")
@RestController
public class BranchOfficeRESTController {

    private BranchOfficeService branchOfficeService;

    @Autowired
    public BranchOfficeRESTController(BranchOfficeService branchOfficeService)
    {
        this.branchOfficeService = branchOfficeService;
    }

    @PostMapping
    public ResponseEntity<BranchOffice> save(@RequestBody BranchOffice branchOffice){
        return ResponseEntity.ok().body(this.branchOfficeService.save(branchOffice));
    }

    @GetMapping
    public ResponseEntity<List<BranchOffice>> getAll(){
        return ResponseEntity.ok().body(this.branchOfficeService.getAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<BranchOffice> getByID(@PathVariable("id") int id){
        return ResponseEntity.ok().body(this.branchOfficeService.getById(id));
    }

    @DeleteMapping(path = "/{id}")
    public Map<String, Boolean> delete(@PathVariable("id") int id){
        this.branchOfficeService.delete(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Delete", Boolean.TRUE);
        return response;
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<BranchOffice> update(@PathVariable int id, @RequestBody BranchOffice branchOffice){
        return ResponseEntity.ok().body(this.branchOfficeService.update(id, branchOffice));
    }


}
