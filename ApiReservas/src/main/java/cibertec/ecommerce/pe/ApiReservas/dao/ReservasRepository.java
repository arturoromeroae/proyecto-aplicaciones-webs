package cibertec.ecommerce.pe.ApiReservas.dao;

import java.util.Date;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import cibertec.ecommerce.pe.ApiReservas.entity.Reservas;
import java.util.Optional;

//paginacion
public interface ReservasRepository extends JpaRepository<Reservas, Long>{
    Optional<Reservas> findByNomCliente(String nomCliente);
    @Query("select r from Reservas r where r.fechaInicioReserva = ?1")
    Optional<Reservas> findByDate(Date fechaInicioReserva);    
    Optional<Reservas> findByTipoHabitacion(String tipoHabitacion);
    Optional<Page<Reservas>> findByNomClienteContaining(String name, Pageable pageable);
}
