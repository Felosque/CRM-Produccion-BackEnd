package com.crmunibague.crmunibague.requestbatches;

import com.crmunibague.crmunibague.exceptions.ResourceNotFoundException;
import com.crmunibague.crmunibague.production.Production;
import com.crmunibague.crmunibague.production.ProductionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequestBatchesImpl implements RequestBatchesService{

    private RequestBatchesRepository requestBatchesRepository;
    private ProductionService productionService;

    @Autowired
    public RequestBatchesImpl(RequestBatchesRepository requestBatchesRepository, ProductionService productionService) {
        this.requestBatchesRepository = requestBatchesRepository;
        this.productionService = productionService;
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
        entity.setCode(requestBatches.getCode());
        entity.setProduction(requestBatches.getProduction());
        entity.setRequestDate(requestBatches.getRequestDate());
        entity.setRequestAnalysis(requestBatches.getRequestAnalysis());
        return this.save(entity);
    }

    @Override
    public void delete(int code) {
        RequestBatches entity = this.getById(code);
        this.requestBatchesRepository.delete(entity);
    }
}
