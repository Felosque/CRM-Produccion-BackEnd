package com.crmunibague.crmunibague.productiondetails;

import com.crmunibague.crmunibague.exceptions.ResourceNotFoundException;
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

    @Override
    public ProductionDetails update(ProductionDetails productionDetails) {

        return this.productionDetailsRepository.save(productionDetails);
    }

    @Override
    public void delete(ProductionDetails productionDetails) {
        this.productionDetailsRepository.delete(productionDetails);
    }

    /*
    @Override
    public ProductionDetails getById(ProductionDetailsPk id) {
        return this.productionDetailsRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Element identified by id: " + id + ".Not Found"));
    }

     */
}
