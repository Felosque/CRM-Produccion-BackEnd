package com.crmunibague.crmunibague.requestdetailsrawmaterial;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RequestDetailsRawMaterialService {

    public List<RequestDetailsRawMaterial> getAll();

    public RequestDetailsRawMaterial save(RequestDetailsRawMaterial requestDetailsRawMaterial);

    public RequestDetailsRawMaterial getById(int id);

    public RequestDetailsRawMaterial update(int id, RequestDetailsRawMaterial requestDetailsRawMaterial);

    public void delete(int id);

}
