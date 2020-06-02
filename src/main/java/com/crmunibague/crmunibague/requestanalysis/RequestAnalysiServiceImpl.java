package com.crmunibague.crmunibague.requestanalysis;

import com.crmunibague.crmunibague.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequestAnalysiServiceImpl implements RequestAnalysiService {

    private RequestAnalysiRepository requestAnalysiRepository;

    @Autowired
    public RequestAnalysiServiceImpl(RequestAnalysiRepository requestAnalysiRepository)
    {
        this.requestAnalysiRepository = requestAnalysiRepository;
    }

    @Override
    public RequestAnalysi save(RequestAnalysi requestAnalysi) {
        return requestAnalysiRepository.save(requestAnalysi);
    }

    @Override
    public List<RequestAnalysi> getAll() {
        return requestAnalysiRepository.findAll();
    }

    @Override
    public RequestAnalysi getById(RequestAnalysiPK id) {
        return this.requestAnalysiRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("El Request Analysis con el ID: " + id + " no ha sido encontrado."));

    }

    @Override
    public RequestAnalysi update(RequestAnalysiPK id, RequestAnalysi requestAnalysi) {
        RequestAnalysi requestAnalysiToUpdate = getById(id);
        return save(requestAnalysiToUpdate);
    }

    @Override
    public void delete(RequestAnalysiPK id) {
        RequestAnalysi requestAnalysiToDelete = getById(id);
        requestAnalysiRepository.delete(requestAnalysiToDelete);
    }
}
