package com.crmunibague.crmunibague.productionprocesses;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductionProcessesService {

    public ProductionProcesses save(ProductionProcesses entity);

    public List<ProductionProcesses> getAll();

    public ProductionProcesses getById(int id);

    public ProductionProcesses update(int id, ProductionProcesses entity);

    public void delete(int id);

}
