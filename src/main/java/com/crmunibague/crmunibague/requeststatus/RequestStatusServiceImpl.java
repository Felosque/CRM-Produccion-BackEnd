package com.crmunibague.crmunibague.requeststatus;

import com.crmunibague.crmunibague.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequestStatusServiceImpl implements RequestStatusService {

    private RequestStatusRepository requestStatusRepository;

    @Autowired
    public RequestStatusServiceImpl(RequestStatusRepository requestStatusRepository) {
        this.requestStatusRepository = requestStatusRepository;
    }

    @Override
    public RequestStatus save(RequestStatus requestStatus) {
        return this.requestStatusRepository.save(requestStatus);
    }

    @Override
    public List<RequestStatus> getAll() {
        return this.requestStatusRepository.findAll();
    }

    @Override
    public RequestStatus getById(int id) {
        return this.requestStatusRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("RequestStatus by id: " + id + " | NOT FOUND"));
    }

    @Override
    public RequestStatus update(int id, RequestStatus requestStatus) {
        RequestStatus entity = this.getById(id);
        entity.setCode(requestStatus.getCode());
        entity.setDescription(requestStatus.getDescription());
        return this.save(entity);
    }

    @Override
    public void delete(int id) {
        RequestStatus entity = this.getById(id);
        this.requestStatusRepository.delete(entity);
    }
}
