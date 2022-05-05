package org.genesiscode.mockwebsis.repository;

import org.genesiscode.mockwebsis.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    @Query("SELECT teacher " +
            "FROM Teacher teacher " +
            "WHERE teacher.email = :email")
    Optional<Teacher> findByEmail(@Param("email") String email);
}
