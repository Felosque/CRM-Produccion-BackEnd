package com.crmunibague.crmunibague.requestdetailsrawmaterial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin( origins = "http://localhost:4200", maxAge = 3600)
@RequestMapping("scm-unibague/RequestDetailsRawMaterial")
@RestController
public class RequestDetailsRawMaterialRESTController {

    private RequestDetailsRawMaterialService requestDetailsRawMaterialService;

    @Autowired
    public RequestDetailsRawMaterialRESTController(RequestDetailsRawMaterialService requestDetailsRawMaterialService) {
        this.requestDetailsRawMaterialService = requestDetailsRawMaterialService;
    }

    @GetMapping
    public ResponseEntity<List<RequestDetailsRawMaterial>> getAll(){
        return ResponseEntity.ok().body(this.requestDetailsRawMaterialService.getAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<RequestDetailsRawMaterial> getById(@PathVariable("id") int id){
        return ResponseEntity.ok().body(this.requestDetailsRawMaterialService.getById(id));
    }

    @GetMapping(path = "/RequestCode/{id}")
    public ResponseEntity<List<RequestDetailsRawMaterial>> getByRawMaterialRequestCode(@PathVariable("id") int id){
        return ResponseEntity.ok().body(this.requestDetailsRawMaterialService.getAllByRawMaterialRequestCode(id));
    }

    @PostMapping
    public ResponseEntity<RequestDetailsRawMaterial> save(@RequestBody RequestDetailsRawMaterial entity){
        return ResponseEntity.ok().body(this.requestDetailsRawMaterialService.save(entity));
    }

    @DeleteMapping(path = "/{id}")
    public Map<String, Boolean> delete(@PathVariable("id") int id){
        this.requestDetailsRawMaterialService.delete(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Deleted", Boolean.TRUE);
        return response;
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<RequestDetailsRawMaterial> update(@PathVariable("id") int id, @RequestBody RequestDetailsRawMaterial entity){
        return ResponseEntity.ok().body(this.requestDetailsRawMaterialService.update(id,entity));
    }

}
