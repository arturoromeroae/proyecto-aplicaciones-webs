package cibertec.ecommerce.pe.ApiHoteles.controller;

import cibertec.ecommerce.pe.ApiHoteles.entity.Hotel;
import cibertec.ecommerce.pe.ApiHoteles.service.HotelService;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
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
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hotels")
@Validated
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @GetMapping("/findAll")
    public ResponseEntity<List<Hotel>> findAll() {
        List<Hotel> hotels = hotelService.findAll();
        return new ResponseEntity<>(hotels, HttpStatus.OK);
    }

    @GetMapping("/findAll/page/{page}/size/{size}")
    public ResponseEntity<Page<Hotel>> findAll(
            @PathVariable int page,
            @PathVariable int size) {
        return new ResponseEntity<>(hotelService.findAll(page, size),
                HttpStatus.OK);
    }

    @GetMapping("/findByNomHotelContaining/name/{name}/page/{page}/size/{size}")
    public ResponseEntity<Page<Hotel>> findByNomHotelContaining(
            @PathVariable String name,
            @PathVariable int page,
            @PathVariable int size) {
        return new ResponseEntity<>(hotelService.findByNomHotelContaining(name, page, size),
                HttpStatus.OK);
    }

    @GetMapping("/findByCiudad/{ciudad}")
    public ResponseEntity<Hotel> findByCiudad(@PathVariable String ciudad) {
        return new ResponseEntity<>(hotelService.findByCiudad(ciudad), HttpStatus.OK);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Hotel> findById(@PathVariable Long id) {
        return new ResponseEntity<>(hotelService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/findByEstrellas/{estrellas}")
    public ResponseEntity<Hotel> findByEstrellas(@PathVariable int estrellas) {
        return new ResponseEntity<>(hotelService.findByEstrellas(estrellas), HttpStatus.OK);
    }

    @GetMapping("/findByPais/{pais}")
    public ResponseEntity<Hotel> findByPais(@PathVariable String pais) {
        return new ResponseEntity<>(hotelService.findByPais(pais), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Hotel> add(@Valid @RequestBody Hotel hotel) {
        return new ResponseEntity<>(hotelService.add(hotel), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Hotel> update(@PathVariable Long id,
            @RequestBody Hotel hotel) {
        return new ResponseEntity<>(hotelService.update(id, hotel),
                HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        hotelService.delete(id);
    }

}
