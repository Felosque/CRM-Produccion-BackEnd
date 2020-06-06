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
    public ProductionProcesses save(ProductionProcesses productionProcesses) {
        return this.productionProcessesRepository.save(productionProcesses);
    }

    @Override
    public List<ProductionProcesses> getAll() {
        return this.productionProcessesRepository.findAll();
    }

    @Override
    public ProductionProcesses getById(int id) {
        return this.productionProcessesRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("The BranchOffice by id: " + id + " | NOT FOUND."));
    }

    @Override
    public ProductionProcesses update(int id, ProductionProcesses production) {
        ProductionProcesses entity = this.getById(id);
        entity.setEndDate(production.getEndDate());
        entity.setStartDate(production.getStartDate());
        entity.setStockProduced(production.getStockProduced());

        return this.save(entity);
    }

    @Override
    public void delete(int id) {
        ProductionProcesses entity = this.getById(id);
        this.productionProcessesRepository.delete(entity);
    }
}
