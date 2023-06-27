package cibertec.ecommerce.pe.ApiReservas.controller;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import cibertec.ecommerce.pe.ApiReservas.service.ReservaService;
import cibertec.ecommerce.pe.ApiReservas.entity.Reservas;
import jakarta.validation.Valid;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.springframework.validation.annotation.Validated;

@RestController
@RequestMapping("/api/reservas")
@Validated
public class ReservasController {

    @Autowired
    ReservaService reservaService;

    @GetMapping("/findAll")
    public ResponseEntity<List<Reservas>> findAll() {
        return new ResponseEntity<>(reservaService.findAll(),
                HttpStatus.OK);
    }

    @GetMapping("/findAll/page/{page}/size/{size}")
    public ResponseEntity<Page<Reservas>> findAll(
            @PathVariable int page,
            @PathVariable int size) {
        return new ResponseEntity<>(reservaService.findAll(page, size),
                HttpStatus.OK);
    }

    @GetMapping("/findByNomClienteContaining/name/{name}/page/{page}/size/{size}")
    public ResponseEntity<Page<Reservas>> findByNomClienteContaining(
            @PathVariable String name,
            @PathVariable int page,
            @PathVariable int size) {
        return new ResponseEntity<>(reservaService.findByNomClienteContaining(name, page, size),
                HttpStatus.OK);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Reservas> findById(@PathVariable Long id) {
        return new ResponseEntity<>(reservaService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/findByNomCliente/{nomCliente}")
    public ResponseEntity<Reservas> findByNomCliente(@PathVariable String nomCliente) {
        return new ResponseEntity<>(reservaService.findByNomCliente(nomCliente), HttpStatus.OK);
    }

    @GetMapping("/findByDate")
    public ResponseEntity<Reservas> findByDate(@RequestParam("fechaInicioReserva") String fechaInicioReserva) {
        try {
            Date fecha = new SimpleDateFormat("yyyy-MM-dd").parse(fechaInicioReserva);
            return new ResponseEntity<>(reservaService.findByDate(fecha), HttpStatus.OK);
        } catch (ParseException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<Reservas> add(@Valid @RequestBody Reservas reservas) {
        return new ResponseEntity<>(reservaService.add(reservas),
                HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Reservas> update(@PathVariable Long id,
            @RequestBody Reservas reservas) {
        return new ResponseEntity<>(reservaService.update(id, reservas),
                HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        reservaService.delete(id);
    }

}
