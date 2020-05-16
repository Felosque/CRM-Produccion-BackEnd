package com.crmunibague.crmunibague.workshift;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface WorkShiftService {

    public WorkShift save(WorkShift workShift);

    public List<WorkShift> getAll();

    public WorkShift getById(int id);

    public WorkShift update(int id, WorkShift workShift);

    public void delete(int id);

}
