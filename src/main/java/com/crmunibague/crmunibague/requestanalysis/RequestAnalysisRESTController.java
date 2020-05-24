package com.crmunibague.crmunibague.requestanalysis;

import com.crmunibague.crmunibague.requeststatus.RequestStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("scm-unibague/RequestAnalysis")
@RestController
public class RequestAnalysisRESTController {

    private RequestAnalysisService requestAnalysisService;

    @Autowired
    public RequestAnalysisRESTController(RequestAnalysisService requestAnalysisService) {
        this.requestAnalysisService = requestAnalysisService;
    }

    @PostMapping
    public ResponseEntity<RequestAnalysis> save(@RequestBody RequestAnalysis entity){
        return ResponseEntity.ok().body(this.requestAnalysisService.save(entity));
    }

    @GetMapping
    public ResponseEntity<List<RequestAnalysis>> getAll(){
        return ResponseEntity.ok().body(this.requestAnalysisService.getAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<RequestAnalysis> getById(@PathVariable("id") int id){
        return ResponseEntity.ok().body(this.requestAnalysisService.getById(id));
    }

    @DeleteMapping(path = "/{id}")
    public Map<String, Boolean> delete(@PathVariable("id") int id){
        this.requestAnalysisService.delete(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Deleted", Boolean.TRUE);
        return response;
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<RequestAnalysis> update(@PathVariable("id") int id, @RequestBody RequestAnalysis entity){
        return ResponseEntity.ok().body(this.requestAnalysisService.update(id,entity));
    }
}
