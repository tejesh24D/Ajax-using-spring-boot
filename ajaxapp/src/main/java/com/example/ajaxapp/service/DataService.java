package com.example.ajaxapp.service;


import com.example.ajaxapp.model.DataModel;
import com.example.ajaxapp.repository.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DataService {

    @Autowired
    private DataRepository repository;

    // Get all data sorted by name
    public List<DataModel> getAllData() {
        return repository.findAll().stream()
                .sorted(Comparator.comparing(DataModel::getName))  // Sort by name in ascending order
                .collect(Collectors.toList());
    }

    // Save new data
    public DataModel saveData(DataModel data) {
        return repository.save(data);
    }
}
