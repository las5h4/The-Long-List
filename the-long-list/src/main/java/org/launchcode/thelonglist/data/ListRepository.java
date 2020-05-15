package org.launchcode.thelonglist.data;

import org.launchcode.thelonglist.models.GroceryList;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListRepository extends CrudRepository<GroceryList, Integer> {
}
