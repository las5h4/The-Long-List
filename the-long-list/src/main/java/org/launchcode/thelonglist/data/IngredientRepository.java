package org.launchcode.thelonglist.data;

import org.launchcode.thelonglist.models.Ingredient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IngredientRepository extends CrudRepository<Ingredient, Integer> {

    List<Ingredient> findAllByOrderByNameAsc();

}
