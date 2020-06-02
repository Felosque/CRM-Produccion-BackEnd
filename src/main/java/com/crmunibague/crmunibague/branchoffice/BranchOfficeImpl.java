package com.crmunibague.crmunibague.branchoffice;

import com.crmunibague.crmunibague.exceptions.ResourceNotFoundException;
import com.crmunibague.crmunibague.statebranchoffice.StateBranchOffice;
import com.crmunibague.crmunibague.statebranchoffice.StateBranchOfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BranchOfficeImpl implements BranchOfficeService{

    private BranchOfficeRepository branchOfficeRepository;

    private StateBranchOfficeService stateBranchOfficeService;

    @Autowired
    public BranchOfficeImpl(BranchOfficeRepository branchOfficeRepository, StateBranchOfficeService stateBranchOfficeService) {
        this.branchOfficeRepository = branchOfficeRepository;
        this.stateBranchOfficeService = stateBranchOfficeService;
    }

    @Override
    public BranchOffice save(BranchOffice branchOffice) {
        StateBranchOffice state = this.stateBranchOfficeService.getById(branchOffice.getStateBranchOffice().getCode());
        return this.branchOfficeRepository.save(branchOffice);
    }

    @Override
    public List<BranchOffice> getAll() {
        return this.branchOfficeRepository.findAll();
    }

    @Override
    public BranchOffice getById(int id) {
        return this.branchOfficeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("The BranchOffice by id: " + id + " | NOT FOUND."));
    }

    @Override
    public BranchOffice update(int id, BranchOffice branchOffice) {
        BranchOffice entity = this.getById(id);
        entity.setCode(branchOffice.getCode());
        entity.setAddress(branchOffice.getAddress());
        entity.setEnterpriseNit(branchOffice.getEnterpriseNit());
        entity.setStateBranchOffice(branchOffice.getStateBranchOffice());
        return this.save(entity);
    }

    @Override
    public void delete(int id) {
        BranchOffice entity = this.getById(id);
        this.branchOfficeRepository.delete(entity);
    }
}
