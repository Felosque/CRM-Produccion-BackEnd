package com.crmunibague.crmunibague.requestanalysis;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RequestAnalysiService {

    public RequestAnalysi save(RequestAnalysi requestAnalysi);

    public List<RequestAnalysi> getAll();

    public RequestAnalysi getById(RequestAnalysiPK id);

    public RequestAnalysi update(RequestAnalysiPK id, RequestAnalysi requestAnalysi);

    public void delete(RequestAnalysiPK id);

}
