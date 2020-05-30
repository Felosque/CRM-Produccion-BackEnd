package com.crmunibague.crmunibague.workshift;

import com.crmunibague.crmunibague.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkShiftServiceImpl implements WorkShiftService{

    private WorkShiftRepository workShiftRepository;

    @Autowired
    public WorkShiftServiceImpl(WorkShiftRepository workShiftRepository)
    {
        this.workShiftRepository = workShiftRepository;
    }

    @Override
    public WorkShift save(WorkShift workShift) {
        return this.workShiftRepository.save(workShift);
    }

    @Override
    public List<WorkShift> getAll() {
        return this.workShiftRepository.findAll();
    }

    @Override
    public WorkShift getById(int id) {
        return this.workShiftRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No se ha encontrado el turno de trabajo con el ID: " + id));
    }

    @Override
    public WorkShift update(int id, WorkShift workShift) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

}
