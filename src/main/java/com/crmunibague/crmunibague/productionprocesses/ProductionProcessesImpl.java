package com.crmunibague.crmunibague.productionprocesses;

import com.crmunibague.crmunibague.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductionProcessesImpl implements ProductionProcessesService {

    private ProductionProcessesRepository productionProcessesRepository;

    @Autowired
    public ProductionProcessesImpl(ProductionProcessesRepository productionProcessesRepository) {
        this.productionProcessesRepository = productionProcessesRepository;
    }

    @Override
    public ProductionProcesses save(ProductionProcesses entity) {
        return this.productionProcessesRepository.save(entity);
    }

    @Override
    public List<ProductionProcesses> getAll() {
        return this.productionProcessesRepository.findAll();
    }

    @Override
    public ProductionProcesses getById(int id) {
        return this.productionProcessesRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("The Production Process by id:" + id + " | NOT FOUND"));
    }

    @Override
    public ProductionProcesses update(int id, ProductionProcesses entity) {
        ProductionProcesses entityToChange = this.getById(id);
        entityToChange.setCodeProcess(entity.getCodeProcess());
        entityToChange.setStartDate(entity.getStartDate());
        entityToChange.setEndDate(entity.getEndDate());
        entityToChange.setProcess(entity.getProcess());
        entityToChange.setStockProduced(entity.getStockProduced());
        entityToChange.setProductionDetail(entity.getProductionDetail());
        return this.save(entityToChange);
    }

    @Override
    public void delete(int id) {
        ProductionProcesses entityToChange = this.getById(id);
        this.productionProcessesRepository.delete(entityToChange);
    }
}
