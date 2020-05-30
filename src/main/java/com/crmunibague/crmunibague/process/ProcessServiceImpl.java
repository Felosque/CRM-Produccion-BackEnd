package com.crmunibague.crmunibague.process;

import com.crmunibague.crmunibague.exceptions.ResourceNotFoundException;
import com.crmunibague.crmunibague.product.Product;
import com.crmunibague.crmunibague.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProcessServiceImpl implements  ProcessService{

    private ProductService productService;

    private ProcessRepository processRepository;

    @Autowired
    public ProcessServiceImpl(ProductService productService, ProcessRepository processRepository)
    {
        this.processRepository = processRepository;
        this.productService = productService;
    }


    @Override
    public Process save(Process process) {
        Product product = productService.getByID(process.getProduct().getCode());
        process.setProduct(product);
        return this.processRepository.save(process);
    }

    @Override
    public List<Process> getAll() {
        return this.processRepository.findAll();
    }

    @Override
    public Process getById(int id) {
        return this.processRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("El proceso con el ID: " + id + " no ha sido encontrado."));
    }

    @Override
    public Process update(int id, Process process) {
        Product productFound = productService.getByID(process.getProduct().getCode());

        Process processToUpdate = getById(id);
        processToUpdate.setProduct(productFound);
        processToUpdate.setProcessName(process.getProcessName());
        processToUpdate.setProcessOrder(process.getProcessOrder());
        processToUpdate.setProcessTime(process.getProcessTime());
        processToUpdate.setStockProduced(process.getStockProduced());

        return save(processToUpdate);
    }

    @Override
    public void delete(int id) {
        Process processToDelete = getById(id);
        this.processRepository.delete(processToDelete);
    }
}
