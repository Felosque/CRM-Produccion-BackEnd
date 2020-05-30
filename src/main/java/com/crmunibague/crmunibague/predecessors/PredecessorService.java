package com.crmunibague.crmunibague.predecessors;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PredecessorService  {

    public Predecessor save(Predecessor predecessor);

    public List<Predecessor> getAll();

    public Predecessor getById(int id);

    public Predecessor update(int id, Predecessor predecessor);

    public void delete(int id);

}
