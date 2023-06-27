package cibertec.ecommerce.pe.ApiHoteles.dao;

import cibertec.ecommerce.pe.ApiHoteles.entity.Hotel;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {

    Optional<Hotel> findByCiudad(String ciudad);

    Optional<Hotel> findByEstrellas(int estrellas);

    Optional<Hotel> findByPais(String pais);

    Optional<Page<Hotel>> findByNomHotelContaining(String nomHotel, Pageable pageable);
}
