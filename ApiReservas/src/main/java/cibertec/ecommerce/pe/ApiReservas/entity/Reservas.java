package cibertec.ecommerce.pe.ApiReservas.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.util.Date;
import lombok.Data;

@Entity
@Data
public class Reservas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomCliente;
    private String tipoHabitacion;
    private int cantPersonas;
    @Temporal(TemporalType.DATE)
    private Date fechaInicioReserva;
    @Temporal(TemporalType.DATE)
    private Date fechaFinReserva;
}
