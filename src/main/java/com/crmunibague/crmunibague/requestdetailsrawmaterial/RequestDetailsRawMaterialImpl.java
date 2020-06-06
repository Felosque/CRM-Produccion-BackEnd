package com.crmunibague.crmunibague.requestdetailsrawmaterial;

import com.crmunibague.crmunibague.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class RequestDetailsRawMaterialImpl implements RequestDetailsRawMaterialService{

    private RequestDetailsRawMaterialRepository requestDetailsRawMaterialRepository;

    @Autowired
    public RequestDetailsRawMaterialImpl(RequestDetailsRawMaterialRepository requestDetailsRawMaterialRepository) {
        this.requestDetailsRawMaterialRepository = requestDetailsRawMaterialRepository;
    }

    @Override
    public List<RequestDetailsRawMaterial> getAll() {
        return this.requestDetailsRawMaterialRepository.findAll();
    }

    @Override
    public RequestDetailsRawMaterial save(RequestDetailsRawMaterial requestDetailsRawMaterial) {
        return this.requestDetailsRawMaterialRepository.save(requestDetailsRawMaterial);
    }

    @Override
    public RequestDetailsRawMaterial getById(int id) {
        return this.requestDetailsRawMaterialRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("The BranchOffice by id: " + id + " | NOT FOUND."));
    }

    @Override
    public RequestDetailsRawMaterial update(int id, RequestDetailsRawMaterial requestDetailsRawMaterial) {
        RequestDetailsRawMaterial entity = this.getById(id);

        entity.setDeliveryDeadlineDate(requestDetailsRawMaterial.getDeliveryDeadlineDate());
        entity.setRequestAmount(requestDetailsRawMaterial.getRequestAmount());

        return this.save(entity);
    }

    @Override
    public void delete(int id) {
        RequestDetailsRawMaterial entity = this.getById(id);
        this.requestDetailsRawMaterialRepository.delete(entity);
    }
}
