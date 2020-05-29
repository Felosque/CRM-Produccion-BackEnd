package com.crmunibague.crmunibague.productionstate;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductionStateService {

    public ProductionState save(ProductionState productionState);

    public List<ProductionState> getAll();

    public ProductionState getById(int id);

    public ProductionState update(int id, ProductionState productionState);

    public void delete(int id);

}
