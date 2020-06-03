package com.crmunibague.crmunibague.productiondetails;

import com.crmunibague.crmunibague.production.Production;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin( origins = "http://localhost:4200", maxAge = 3600)
@RequestMapping("scm-unibague/ProductionDetails")
@RestController
public class ProductionDetailsRESTController {

    private ProductionDetailsService productionDetailsService;

    @Autowired
    public ProductionDetailsRESTController(ProductionDetailsService productionDetailsService) {
        this.productionDetailsService = productionDetailsService;
    }

    @PostMapping
    public ResponseEntity<ProductionDetails> save(@RequestBody ProductionDetails entity){
        return ResponseEntity.ok().body(this.productionDetailsService.save(entity));
    }

    @GetMapping
    public ResponseEntity<List<ProductionDetails>> getAll(){
        return ResponseEntity.ok().body(this.productionDetailsService.getAll());
    }

}
