package com.crmunibague.crmunibague.productionprocesses;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductionProcessesService {

    public ProductionProcesses save(ProductionProcesses productionProcesses);

    public List<ProductionProcesses> getAll();

    public ProductionProcesses getById(int id);

    public ProductionProcesses update(int id, ProductionProcesses production);

    public void delete(int id);
}
