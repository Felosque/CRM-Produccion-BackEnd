package com.crmunibague.crmunibague.productionstate;

import com.crmunibague.crmunibague.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductionStateImpl implements ProductionStateService{

    private ProductionStateRepository productionStateRepository;

    @Autowired
    public ProductionStateImpl(ProductionStateRepository productionStateRepository) {
        this.productionStateRepository = productionStateRepository;
    }

    @Override
    public ProductionState save(ProductionState productionState) {
        return this.productionStateRepository.save(productionState);
    }

    @Override
    public List<ProductionState> getAll() {
        return this.productionStateRepository.findAll();
    }

    @Override
    public ProductionState getById(int id) {
        return this.productionStateRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("El estado buscado por el id: " +id+" | NOT FOUND"));
    }

    @Override
    public ProductionState update(int id, ProductionState productionState) {
        ProductionState entity = this.getById(id);
        entity.setCode(productionState.getCode());
        entity.setDescription(productionState.getDescription());
        return this.save(entity);
    }

    @Override
    public void delete(int id) {
        ProductionState entity = this.getById(id);
        this.productionStateRepository.delete(entity);
    }
}
