package com.crmunibague.crmunibague.workshift;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200",maxAge = 3600)
@RequestMapping("scm-unibague/WorkShift")
@RestController
public class WorkShiftRESTController {

    private WorkShiftService workShiftService;

    @Autowired
    public WorkShiftRESTController(WorkShiftService workShiftService)
    {
        this.workShiftService = workShiftService;
    }

    @PostMapping
    public ResponseEntity<WorkShift> save(@RequestBody WorkShift workShift)
    {
        return ResponseEntity.ok().body(this.workShiftService.save(workShift));
    }

    @GetMapping
    public ResponseEntity<List<WorkShift>> getAll()
    {
        return ResponseEntity.ok().body(this.workShiftService.getAll());
    }

    @GetMapping(path = "/{code}")
    public ResponseEntity<WorkShift> getByID(@PathVariable("code") int code)
    {
        return ResponseEntity.ok().body(this.workShiftService.getById(code));
    }

}
