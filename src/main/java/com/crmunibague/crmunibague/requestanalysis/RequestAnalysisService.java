package com.crmunibague.crmunibague.requestanalysis;

import com.crmunibague.crmunibague.requeststatus.RequestStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RequestAnalysisService {

    public RequestAnalysis save(RequestAnalysis requestAnalysis);

    public List<RequestAnalysis> getAll();

    //public List<RequestAnalysis> getByRequestAnalysisCode(int code);

}
