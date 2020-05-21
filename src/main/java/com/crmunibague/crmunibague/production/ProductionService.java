package com.crmunibague.crmunibague.production;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductionService {

    public Production save(Production production);

    public List<Production> getAll();

    public Production getById(int id);

    public Production update(int id, Production production);

    public void delete(int id);
}
