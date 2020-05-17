package com.crmunibague.crmunibague.statebrachoffice;

import com.crmunibague.crmunibague.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StateBranchOfficeImpl implements StateBranchOfficeService {

    private StateBranchOfficeRepository stateBranchOfficeRepository;

    @Autowired
    public StateBranchOfficeImpl(StateBranchOfficeRepository stateBranchOfficeRepository) {
        this.stateBranchOfficeRepository = stateBranchOfficeRepository;
    }

    @Override
    public StateBranchOffice save(StateBranchOffice stateBranchOffice) {
        return stateBranchOfficeRepository.save(stateBranchOffice);
    }

    @Override
    public List<StateBranchOffice> getAll() {
        return stateBranchOfficeRepository.findAll();
    }

    @Override
    public StateBranchOffice getById(int id) {
        return stateBranchOfficeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("StateBranchOffice with id:" + id + " not found." ));
    }

    @Override
    public StateBranchOffice update(int id, StateBranchOffice stateBranchOffice) {
        StateBranchOffice entityToUpdate = getById(id);
        entityToUpdate.setCode(stateBranchOffice.getCode());
        entityToUpdate.setDescription(stateBranchOffice.getDescription());
        return save(entityToUpdate);
    }

    @Override
    public void delete(int id) {
        StateBranchOffice entityToDelete = this.getById(id);
        this.stateBranchOfficeRepository.delete(entityToDelete);
    }
}
