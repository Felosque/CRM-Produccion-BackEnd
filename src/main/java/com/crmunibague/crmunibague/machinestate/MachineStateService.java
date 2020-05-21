package com.crmunibague.crmunibague.machinestate;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MachineStateService {

    public MachineState save(MachineState machineState);

    public List<MachineState> getAll();

    public MachineState getById(int id);

    public MachineState update(int id, MachineState machineState);

    public void delete(int id);
}
