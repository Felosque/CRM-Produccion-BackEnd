package com.crmunibague.crmunibague.rawmaterialrequests;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RawMaterialRequestsService {
    public RawMaterialRequests save(RawMaterialRequests rawMaterialRequests);

    public List<RawMaterialRequests> getAll();

    public RawMaterialRequests getById(int id);

    public RawMaterialRequests update(int id, RawMaterialRequests rawMaterialRequests);

    public void delete(int id);
}
