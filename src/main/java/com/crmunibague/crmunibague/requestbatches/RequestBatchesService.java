package com.crmunibague.crmunibague.requestbatches;

import com.crmunibague.crmunibague.requeststatus.RequestStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RequestBatchesService {

    public RequestBatches save(RequestBatches requestBatches);

    public List<RequestBatches> getAll();

    public RequestBatches getById(int code);

    public RequestBatches update(int code, RequestBatches requestBatches);

    public void delete(int code);
}
