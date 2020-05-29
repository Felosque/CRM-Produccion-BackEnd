package com.crmunibague.crmunibague.requeststatus;

import com.crmunibague.crmunibague.machinestate.MachineState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("scm-unibague/RequestStatus")
@RestController
public class RequestStatusRESTController {

    private RequestStatusService requestStatusService;

    @Autowired
    public RequestStatusRESTController(RequestStatusService requestStatusService) {
        this.requestStatusService = requestStatusService;
    }

    @PostMapping
    public ResponseEntity<RequestStatus> save(@RequestBody RequestStatus entity){
        return ResponseEntity.ok().body(this.requestStatusService.save(entity));
    }

    @GetMapping
    public ResponseEntity<List<RequestStatus>> getAll(){
        return ResponseEntity.ok().body(this.requestStatusService.getAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<RequestStatus> getById(@PathVariable("id") int id){
        return ResponseEntity.ok().body(this.requestStatusService.getById(id));
    }

    @DeleteMapping(path = "/{id}")
    public Map<String, Boolean> delete(@PathVariable("id") int id){
        this.requestStatusService.delete(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Deleted", Boolean.TRUE);
        return response;
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<RequestStatus> update(@PathVariable("id") int id, @RequestBody RequestStatus entity){
        return ResponseEntity.ok().body(this.requestStatusService.update(id,entity));
    }
}
