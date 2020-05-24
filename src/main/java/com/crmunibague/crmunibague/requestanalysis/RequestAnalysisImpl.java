package com.crmunibague.crmunibague.requestanalysis;

import com.crmunibague.crmunibague.exceptions.ResourceNotFoundException;
import com.crmunibague.crmunibague.requeststatus.RequestStatus;
import com.crmunibague.crmunibague.requeststatus.RequestStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequestAnalysisImpl implements RequestAnalysisService{

    private RequestAnalysisRepository requestAnalysisRepository;
    private RequestStatusService requestStatusService;

    @Autowired
    public RequestAnalysisImpl(RequestAnalysisRepository requestAnalysisRepository, RequestStatusService requestStatusService) {
        this.requestAnalysisRepository = requestAnalysisRepository;
        this.requestStatusService = requestStatusService;
    }

    @Override
    public RequestAnalysis save(RequestAnalysis requestAnalysis) {
        RequestStatus request = this.requestStatusService.getById(requestAnalysis.getRequestStatus().getCode());
        return this.requestAnalysisRepository.save(requestAnalysis);
    }

    @Override
    public List<RequestAnalysis> getAll() {
        return this.requestAnalysisRepository.findAll();
    }

    @Override
    public RequestAnalysis getById(int id) {
        return this.requestAnalysisRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("The RequestAnalysis identified by id:" + id +" | NOT FOUND"));
    }

    @Override
    public RequestAnalysis update(int id, RequestAnalysis requestAnalysis) {
        RequestAnalysis entity = this.getById(id);
        entity.setCode(requestAnalysis.getCode());
        entity.setRequestStatus(requestAnalysis.getRequestStatus());
        return this.save(entity);
    }

    @Override
    public void delete(int id) {
        RequestAnalysis entity =this.getById(id);
        this.requestAnalysisRepository.delete(entity);
    }
}
