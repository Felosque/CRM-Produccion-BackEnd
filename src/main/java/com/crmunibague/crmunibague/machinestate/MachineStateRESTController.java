package com.crmunibague.crmunibague.machinestate;

import com.crmunibague.crmunibague.statebrachoffice.StateBrachOffice;
import com.crmunibague.crmunibague.statebrachoffice.StateBrachOfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("crm-unibague/v1/produccion/MachineState")
@RestController
public class MachineStateRESTController {

    private MachineStateService machineStateService;

    @Autowired
    public MachineStateRESTController(MachineStateService machineStateService) {
        this.machineStateService = machineStateService;
    }

    @PostMapping
    public ResponseEntity<MachineState> save(@RequestBody MachineState entity){
        return ResponseEntity.ok().body(this.machineStateService.save(entity));
    }

    @GetMapping
    public ResponseEntity<List<MachineState>> getAll(){
        return ResponseEntity.ok().body(this.machineStateService.getAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<MachineState> getById(@PathVariable("id") int id){
        return ResponseEntity.ok().body(this.machineStateService.getById(id));
    }

    @DeleteMapping(path = "/{id}")
    public Map<String, Boolean> delete(@PathVariable("id") int id){
        this.machineStateService.delete(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Deleted", Boolean.TRUE);
        return response;
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<MachineState> update(@PathVariable("id") int id, @RequestBody MachineState entity){
        return ResponseEntity.ok().body(this.machineStateService.update(id,entity));
    }
}
