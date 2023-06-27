package cibertec.ecommerce.pe.ApiHoteles.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;
import lombok.Data;

@Entity
@Data
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomHotel;
    private String direccion;
    private String ciudad;
    private String pais;
    private int estrellas;
    private String descripcion;
}
