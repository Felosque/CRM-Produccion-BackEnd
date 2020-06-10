package com.crmunibague.crmunibague.humanresource;

import com.crmunibague.crmunibague.exceptions.ResourceNotFoundException;
import com.crmunibague.crmunibague.workshift.WorkShift;
import com.crmunibague.crmunibague.workshift.WorkShiftService;
import org.hibernate.jdbc.Work;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
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
    public List<HumanResource> getAllByWorkShift() {
        return this.humanResourceRepository.findByWorkShift(getWorkShiftByHour());
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

    public WorkShift getWorkShiftByHour(){
        WorkShift entity = null;
        Date actual = new Date();
        String hora = new SimpleDateFormat("HH").format(actual);
        int horaInt = Integer.parseInt(hora);

        if(horaInt > 6 && horaInt<14){
            entity = this.workShiftService.getById(1);
        }
        else if(horaInt > 14 && horaInt < 22){
            entity = this.workShiftService.getById(2);
        }
        else{
            entity = this.workShiftService.getById(3);
        }

        return entity;

    }
}
