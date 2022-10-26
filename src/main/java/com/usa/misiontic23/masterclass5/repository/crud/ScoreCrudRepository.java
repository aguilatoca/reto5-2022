package com.usa.misiontic23.masterclass5.repository.crud;

import org.springframework.data.repository.CrudRepository;
import com.usa.misiontic23.masterclass5.entity.Reservation;
import com.usa.misiontic23.masterclass5.entity.Score;

public interface ScoreCrudRepository extends CrudRepository<Score,Integer> {
}
