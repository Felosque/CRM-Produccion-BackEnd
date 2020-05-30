package com.crmunibague.crmunibague.machineryprocesses;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MachineryProcessService {

    public MachineryProcess save(MachineryProcess machineryProcess);

    public List<MachineryProcess> getAll();

    public MachineryProcess getById(int id);

    public MachineryProcess update(int id, MachineryProcess machineryProcess);

    public void delete(int id);


}
