package com.crmunibague.crmunibague.machinery;

import com.crmunibague.crmunibague.branchoffice.BranchOffice;
import com.crmunibague.crmunibague.branchoffice.BranchOfficeService;
import com.crmunibague.crmunibague.exceptions.ResourceNotFoundException;
import com.crmunibague.crmunibague.humanresource.HumanResource;
import com.crmunibague.crmunibague.humanresource.HumanResourceService;
import com.crmunibague.crmunibague.machinerytypes.MachineryType;
import com.crmunibague.crmunibague.machinerytypes.MachineryTypeService;
import com.crmunibague.crmunibague.machinestate.MachineState;
import com.crmunibague.crmunibague.machinestate.MachineStateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MachineryServiceImpl implements MachineryService {

    private MachineryRepository machineryRepository;

    private MachineStateService machineStateService;

    private BranchOfficeService branchOfficeService;

    private HumanResourceService humanResourceService;

    private MachineryTypeService machineryTypeService;

    @Autowired
    public MachineryServiceImpl(MachineryRepository machineryRepository, MachineStateService machineStateService, BranchOfficeService branchOfficeService, HumanResourceService humanResourceService, MachineryTypeService machineryTypeService)
    {
        this.branchOfficeService = branchOfficeService;
        this.humanResourceService = humanResourceService;
        this.machineryRepository = machineryRepository;
        this.machineStateService = machineStateService;
        this.machineryTypeService = machineryTypeService;
    }

    @Override
    public Machinery save(Machinery machinery) {
        return machineryRepository.save(machinery);
    }

    @Override
    public List<Machinery> getAll() {
        return machineryRepository.findAll();
    }

    @Override
    public Machinery getById(int id) {
        return this.machineryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("La maquinaria con el ID: " + id + " no ha sido encontrado."));

    }

    @Override
    public Machinery update(int id, Machinery machinery) {
        Machinery machineryToUpdate = getById(id);

        BranchOffice branchOffice = branchOfficeService.getById(machinery.getBranchOfficeBean().getCode());
        MachineState machineState = machineStateService.getById(machinery.getMachineStateBean().getCode());
        HumanResource humanResource = humanResourceService.getById(machinery.getHumanResourceBean().getCode());
        MachineryType machineryType = machineryTypeService.getById(machinery.getMachineryTypeBean().getCode());

        machineryToUpdate.setName(machinery.getName());
        machineryToUpdate.setReference(machinery.getReference());
        machineryToUpdate.setProductionCapacity(machinery.getProductionCapacity());
        machineryToUpdate.setBranchOfficeBean(branchOffice);
        machineryToUpdate.setMachineStateBean(machineState);
        machineryToUpdate.setHumanResourceBean(humanResource);
        machineryToUpdate.setMachineryTypeBean(machineryType);

        return save(machineryToUpdate);
    }

    @Override
    public void delete(int id) {
        Machinery machineryToDelete = getById(id);
        machineryRepository.delete(machineryToDelete);
    }
}
