package com.crmunibague.crmunibague.rawmaterialrequests;

import com.crmunibague.crmunibague.production.Production;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin( origins = "http://localhost:4200", maxAge = 3600)
@RequestMapping("scm-unibague/RawMaterialRequests")
@RestController
public class RawMaterialRequestsRESTController {

    private RawMaterialRequestsService rawMaterialRequestsService;

    @Autowired
    public RawMaterialRequestsRESTController(RawMaterialRequestsService rawMaterialRequestsService) {
        this.rawMaterialRequestsService = rawMaterialRequestsService;
    }


    @PostMapping
    public ResponseEntity<RawMaterialRequests> save(@RequestBody RawMaterialRequests entity){
        return ResponseEntity.ok().body(this.rawMaterialRequestsService.save(entity));
    }

    @GetMapping
    public ResponseEntity<List<RawMaterialRequests>> getAll(){
        return ResponseEntity.ok().body(this.rawMaterialRequestsService.getAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<RawMaterialRequests> getById(@PathVariable("id") int id){
        return ResponseEntity.ok().body(this.rawMaterialRequestsService.getById(id));
    }

    @DeleteMapping(path = "/{id}")
    public Map<String, Boolean> delete(@PathVariable("id") int id){
        this.rawMaterialRequestsService.delete(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Deleted", Boolean.TRUE);
        return response;
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<RawMaterialRequests> update(@PathVariable("id") int id, @RequestBody RawMaterialRequests entity){
        return ResponseEntity.ok().body(this.rawMaterialRequestsService.update(id,entity));
    }

}
