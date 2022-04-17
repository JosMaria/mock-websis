package org.genesiscode.mockwebsis.Repository;

import org.genesiscode.mockwebsis.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
}
