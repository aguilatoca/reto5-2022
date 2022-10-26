package com.usa.misiontic23.masterclass5.repository.crud;

import org.springframework.data.repository.CrudRepository;
import com.usa.misiontic23.masterclass5.entity.Category;
import com.usa.misiontic23.masterclass5.entity.Client;

public interface ClientCrudRepository extends CrudRepository<Client,Integer> {
}
