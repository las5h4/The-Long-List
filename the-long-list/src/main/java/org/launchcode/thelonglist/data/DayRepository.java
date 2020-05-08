package org.launchcode.thelonglist.data;

import org.launchcode.thelonglist.models.Day;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DayRepository extends CrudRepository<Day, Integer> {
}
