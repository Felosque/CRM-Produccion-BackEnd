package com.crmunibague.crmunibague.process_product;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProcessService {

    public Process save(Process process);

    public List<Process> getAll();

    public Process getById(int id);

    public Process update(int id, Process process);

    public void delete(int id);

}
