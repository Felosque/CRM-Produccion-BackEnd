package com.crmunibague.crmunibague.requestanalysis;

import com.crmunibague.crmunibague.requeststatus.RequestStatus;
import com.crmunibague.crmunibague.requeststatus.RequestStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequestAnalysisImpl implements RequestAnalysisService{

    private RequestAnalysisRepository requestAnalysisRepository;

    @Autowired
    public RequestAnalysisImpl(RequestAnalysisRepository requestAnalysisRepository) {
        this.requestAnalysisRepository = requestAnalysisRepository;
    }

    @Override
    public RequestAnalysis save(RequestAnalysis requestAnalysis) {
        return requestAnalysisRepository.save(requestAnalysis);
    }

    @Override
    public List<RequestAnalysis> getAll() {
        return requestAnalysisRepository.findAll();
    }

    @Override
    public List<RequestAnalysis> getByCode(Integer code) {
        return requestAnalysisRepository.findByRequestAnalysisPKCode(code);
    }

}
