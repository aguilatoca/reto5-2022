package com.usa.misiontic23.masterclass5.repository.crud;

import org.springframework.data.repository.CrudRepository;
import com.usa.misiontic23.masterclass5.entity.Message;

public interface MessageCrudRepository extends CrudRepository<Message,Integer> {
}
