package com.crmunibague.crmunibague.requestanalysis;

import com.crmunibague.crmunibague.requeststatus.RequestStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RequestAnalysisService {

    public RequestAnalysis save(RequestAnalysis requestAnalysis);

    public List<RequestAnalysis> getAll();

    public RequestAnalysis getById(int id);

    public RequestAnalysis update(int id, RequestAnalysis requestAnalysis);

    public void delete(int id);
}
