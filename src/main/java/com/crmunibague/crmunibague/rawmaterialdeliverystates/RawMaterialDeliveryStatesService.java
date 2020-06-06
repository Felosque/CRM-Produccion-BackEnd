package com.crmunibague.crmunibague.rawmaterialdeliverystates;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RawMaterialDeliveryStatesService {

    public List<RawMaterialDeliveryStates> getAll();

    public RawMaterialDeliveryStates save(RawMaterialDeliveryStates rawMaterialDeliveryStates);

    public RawMaterialDeliveryStates getById(int id);

    public RawMaterialDeliveryStates update(int id, RawMaterialDeliveryStates rawMaterialDeliveryStates);

    public void delete(int id);
}
