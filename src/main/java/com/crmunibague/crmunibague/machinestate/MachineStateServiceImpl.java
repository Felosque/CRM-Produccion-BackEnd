package com.crmunibague.crmunibague.machinestate;

import com.crmunibague.crmunibague.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MachineStateServiceImpl implements MachineStateService{

    private MachineStateRepository machineStateRepository;

    @Autowired
    public MachineStateServiceImpl(MachineStateRepository machineStateRepository) {
        this.machineStateRepository = machineStateRepository;
    }

    @Override
    public MachineState save(MachineState machineState) {
        return this.machineStateRepository.save(machineState);
    }

    @Override
    public List<MachineState> getAll() {
        return this.machineStateRepository.findAll();
    }

    @Override
    public MachineState getById(int id) {
        return this.machineStateRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("machineState with code: "+ id + " | NOT FOUND"));
    }

    @Override
    public MachineState update(int id, MachineState machineState) {
        MachineState entity = this.getById(id);
        entity.setCode(machineState.getCode());
        entity.setDescription(machineState.getDescription());
        return this.save(entity);
    }

    @Override
    public void delete(int id) {
        MachineState entity = this.getById(id);
        this.machineStateRepository.delete(entity);
    }
}
