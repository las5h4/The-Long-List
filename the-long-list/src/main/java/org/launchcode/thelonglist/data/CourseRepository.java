package org.launchcode.thelonglist.data;

import org.launchcode.thelonglist.models.Course;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends CrudRepository<Course, Integer> {
}
