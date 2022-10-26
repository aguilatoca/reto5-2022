package com.usa.misiontic23.masterclass5.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.usa.misiontic23.masterclass5.entity.Category;
import com.usa.misiontic23.masterclass5.repository.crud.CategoryCrudRepository;

import java.util.List;
import java.util.Optional;

@Repository
public class CategoryRepository {

    @Autowired
    private CategoryCrudRepository categoryCrudRepository;

    public List<Category> getAll(){
        return (List<Category>) categoryCrudRepository.findAll();
    }
    public Optional<Category> getById(int id){
        return categoryCrudRepository.findById(id);
    }
    public Category save(Category c){
        return categoryCrudRepository.save(c);
    }
    public void delete(Category c){
        categoryCrudRepository.delete(c);
    }

}
