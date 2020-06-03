package com.crmunibague.crmunibague.machineryprocesses;

import com.crmunibague.crmunibague.process.Process;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200",maxAge = 3600)
@RequestMapping("scm-unibague/machineryprocess")
@RestController
public class MachineryProcessRESTController {

    private MachineryProcessService machineryProcessService;

    @Autowired
    public MachineryProcessRESTController(MachineryProcessService machineryProcessService)
    {
        this.machineryProcessService = machineryProcessService;
    }

    @PostMapping
    public ResponseEntity<MachineryProcess> save(@RequestBody MachineryProcess machineryProcess) {
        return ResponseEntity.ok().body(this.machineryProcessService.save(machineryProcess));
    }

    @GetMapping
    public ResponseEntity<List<MachineryProcess>> getAll() {
        return ResponseEntity.ok().body(this.machineryProcessService.getAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<MachineryProcess> getByID(@PathVariable("id") int id){
        return ResponseEntity.ok().body(this.machineryProcessService.getById(id));
    }

    @DeleteMapping(path = "/{id}")
    public Map<String, Boolean> delete(@PathVariable("id") int id){
        this.machineryProcessService.delete(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Delete", Boolean.TRUE);
        return response;
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<MachineryProcess> update(@PathVariable int id, @RequestBody MachineryProcess machineryProcess){
        return ResponseEntity.ok().body(this.machineryProcessService.update(id, machineryProcess));
    }

}
