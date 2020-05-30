package com.crmunibague.crmunibague.requestanalysis;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RequestAnalysiService {

    public RequestAnalysi save(RequestAnalysi requestAnalysi);

    public List<RequestAnalysi> getAll();

    public RequestAnalysi getById(int id);

    public RequestAnalysi update(int id, RequestAnalysi requestAnalysi);

    public void delete(int id);

}
