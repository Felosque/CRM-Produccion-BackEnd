package com.crmunibague.crmunibague.requeststatus;

import com.crmunibague.crmunibague.machinestate.MachineState;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RequestStatusService {

    public RequestStatus save(RequestStatus requestStatus);

    public List<RequestStatus> getAll();

    public RequestStatus getById(int id);

    public RequestStatus update(int id, RequestStatus requestStatus);

    public void delete(int id);

}
