package com.crmunibague.crmunibague.laborresources;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LaborResourceService {

    public LaborResource save(LaborResource laborResource);

    public List<LaborResource> getAll();

    public LaborResource getById(int id);

    public LaborResource update(int id, LaborResource laborResource);

    public void delete(int id);

}
