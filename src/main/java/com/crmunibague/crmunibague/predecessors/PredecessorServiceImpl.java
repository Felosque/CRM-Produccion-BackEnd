package com.crmunibague.crmunibague.predecessors;

import com.crmunibague.crmunibague.exceptions.ResourceNotFoundException;
import com.crmunibague.crmunibague.process.ProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PredecessorServiceImpl implements  PredecessorService{

    private PredecessorRepository predecessorRepository;


    @Autowired
    public PredecessorServiceImpl(PredecessorRepository predecessorRepository)
    {
        this.predecessorRepository = predecessorRepository;
    }

    @Override
    public Predecessor save(Predecessor predecessor) {
        return this.predecessorRepository.save(predecessor);
    }

    @Override
    public List<Predecessor> getAll() {
        return this.predecessorRepository.findAll();
    }

    @Override
    public Predecessor getById(int id) {
        return this.predecessorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("El predecesor con el ID: " + id + " no ha sido encontrado."));
    }

    @Override
    public Predecessor update(int id, Predecessor predecessor) {
        Predecessor predecessorToUpdate = getById(predecessor.getId().getCode());
        predecessorToUpdate.setId(predecessor.getId());
        return save(predecessorToUpdate);
    }

    @Override
    public void delete(int id) {
        Predecessor predecessorToDelete = getById(id);
        predecessorRepository.delete(predecessorToDelete);
    }
}
