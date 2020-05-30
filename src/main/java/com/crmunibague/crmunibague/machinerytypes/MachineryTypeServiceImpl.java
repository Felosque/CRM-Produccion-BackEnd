package com.crmunibague.crmunibague.machinerytypes;

import com.crmunibague.crmunibague.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MachineryTypeServiceImpl implements MachineryTypeService{

    private MachineryTypeRepository machineryTypeRepository;

    @Autowired
    public MachineryTypeServiceImpl(MachineryTypeRepository machineryTypeRepository) {
        this.machineryTypeRepository = machineryTypeRepository;
    }

    @Override
    public MachineryType save(MachineryType machineryType) {
        return this.machineryTypeRepository.save(machineryType);
    }

    @Override
    public List<MachineryType> getAll() {
        return machineryTypeRepository.findAll();
    }

    @Override
    public MachineryType getById(int id) {
        return this.machineryTypeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("El tipo de maquina con el ID: " + id + " no ha sido encontrado."));
    }

    @Override
    public MachineryType update(int id, MachineryType machineryType) {
        MachineryType machineryTypeToUpdate = getById(machineryType.getCode());
        machineryTypeToUpdate.setDescription(machineryType.getDescription());
        return save(machineryTypeToUpdate);
    }

    @Override
    public void delete(int id) {
        MachineryType machineryTypeToDelete = getById(id);
        machineryTypeRepository.delete(machineryTypeToDelete);
    }
}
