package com.crmunibague.crmunibague.machinery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.crypto.Mac;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin( origins = "http://localhost:4200", maxAge = 3600)
@RequestMapping("scm-unibague/Machinery")
@RestController
public class MachineryRESTController {

    private MachineryService machineryService;

    @Autowired
    public MachineryRESTController(MachineryService machineryService)
    {
        this.machineryService = machineryService;
    }

    @PostMapping
    public ResponseEntity<Machinery> save(@RequestBody Machinery machinery) {
        return ResponseEntity.ok().body(this.machineryService.save(machinery));
    }

    @GetMapping
    public ResponseEntity<List<Machinery>> getAll() {
        return ResponseEntity.ok().body(this.machineryService.getAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Machinery> getByID(@PathVariable("id") int id){
        return ResponseEntity.ok().body(this.machineryService.getById(id));
    }

    @GetMapping(path = "/DarMaquinasPorEstado/{id}")
    public ResponseEntity<List<Machinery>> getByMachineState(@PathVariable("id") int id){
        return ResponseEntity.ok().body(this.machineryService.getByState(id));
    }

    @DeleteMapping(path = "/{id}")
    public Map<String, Boolean> delete(@PathVariable("id") int id){
        this.machineryService.delete(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Delete", Boolean.TRUE);
        return response;
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Machinery> update(@PathVariable int id, @RequestBody Machinery machinery){
        return ResponseEntity.ok().body(this.machineryService.update(id, machinery));
    }

    @GetMapping(path = "/TotalMaquinas")
    public Integer getTotalMaquinas() {
        return this.machineryService.getAll().size();
    }

    @GetMapping(path = "/TotalDisponibles")
    public Integer getDisponibles() {
        List<Machinery> totalMaquinas = this.machineryService.getAll();
        Integer counter = 0;

        for(int i = 0; i < totalMaquinas.size(); i ++){
            Machinery actual = totalMaquinas.get(i);
            if(actual.getMachineStateBean().getDescription().contains("DISPONIBLE")){
                counter++;
            }

        }

        return counter;

    }

    @GetMapping(path = "/TotalOcupados")
    public Integer getOcupados() {
        List<Machinery> totalMaquinas = this.machineryService.getAll();
        Integer counter = 0;

        for(int i = 0; i < totalMaquinas.size(); i ++){
            Machinery actual = totalMaquinas.get(i);
            if(actual.getMachineStateBean().getDescription().contains("OCUPADO")){
                counter++;
            }

        }

        return counter;

    }

    @GetMapping(path = "/TotalReparacion")
    public Integer getReparacion() {
        List<Machinery> totalMaquinas = this.machineryService.getAll();
        Integer counter = 0;

        for(int i = 0; i < totalMaquinas.size(); i ++){
            Machinery actual = totalMaquinas.get(i);
            if(actual.getMachineStateBean().getDescription().contains("REPARACION")){
                counter++;
            }

        }

        return counter;

    }

    @GetMapping(path = "/TotalMantenimiento")
    public Integer getMantenimiento() {
        List<Machinery> totalMaquinas = this.machineryService.getAll();
        Integer counter = 0;

        for(int i = 0; i < totalMaquinas.size(); i ++){
            Machinery actual = totalMaquinas.get(i);
            if(actual.getMachineStateBean().getDescription().contains("MANTENIMIENTO")){
                counter++;
            }

        }

        return counter;

    }



}
