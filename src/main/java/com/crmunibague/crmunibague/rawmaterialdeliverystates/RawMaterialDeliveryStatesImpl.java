package com.crmunibague.crmunibague.rawmaterialdeliverystates;

import com.crmunibague.crmunibague.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RawMaterialDeliveryStatesImpl implements RawMaterialDeliveryStatesService{

    private RawMaterialDeliveryStatesRepository rawMaterialDeliveryStatesRepository;

    @Autowired
    public RawMaterialDeliveryStatesImpl(RawMaterialDeliveryStatesRepository rawMaterialDeliveryStatesRepository) {
        this.rawMaterialDeliveryStatesRepository = rawMaterialDeliveryStatesRepository;
    }

    @Override
    public List<RawMaterialDeliveryStates> getAll() {
        return this.rawMaterialDeliveryStatesRepository.findAll();
    }

    @Override
    public RawMaterialDeliveryStates save(RawMaterialDeliveryStates rawMaterialDeliveryStates) {
        return this.rawMaterialDeliveryStatesRepository.save(rawMaterialDeliveryStates);
    }

    @Override
    public RawMaterialDeliveryStates getById(int id) {
        return this.rawMaterialDeliveryStatesRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("El estado buscado por el id: " +id+" | NOT FOUND"));
    }

    @Override
    public RawMaterialDeliveryStates update(int id, RawMaterialDeliveryStates rawMaterialDeliveryStates) {
        RawMaterialDeliveryStates entity = this.getById(id);
        entity.setDateDelivery(rawMaterialDeliveryStates.getDateDelivery());
        entity.setDeliveryStock(rawMaterialDeliveryStates.getDeliveryStock());

        return this.save(entity);
    }

    @Override
    public void delete(int id) {
        RawMaterialDeliveryStates entity = this.getById(id);
        this.rawMaterialDeliveryStatesRepository.delete(entity);
    }
}
