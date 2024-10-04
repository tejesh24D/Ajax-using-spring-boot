package com.example.ajaxapp.controller;



import com.example.ajaxapp.model.DataModel;
import com.example.ajaxapp.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/data")
public class DataController {

    @Autowired
    private DataService dataService;

    // Get all data sorted alphabetically by name
    @GetMapping
    public List<DataModel> getAllData() {
        return dataService.getAllData();
    }

    // Save new data
    @PostMapping
    public DataModel saveData(@RequestBody DataModel dataModel) {
        return dataService.saveData(dataModel);
    }
}
