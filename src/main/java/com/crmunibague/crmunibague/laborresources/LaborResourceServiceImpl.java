package com.crmunibague.crmunibague.laborresources;

import com.crmunibague.crmunibague.exceptions.ResourceNotFoundException;
import com.crmunibague.crmunibague.process.Process;
import com.crmunibague.crmunibague.process.ProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LaborResourceServiceImpl implements LaborResourceService {

    private LaborResourceRepository laborResourceRepository;

    private ProcessService processService;

    @Autowired
    public LaborResourceServiceImpl(LaborResourceRepository laborResourceRepository, ProcessService processService)
    {
        this.laborResourceRepository = laborResourceRepository;
        this.processService = processService;
    }

    @Override
    public LaborResource save(LaborResource laborResource) {
        Process process = processService.getById(laborResource.getProcess().getCode());
        laborResource.setProcess(process);
        return laborResourceRepository.save(laborResource);
    }

    @Override
    public List<LaborResource> getAll() {
        return laborResourceRepository.findAll();
    }

    @Override
    public LaborResource getById(int id) {
        return this.laborResourceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("El Labor Resource con el ID: " + id + " no ha sido encontrado."));

    }

    @Override
    public LaborResource update(int id, LaborResource laborResource) {
        LaborResource laborResourceToUpdate = getById(laborResource.getCode());
        laborResourceToUpdate.setStaff(laborResource.getStaff());
        return save(laborResourceToUpdate);
    }

    @Override
    public void delete(int id) {
        LaborResource laborResourceToDelete = getById(id);
        laborResourceRepository.delete(laborResourceToDelete);
    }
}
