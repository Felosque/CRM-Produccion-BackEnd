package com.crmunibague.crmunibague.requestbatches;

import com.crmunibague.crmunibague.exceptions.ResourceNotFoundException;
import com.crmunibague.crmunibague.production.Production;
import com.crmunibague.crmunibague.production.ProductionService;
import com.crmunibague.crmunibague.requeststatus.RequestStatus;
import com.crmunibague.crmunibague.requeststatus.RequestStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequestBatchesImpl implements RequestBatchesService{

    private RequestBatchesRepository requestBatchesRepository;
    private ProductionService productionService;
    private RequestStatusService requestStatusService;

    @Autowired
    public RequestBatchesImpl(RequestBatchesRepository requestBatchesRepository, ProductionService productionService, RequestStatusService requestStatusService) {
        this.requestBatchesRepository = requestBatchesRepository;
        this.productionService = productionService;
        this.requestStatusService = requestStatusService;
    }

    @Override
    public RequestBatches save(RequestBatches requestBatches) {
        Production entity = this.productionService.getById(requestBatches.getProduction().getCode());
        return this.requestBatchesRepository.save(requestBatches);
    }

    @Override
    public List<RequestBatches> getAll() {
        return this.requestBatchesRepository.findAll();
    }

    @Override
    public RequestBatches getById(int code) {
        return this.requestBatchesRepository.findById(code).orElseThrow(() -> new ResourceNotFoundException("Request Batch with code: " +code +" | NOT FOUND."));
    }

    @Override
    public RequestBatches update(int code, RequestBatches requestBatches) {
        RequestBatches entity = this.getById(code);
        RequestStatus entityStatus = this.requestStatusService.getById(requestBatches.getState().getCode());
        Production entityProduction = this.productionService.getById(requestBatches.getProduction().getCode());
        entity.setCode(requestBatches.getCode());
        entity.setRequestDate(requestBatches.getRequestDate());
        entity.setProduction(entityProduction);
        entity.setState(entityStatus);
        return this.save(entity);
    }

    @Override
    public void delete(int code) {
        RequestBatches entity = this.getById(code);
        this.requestBatchesRepository.delete(entity);
    }
}
