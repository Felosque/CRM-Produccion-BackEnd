package com.crmunibague.crmunibague.humanresource;

import com.crmunibague.crmunibague.workshift.WorkShift;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HumanResourceService {

    public HumanResource save(HumanResource humanResource);

    public List<HumanResource> getAll();

    public List<HumanResource> getAllByWorkShift();

    public HumanResource getById(int id);

    public HumanResource update(int id, HumanResource humanResource);

    public void delete(int id);

}
