package com.crmunibague.crmunibague.workshift;

import com.crmunibague.crmunibague.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HumanResourceServiceImpl implements HumanResourceService {

    private HumanResourceRepository humanResourceRepository;

    private WorkShiftService workShiftService;

    @Autowired
    public HumanResourceServiceImpl(HumanResourceRepository humanResourceRepository, WorkShiftService workShiftService) {
        this.humanResourceRepository = humanResourceRepository;
        this.workShiftService = workShiftService;
    }

    @Override
    public HumanResource save(HumanResource humanResource) {
        WorkShift workShift = workShiftService.getById(humanResource.getWorkShift().getCode());
        humanResource.setWorkShift(workShift);
        return this.humanResourceRepository.save(humanResource);
    }

    @Override
    public List<HumanResource> getAll() {
        return this.humanResourceRepository.findAll();
    }

    @Override
    public HumanResource getById(int id) {
        return this.humanResourceRepository.findById(id)
                .orElseThrow( () -> new ResourceNotFoundException("HumanResource identificado por el id " + id + " no se encontró"));
    }

    @Override
    public HumanResource update(int id, HumanResource humanResource) {
        HumanResource humanResourceToUpdate = getById(id);
        humanResourceToUpdate.setDni(humanResource.getDni());
        humanResourceToUpdate.setName(humanResource.getName());
        return save(humanResourceToUpdate);
    }

    @Override
    public void delete(int id) {
        HumanResource humanResourceToDelete = getById(id);
        this.humanResourceRepository.delete(humanResourceToDelete);
    }
}
