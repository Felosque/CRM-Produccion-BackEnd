package com.crmunibague.crmunibague.machineryprocesses;

import com.crmunibague.crmunibague.exceptions.ResourceNotFoundException;
import com.crmunibague.crmunibague.machinerytypes.MachineryType;
import com.crmunibague.crmunibague.machinerytypes.MachineryTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MachineryProcessServiceImpl implements MachineryProcessService{

    private MachineryProcessRepository machineryProcessRepository;

    private MachineryTypeService machineryTypeService;

    @Autowired
    public MachineryProcessServiceImpl(MachineryProcessRepository machineryProcessRepository, MachineryTypeService machineryTypeService)
    {
        this.machineryProcessRepository = machineryProcessRepository;
        this.machineryTypeService = machineryTypeService;
    }

    @Override
    public MachineryProcess save(MachineryProcess machineryProcess) {
        MachineryType machineryType = machineryTypeService.getById(machineryProcess.getMachineryTypeBean().getCode());
        machineryProcess.setMachineryTypeBean(machineryType);
        return machineryProcessRepository.save(machineryProcess);
    }

    @Override
    public List<MachineryProcess> getAll() {
        return machineryProcessRepository.findAll();
    }

    @Override
    public MachineryProcess getById(int id) {
        return this.machineryProcessRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("MachineryProcess con el ID: " + id + " no ha sido encontrado."));

    }

    @Override
    public MachineryProcess update(int id, MachineryProcess machineryProcess) {
        MachineryProcess machineryProcessToUpdate = getById(id);
        machineryProcessToUpdate.setMachineryTypeBean(machineryProcess.getMachineryTypeBean());
        return save(machineryProcess);
    }

    @Override
    public void delete(int id) {
        MachineryProcess machineryProcessToDelete = getById(id);
        machineryProcessRepository.delete(machineryProcessToDelete);
    }

}
