package com.crmunibague.crmunibague.machinery;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MachineryService {

    public Machinery save(Machinery machinery);

    public List<Machinery> getAll();

    public Machinery getById(int id);

    public Machinery update(int id, Machinery machinery);

    public List<Machinery> getByState(int id);

    public void delete(int id);

}
