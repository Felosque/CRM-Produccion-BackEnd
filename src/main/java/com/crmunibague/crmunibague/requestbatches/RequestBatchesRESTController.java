package com.crmunibague.crmunibague.requestbatches;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("scm-unibague/RequestBatches")
@RestController
public class RequestBatchesRESTController {

    private RequestBatchesService requestBatchesService;

    @Autowired
    public RequestBatchesRESTController(RequestBatchesService requestBatchesService) {
        this.requestBatchesService = requestBatchesService;
    }

    @PostMapping
    public ResponseEntity<RequestBatches> save(@RequestBody RequestBatches entity){
        return ResponseEntity.ok().body(this.requestBatchesService.save(entity));
    }

    @GetMapping
    public ResponseEntity<List<RequestBatches>> getAll(){
        return ResponseEntity.ok().body(this.requestBatchesService.getAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<RequestBatches> getById(@PathVariable("id") int id){
        return ResponseEntity.ok().body(this.requestBatchesService.getById(id));
    }

    @DeleteMapping(path = "/{id}")
    public Map<String, Boolean> delete(@PathVariable("id") int id){
        this.requestBatchesService.delete(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Deleted", Boolean.TRUE);
        return response;
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<RequestBatches> update(@PathVariable("id") int id, @RequestBody RequestBatches entity){
        return ResponseEntity.ok().body(this.requestBatchesService.update(id,entity));
    }
}
