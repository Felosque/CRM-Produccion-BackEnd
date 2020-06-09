package com.crmunibague.crmunibague.requestdetailsrawmaterial;

import com.crmunibague.crmunibague.exceptions.ResourceNotFoundException;
import com.crmunibague.crmunibague.rawmaterialrequests.RawMaterialRequests;
import com.crmunibague.crmunibague.rawmaterialrequests.RawMaterialRequestsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequestDetailsRawMaterialImpl implements RequestDetailsRawMaterialService{

    private RequestDetailsRawMaterialRepository requestDetailsRawMaterialRepository;
    private RawMaterialRequestsService rawMaterialRequestsService;

    @Autowired
    public RequestDetailsRawMaterialImpl(RequestDetailsRawMaterialRepository requestDetailsRawMaterialRepository, RawMaterialRequestsService rawMaterialRequestsService) {
        this.requestDetailsRawMaterialRepository = requestDetailsRawMaterialRepository;
        this.rawMaterialRequestsService = rawMaterialRequestsService;
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
        entity.setDescription(requestDetailsRawMaterial.getDescription());

        return this.save(entity);
    }

    @Override
    public void delete(int id) {
        RequestDetailsRawMaterial entity = this.getById(id);
        this.requestDetailsRawMaterialRepository.delete(entity);
    }

    @Override
    public List<RequestDetailsRawMaterial> getAllByRawMaterialRequestCode(int id) {
        RawMaterialRequests entity = this.rawMaterialRequestsService.getById(id);
        return this.requestDetailsRawMaterialRepository.findByRawMaterialRequests(entity);
    }
}
