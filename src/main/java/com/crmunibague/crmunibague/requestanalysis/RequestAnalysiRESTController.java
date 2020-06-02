package com.crmunibague.crmunibague.requestanalysis;

import com.crmunibague.crmunibague.predecessors.Predecessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("scm-unibague/requestanalysis")
@RestController
public class RequestAnalysiRESTController {

    private RequestAnalysiService requestAnalysiService;

    @Autowired
    public RequestAnalysiRESTController(RequestAnalysiService requestAnalysiService)
    {
        this.requestAnalysiService = requestAnalysiService;
    }

    @PostMapping
    public ResponseEntity<RequestAnalysi> save(@RequestBody RequestAnalysi requestAnalysi) {
        return ResponseEntity.ok().body(this.requestAnalysiService.save(requestAnalysi));
    }

    @GetMapping
    public ResponseEntity<List<RequestAnalysi>> getAll() {
        return ResponseEntity.ok().body(this.requestAnalysiService.getAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<RequestAnalysi> getByID(@PathVariable("id") RequestAnalysiPK id){
        return ResponseEntity.ok().body(this.requestAnalysiService.getById(id));
    }

    @DeleteMapping(path = "/{id}")
    public Map<String, Boolean> delete(@PathVariable("id") RequestAnalysiPK id){
        this.requestAnalysiService.delete(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Delete", Boolean.TRUE);
        return response;
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<RequestAnalysi> update(@PathVariable RequestAnalysiPK id, @RequestBody RequestAnalysi requestAnalysi){
        return ResponseEntity.ok().body(this.requestAnalysiService.update(id, requestAnalysi));
    }


}
