package com.crmunibague.crmunibague.requestanalysis;

import com.crmunibague.crmunibague.requeststatus.RequestStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

/*
    @GetMapping(path = "/{id}")
    public  ResponseEntity<List<RequestAnalysis>> getByRequestAnalysisCode(@PathVariable("id") int id){
        return ResponseEntity.ok().body(this.requestAnalysisService.getByRequestAnalysisCode(id));
    }

 */

}
