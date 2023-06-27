package cibertec.ecommerce.pe.ApiHoteles.dao;

import cibertec.ecommerce.pe.ApiHoteles.entity.Room;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {

    Optional<Room> findByRoomType(String tipo);
}
