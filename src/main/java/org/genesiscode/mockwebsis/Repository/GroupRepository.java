package org.genesiscode.mockwebsis.Repository;

import org.genesiscode.mockwebsis.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends JpaRepository<Group, String> {
}
