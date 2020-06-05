package com.crmunibague.crmunibague.productiondetails;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductionDetailsService {

    public ProductionDetails save(ProductionDetails productionDetails);

    public List<ProductionDetails> getAll();

    public ProductionDetails update(ProductionDetails productionDetails);

    public void delete(ProductionDetails productionDetails);


   // public ProductionDetails getById(ProductionDetailsPk id);
}
