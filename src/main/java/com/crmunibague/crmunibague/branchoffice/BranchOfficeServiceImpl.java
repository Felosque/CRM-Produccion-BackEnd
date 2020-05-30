package com.crmunibague.crmunibague.branchoffice;

import com.crmunibague.crmunibague.exceptions.ResourceNotFoundException;
import com.crmunibague.crmunibague.statebrachoffice.StateBranchOffice;
import com.crmunibague.crmunibague.statebrachoffice.StateBranchOfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BranchOfficeServiceImpl implements BranchOfficeService{

    private BranchOfficeRepository branchOfficeRepository;

    private StateBranchOfficeService stateBranchOfficeService;

    @Autowired
    public BranchOfficeServiceImpl(BranchOfficeRepository branchOfficeRepository, StateBranchOfficeService stateBranchOfficeService)
    {
        this.branchOfficeRepository = branchOfficeRepository;
        this.stateBranchOfficeService = stateBranchOfficeService;
    }

    @Override
    public BranchOffice save(BranchOffice branchOffice) {
        StateBranchOffice stateBranchOffice = stateBranchOfficeService.getById(branchOffice.getStateBrachOffice().getCode());
        branchOffice.setStateBrachOffice(stateBranchOffice);
        return this.branchOfficeRepository.save(branchOffice);
    }

    @Override
    public List<BranchOffice> getAll() {
        return this.branchOfficeRepository.findAll();
    }

    @Override
    public BranchOffice getById(int id) {
        return this.branchOfficeRepository.findById(id)
                .orElseThrow( () -> new ResourceNotFoundException("Student identified by id " + id + " Not Found"));
    }

    @Override
    public BranchOffice update(int id, BranchOffice branchOffice) {
        BranchOffice branchOfficeToUpdate = getById(id);
        branchOfficeToUpdate.setAddress(branchOffice.getAddress());
        branchOfficeToUpdate.setEnterpriseNit(branchOffice.getEnterpriseNit());
        return save(branchOfficeToUpdate);
    }

    @Override
    public void delete(int id) {
        BranchOffice branchOffice = getById(id);
        this.branchOfficeRepository.delete(branchOffice);
    }

}
