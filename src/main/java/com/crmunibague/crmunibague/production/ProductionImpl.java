package com.crmunibague.crmunibague.production;

import com.crmunibague.crmunibague.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductionImpl implements ProductionService {

    private ProductionRepository productionRepository;

    @Autowired
    public ProductionImpl(ProductionRepository productionRepository) {
        this.productionRepository = productionRepository;
    }

    @Override
    public Production save(Production production) {
        return this.productionRepository.save(production);
    }

    @Override
    public List<Production> getAll() {
        return this.productionRepository.findAll();
    }

    @Override
    public Production getById(int id) {
        return this.productionRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("El estado buscado por el id: " +id+" | NOT FOUND"));
    }

    @Override
    public Production update(int id, Production production) {
        Production entity = this.getById(id);
        entity.setCode(production.getCode());
        entity.setCreateDate(production.getCreateDate());
        entity.setExpirationDate(production.getExpirationDate());
        entity.setStartOrderDate(production.getStartOrderDate());
        entity.setTime(production.getTime());
        return this.save(entity);
    }

    @Override
    public void delete(int id) {
        Production entity = this.getById(id);
        this.productionRepository.delete(entity);
    }
}
