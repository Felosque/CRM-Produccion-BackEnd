package com.crmunibague.crmunibague.statebrachoffice;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StateBranchOfficeService {

    public StateBranchOffice save(StateBranchOffice stateBranchOffice);

    public List<StateBranchOffice> getAll();

    public StateBranchOffice getById(int id);

    public StateBranchOffice update(int id, StateBranchOffice stateBranchOffice);

    public void delete(int id);
}
