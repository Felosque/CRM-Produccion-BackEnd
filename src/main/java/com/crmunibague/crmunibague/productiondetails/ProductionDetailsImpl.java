package com.crmunibague.crmunibague.productiondetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductionDetailsImpl implements ProductionDetailsService{

    private ProductionDetailsRespository productionDetailsRepository;

    @Autowired
    public ProductionDetailsImpl(ProductionDetailsRespository productionDetailsRepository) {
        this.productionDetailsRepository = productionDetailsRepository;
    }

    @Override
    public ProductionDetails save(ProductionDetails productionDetails) {
        return this.productionDetailsRepository.save(productionDetails);
    }

    @Override
    public List<ProductionDetails> getAll() {
        return this.productionDetailsRepository.findAll();
    }
}
