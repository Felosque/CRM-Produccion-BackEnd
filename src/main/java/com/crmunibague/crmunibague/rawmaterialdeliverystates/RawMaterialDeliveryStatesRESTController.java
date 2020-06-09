package com.crmunibague.crmunibague.rawmaterialdeliverystates;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin( origins = "http://localhost:4200", maxAge = 3600)
@RequestMapping("scm-unibague/RawMaterialDeliveryStates")
@RestController
public class RawMaterialDeliveryStatesRESTController {

    private RawMaterialDeliveryStatesService rawMaterialDeliveryStatesService;

    @Autowired
    public RawMaterialDeliveryStatesRESTController(RawMaterialDeliveryStatesService rawMaterialDeliveryStatesService) {
        this.rawMaterialDeliveryStatesService = rawMaterialDeliveryStatesService;
    }

    @GetMapping
    public ResponseEntity<List<RawMaterialDeliveryStates>> getAll(){
        return ResponseEntity.ok().body(this.rawMaterialDeliveryStatesService.getAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<RawMaterialDeliveryStates> getById(@PathVariable("id") int id){
        return ResponseEntity.ok().body(this.rawMaterialDeliveryStatesService.getById(id));
    }

    @GetMapping(path = "/RequestDetail/{id}")
    public ResponseEntity<List<RawMaterialDeliveryStates>> getByRequestDetailRawMaterialCode(@PathVariable("id") int id){
        return ResponseEntity.ok().body(this.rawMaterialDeliveryStatesService.getByRequestDetailRawMaterialCode(id));
    }

    @PostMapping
    public ResponseEntity<RawMaterialDeliveryStates> save(@RequestBody RawMaterialDeliveryStates entity){
        return ResponseEntity.ok().body(this.rawMaterialDeliveryStatesService.save(entity));
    }

    @DeleteMapping(path = "/{id}")
    public Map<String, Boolean> delete(@PathVariable("id") int id){
        this.rawMaterialDeliveryStatesService.delete(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Deleted", Boolean.TRUE);
        return response;
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<RawMaterialDeliveryStates> update(@PathVariable("id") int id, @RequestBody RawMaterialDeliveryStates entity){
        return ResponseEntity.ok().body(this.rawMaterialDeliveryStatesService.update(id,entity));
    }
}
