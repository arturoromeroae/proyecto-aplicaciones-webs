package cibertec.ecommerce.pe.ApiReservas.service;

import java.util.List;
import org.springframework.data.domain.Page;
import cibertec.ecommerce.pe.ApiReservas.entity.Reservas;
import java.util.Date;

public interface ReservaService {
    public List<Reservas> findAll();
    public Page<Reservas> findAll(int page, int size);
    public Page<Reservas> findByNomClienteContaining(String name,int page, int size);
    public Reservas findById(Long id);
    public Reservas findByNomCliente(String nomCliente);
    public Reservas findByTipoHabitacion(String tipoHabitacion);
    public Reservas findByDate(Date fechaInicioReserva);
    public Reservas add(Reservas reservas);
    public Reservas update(Long id, Reservas reservas);
    public void delete(Long id);
}
