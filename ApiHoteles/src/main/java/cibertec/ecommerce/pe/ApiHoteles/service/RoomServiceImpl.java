package cibertec.ecommerce.pe.ApiHoteles.service;

import cibertec.ecommerce.pe.ApiHoteles.dao.RoomRepository;
import cibertec.ecommerce.pe.ApiHoteles.entity.Room;
import cibertec.ecommerce.pe.ApiHoteles.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomRepository roomRepository;

    @Override
    public Room add(Room room) {
        return roomRepository.save(room);
    }

    @Override
    public Room update(Long id, Room room) {
        Room DBRoom = roomRepository.findById(id).orElse(null);
        if (DBRoom != null) {
            DBRoom.setRoomType(room.getRoomType());
            DBRoom.setPrecio(room.getPrecio());
            DBRoom.setDisponibilidad(room.isDisponibilidad());
            DBRoom.setCapacidad(room.getCapacidad());
            return roomRepository.save(DBRoom);
        }
        return null;
    }

    @Override
    public Room findById(Long id) {
        return roomRepository
                .findById(id).orElseThrow(()
                -> new NotFoundException("No se encontró la habitacion con el id : " + id.toString()));
    }

    @Override
    public List<Room> findAll() {
        return roomRepository.findAll();
    }

    @Override
    public Page<Room> findAll(int page, int size) {
        return roomRepository.findAll(PageRequest.of(page, size));
    }

    @Override
    public void delete(Long id) {
        Room DBRoom = roomRepository.findById(id).get();
        roomRepository.delete(DBRoom);
    }

    @Override
    public Room findByRoomType(String tipo) {
        return roomRepository.findByRoomType(tipo).get();
    }
}
