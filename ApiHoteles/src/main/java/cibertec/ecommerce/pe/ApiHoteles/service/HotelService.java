package cibertec.ecommerce.pe.ApiHoteles.service;

import cibertec.ecommerce.pe.ApiHoteles.entity.Hotel;
import java.util.List;
import org.springframework.data.domain.Page;

public interface HotelService {

    public Hotel add(Hotel hotel);

    public Hotel update(Long id, Hotel hotel);

    public Hotel findById(Long id);

    public List<Hotel> findAll();

    public Page<Hotel> findAll(int page, int size);

    public void delete(Long id);

    public Page<Hotel> findByNomHotelContaining(String nombre, int page, int size);

    public Hotel findByCiudad(String ciudad);

    public Hotel findByEstrellas(int estrellas);

    public Hotel findByPais(String pais);

}
