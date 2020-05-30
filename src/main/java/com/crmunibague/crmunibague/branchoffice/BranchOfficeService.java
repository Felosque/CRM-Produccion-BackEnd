package com.crmunibague.crmunibague.branchoffice;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BranchOfficeService {

    public BranchOffice save(BranchOffice branchOffice);

    public List<BranchOffice> getAll();

    public BranchOffice getById(int id);

    public BranchOffice update(int id, BranchOffice branchOffice);

    public void delete(int id);

}
