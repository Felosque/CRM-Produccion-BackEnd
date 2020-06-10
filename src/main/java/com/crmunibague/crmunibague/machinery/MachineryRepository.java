package com.crmunibague.crmunibague.machinery;

import com.crmunibague.crmunibague.machinestate.MachineState;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface MachineryRepository extends JpaRepository<Machinery, Integer> {

    List<Machinery> findByMachineStateBean(MachineState entity);

}
