package com.crmunibague.crmunibague.process;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("scm-unibague/process")
@RestController
public class ProcessRESTController {

    private ProcessService processService;

    @Autowired
    public ProcessRESTController(ProcessService processService){
        this.processService = processService;
    }

    @PostMapping
    public ResponseEntity<Process> save(@RequestBody Process process) {
        return ResponseEntity.ok().body(this.processService.save(process));
    }

    @GetMapping
    public ResponseEntity<List<Process>> getAll() {
        return ResponseEntity.ok().body(this.processService.getAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Process> getByID(@PathVariable("id") int id){
        return ResponseEntity.ok().body(this.processService.getById(id));
    }

    @DeleteMapping(path = "/{id}")
    public Map<String, Boolean> delete(@PathVariable("id") int id){
        this.processService.delete(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Delete", Boolean.TRUE);
        return response;
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Process> update(@PathVariable int id, @RequestBody Process process){
        return ResponseEntity.ok().body(this.processService.update(id, process));
    }


}
