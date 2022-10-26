package com.usa.misiontic23.masterclass5.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.usa.misiontic23.masterclass5.entity.Box;
import com.usa.misiontic23.masterclass5.repository.BoxRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BoxService {

    @Autowired
    private BoxRepository boxRepository;

    public List<Box> getAll(){
        return boxRepository.getAll();
    }

    public Optional<Box>getById(int id){
        return boxRepository.getById(id);
    }

    public Box save(Box c){
        if(c.getId()==null){
            return boxRepository.save(c);
        }
        return c;
    }
    public boolean delete(int id){
        Optional<Box> cOp= boxRepository.getById(id);
        if(cOp.isPresent()){
            boxRepository.delete(cOp.get());
            return true;
        }
        return false;
    }
    public Box update(Box c){
        if(c.getId()!=null){
            Optional<Box> old= boxRepository.getById(c.getId());
            if(old.isPresent()){
                Box k=old.get();
                if(c.getName()!=null){
                    k.setName(c.getName());
                }
                if(c.getDescription()!=null){
                    k.setDescription(c.getDescription());
                }
                if(c.getLocation()!=null){
                    k.setLocation(c.getLocation());
                }
                if(c.getCapacity()!=null){
                    k.setCapacity(c.getCapacity());
                }
                if(c.getCategory()!=null){
                    k.setCategory(c.getCategory());
                }
                return boxRepository.save(k);
            }
        }
        return c;
    }
}
