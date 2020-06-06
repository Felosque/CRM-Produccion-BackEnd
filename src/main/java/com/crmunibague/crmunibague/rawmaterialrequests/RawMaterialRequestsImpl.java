package com.crmunibague.crmunibague.rawmaterialrequests;

import com.crmunibague.crmunibague.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RawMaterialRequestsImpl implements RawMaterialRequestsService{

    private RawMaterialRequestsRepository rawMaterialRequestsRepository;

    @Autowired
    public RawMaterialRequestsImpl(RawMaterialRequestsRepository rawMaterialRequestsRepository) {
        this.rawMaterialRequestsRepository = rawMaterialRequestsRepository;
    }

    @Override
    public RawMaterialRequests save(RawMaterialRequests rawMaterialRequests) {
        return this.rawMaterialRequestsRepository.save(rawMaterialRequests);
    }

    @Override
    public List<RawMaterialRequests> getAll() {
        return this.rawMaterialRequestsRepository.findAll();
    }

    @Override
    public RawMaterialRequests getById(int id) {
        return this.rawMaterialRequestsRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("The BranchOffice by id: " + id + " | NOT FOUND."));
    }

    @Override
    public RawMaterialRequests update(int id, RawMaterialRequests rawMaterialRequests) {
        RawMaterialRequests entity = this.getById(id);
        entity.setCode(rawMaterialRequests.getCode());
        entity.setNumberOrder(rawMaterialRequests.getNumberOrder());
        entity.setRequestDate(rawMaterialRequests.getRequestDate());
        entity.setState(rawMaterialRequests.getState());
        entity.setNumberBatch(rawMaterialRequests.getNumberBatch());
        return this.save(entity);
    }

    @Override
    public void delete(int id) {
        RawMaterialRequests entity = this.getById(id);
        this.rawMaterialRequestsRepository.delete(entity);
    }
}
