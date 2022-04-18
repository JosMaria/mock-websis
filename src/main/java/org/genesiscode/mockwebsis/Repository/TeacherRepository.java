package org.genesiscode.mockwebsis.Repository;

import org.genesiscode.mockwebsis.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    void save(Teacher jorge, Teacher magda);
}
