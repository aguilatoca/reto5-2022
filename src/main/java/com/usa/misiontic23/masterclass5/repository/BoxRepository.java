package com.usa.misiontic23.masterclass5.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.usa.misiontic23.masterclass5.entity.Box;
import com.usa.misiontic23.masterclass5.repository.crud.BoxCrudRepository;

import java.util.List;
import java.util.Optional;

@Repository
public class BoxRepository {

    @Autowired
    private BoxCrudRepository boxCrudRepository;

    public List<Box> getAll(){
        return (List<Box>) boxCrudRepository.findAll();
    }
    public Optional<Box> getById(int id){
        return boxCrudRepository.findById(id);
    }
    public Box save(Box c){
        return boxCrudRepository.save(c);
    }
    public void delete(Box c){
        boxCrudRepository.delete(c);
    }

}
