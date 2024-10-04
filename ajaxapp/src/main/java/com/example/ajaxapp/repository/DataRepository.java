package com.example.ajaxapp.repository;


import com.example.ajaxapp.model.DataModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DataRepository extends MongoRepository<DataModel, String> {
}
