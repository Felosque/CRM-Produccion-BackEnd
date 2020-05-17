package com.crmunibague.crmunibague.statebrachoffice;

import com.crmunibague.crmunibague.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StateBrachOfficeImpl implements StateBrachOfficeService {

    private StateBrachOfficeRepository stateBrachOfficeRepository;

    @Autowired
    public StateBrachOfficeImpl(StateBrachOfficeRepository stateBrachOfficeRepository) {
        this.stateBrachOfficeRepository = stateBrachOfficeRepository;
    }

    @Override
    public StateBrachOffice save(StateBrachOffice stateBrachOffice) {
        return stateBrachOfficeRepository.save(stateBrachOffice);
    }

    @Override
    public List<StateBrachOffice> getAll() {
        return stateBrachOfficeRepository.findAll();
    }

    @Override
    public StateBrachOffice getById(int id) {
        return stateBrachOfficeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("StateBranchOffice with id:" + id + " not found." ));
    }

    @Override
    public StateBrachOffice update(int id, StateBrachOffice stateBrachOffice) {
        StateBrachOffice entityToUpdate = getById(id);
        entityToUpdate.setCode(stateBrachOffice.getCode());
        entityToUpdate.setDescription(stateBrachOffice.getDescription());
        return save(entityToUpdate);
    }

    @Override
    public void delete(int id) {
        StateBrachOffice entityToDelete = this.getById(id);
        this.stateBrachOfficeRepository.delete(entityToDelete);
    }
}
