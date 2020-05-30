package com.crmunibague.crmunibague.machinerytypes;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MachineryTypeService {

    public MachineryType save(MachineryType machineryType);

    public List<MachineryType> getAll();

    public MachineryType getById(int id);

    public MachineryType update(int id, MachineryType machineryType);

    public void delete(int id);
}
