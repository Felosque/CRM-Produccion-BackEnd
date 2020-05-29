package com.crmunibague.crmunibague.workshift;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HumanResourceService {

    public HumanResource save(HumanResource humanResource);

    public List<HumanResource> getAll();

    public HumanResource getById(int id);

    public HumanResource update(int id, HumanResource humanResource);

    public void delete(int id);

}
