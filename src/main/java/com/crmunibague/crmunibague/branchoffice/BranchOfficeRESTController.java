package com.crmunibague.crmunibague.branchoffice;

<<<<<<< HEAD
=======
import com.crmunibague.crmunibague.statebranchoffice.StateBranchOffice;
>>>>>>> Javico_classes
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

<<<<<<< HEAD
@RequestMapping("scm-unibague/branchoffice")
=======
@RequestMapping("scm-unibague/BranchOffice")
>>>>>>> Javico_classes
@RestController
public class BranchOfficeRESTController {

    private BranchOfficeService branchOfficeService;

    @Autowired
<<<<<<< HEAD
    public BranchOfficeRESTController(BranchOfficeService branchOfficeService)
    {
=======
    public BranchOfficeRESTController(BranchOfficeService branchOfficeService) {
>>>>>>> Javico_classes
        this.branchOfficeService = branchOfficeService;
    }

    @PostMapping
<<<<<<< HEAD
    public ResponseEntity<BranchOffice> save(@RequestBody BranchOffice branchOffice){
        return ResponseEntity.ok().body(this.branchOfficeService.save(branchOffice));
=======
    public ResponseEntity<BranchOffice> save(@RequestBody BranchOffice entity){
        return ResponseEntity.ok().body(this.branchOfficeService.save(entity));
>>>>>>> Javico_classes
    }

    @GetMapping
    public ResponseEntity<List<BranchOffice>> getAll(){
        return ResponseEntity.ok().body(this.branchOfficeService.getAll());
    }

    @GetMapping(path = "/{id}")
<<<<<<< HEAD
    public ResponseEntity<BranchOffice> getByID(@PathVariable("id") int id){
=======
    public ResponseEntity<BranchOffice> getById(@PathVariable("id") int id){
>>>>>>> Javico_classes
        return ResponseEntity.ok().body(this.branchOfficeService.getById(id));
    }

    @DeleteMapping(path = "/{id}")
    public Map<String, Boolean> delete(@PathVariable("id") int id){
        this.branchOfficeService.delete(id);
        Map<String, Boolean> response = new HashMap<>();
<<<<<<< HEAD
        response.put("Delete", Boolean.TRUE);
=======
        response.put("Deleted", Boolean.TRUE);
>>>>>>> Javico_classes
        return response;
    }

    @PutMapping(path = "/{id}")
<<<<<<< HEAD
    public ResponseEntity<BranchOffice> update(@PathVariable int id, @RequestBody BranchOffice branchOffice){
        return ResponseEntity.ok().body(this.branchOfficeService.update(id, branchOffice));
    }


=======
    public ResponseEntity<BranchOffice> update(@PathVariable("id") int id, @RequestBody BranchOffice entity){
        return ResponseEntity.ok().body(this.branchOfficeService.update(id,entity));
    }
>>>>>>> Javico_classes
}
