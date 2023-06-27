package cibertec.ecommerce.pe.ApiHoteles.service;

import cibertec.ecommerce.pe.ApiHoteles.entity.Room;
import java.util.List;
import org.springframework.data.domain.Page;

public interface RoomService {

    public Room add(Room room);

    public Room update(Long id, Room room);

    public Room findById(Long id);

    public List<Room> findAll();

    public Page<Room> findAll(int page, int size);

    public void delete(Long id);

    public Room findByRoomType(String tipo);
}
