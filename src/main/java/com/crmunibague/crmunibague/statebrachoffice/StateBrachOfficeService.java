package com.crmunibague.crmunibague.statebrachoffice;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StateBrachOfficeService {

    public StateBrachOffice save(StateBrachOffice stateBrachOffice);

    public List<StateBrachOffice> getAll();

    public StateBrachOffice getById(int id);

    public StateBrachOffice update(int id, StateBrachOffice stateBrachOffice);

    public void delete(int id);
}
