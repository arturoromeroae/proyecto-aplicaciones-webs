package cibertec.ecommerce.pe.ApiHoteles.service;

import cibertec.ecommerce.pe.ApiHoteles.dao.HotelRepository;
import cibertec.ecommerce.pe.ApiHoteles.entity.Hotel;
import cibertec.ecommerce.pe.ApiHoteles.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public Hotel add(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    @Override
    public Hotel update(Long id, Hotel hotel) {
        Hotel DBHotel = hotelRepository.findById(id).orElse(null);
        if (DBHotel != null) {
            DBHotel.setNomHotel(hotel.getNomHotel());
            DBHotel.setDireccion(hotel.getDireccion());
            DBHotel.setCiudad(hotel.getCiudad());
            DBHotel.setPais(hotel.getPais());
            DBHotel.setEstrellas(hotel.getEstrellas());
            DBHotel.setDescripcion(hotel.getDescripcion());
            return hotelRepository.save(DBHotel);
        }
        return null;
    }

    @Override
    public Hotel findById(Long id) {
        return hotelRepository
                .findById(id).orElseThrow(()
                -> new NotFoundException("No se encontró el hotel con el id : " + id.toString()));
    }

    @Override
    public List<Hotel> findAll() {
        return hotelRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        Hotel DBHotel = hotelRepository.findById(id).get();
        hotelRepository.delete(DBHotel);
    }

    @Override
    public Page<Hotel> findByNomHotelContaining(String nombre, int page, int size) {
        return hotelRepository.
                findByNomHotelContaining(nombre,
                        PageRequest.of(page, size)).get();
    }

    @Override
    public Hotel findByCiudad(String ciudad) {
        return hotelRepository.findByCiudad(ciudad).get();
    }

    @Override
    public Hotel findByEstrellas(int estrellas) {
        return hotelRepository.findByEstrellas(estrellas).get();
    }

    @Override
    public Hotel findByPais(String pais) {
        return hotelRepository.findByPais(pais).get();
    }

    @Override
    public Page<Hotel> findAll(int page, int size) {
        return hotelRepository.findAll(PageRequest.of(page, size));
    }
}
