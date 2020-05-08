package org.launchcode.thelonglist.data;

import org.launchcode.thelonglist.models.Plan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanRepository extends CrudRepository<Plan, Integer> {
}
