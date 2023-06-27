package cibertec.ecommerce.pe.ApiReservas.service;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import cibertec.ecommerce.pe.ApiReservas.entity.Reservas;
import cibertec.ecommerce.pe.ApiReservas.exception.NotFoundException;
import cibertec.ecommerce.pe.ApiReservas.dao.ReservasRepository;

@Service
public class ReservaServiceImpl implements ReservaService {
    @Autowired
    private ReservasRepository reservasRepository;

    @Override
    public List<Reservas> findAll() {
        return (List<Reservas>) reservasRepository.findAll();
    }

    @Override
    public Page<Reservas> findAll(int page, int size) {
        return reservasRepository.findAll(PageRequest.of(page, size));
    }

    @Override
    public Page<Reservas> findByNomClienteContaining(String name, int page, int size) {
        return reservasRepository.
                findByNomClienteContaining(name, PageRequest.of(page, size)).get();
    }

    @Override
    public Reservas findById(Long id) {
        return reservasRepository.findById(id).
                orElseThrow(()-> 
        new NotFoundException("No se encontró la reserva con id : "+id.toString())) ;  
    }

    @Override
    public Reservas findByNomCliente(String nomCliente) {
        return reservasRepository.findByNomCliente(nomCliente).get();
    }

    @Override
    public Reservas findByTipoHabitacion(String tipoHabitacion) {
        return reservasRepository.findByTipoHabitacion(tipoHabitacion).get();
    }

    @Override
    public Reservas findByDate(Date fechaInicioReserva) {
        return reservasRepository.findByDate(fechaInicioReserva).get();
    }

    @Override
    public Reservas add(Reservas reservas) {
        return reservasRepository.save(reservas);
    }

    @Override
    public Reservas update(Long id, Reservas reservas) {
        Reservas reservasDB = reservasRepository.findById(id).get();
        reservasDB.setNomCliente(reservas.getNomCliente());
        reservasDB.setCantPersonas(reservas.getCantPersonas());
        reservasDB.setFechaInicioReserva(reservas.getFechaInicioReserva());
        reservas.setFechaFinReserva(reservas.getFechaFinReserva());
        reservasDB.setTipoHabitacion(reservas.getTipoHabitacion());
        return reservasRepository.save(reservasDB);
    }

    @Override
    public void delete(Long id) {
        Reservas reservasDB = reservasRepository.findById(id).get();
        reservasRepository.delete(reservasDB);
    }

}
