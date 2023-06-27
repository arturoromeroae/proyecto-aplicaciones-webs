package cibertec.ecommerce.pe.ApiHoteles.controller;

import cibertec.ecommerce.pe.ApiHoteles.entity.Room;
import cibertec.ecommerce.pe.ApiHoteles.service.RoomService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;

@RestController
@RequestMapping("/rooms")
@Validated
public class RoomController {

    @Autowired
    private RoomService roomService;

    @GetMapping("/findAll")
    public ResponseEntity<List<Room>> findAll() {
        List<Room> rooms = roomService.findAll();
        return new ResponseEntity<>(rooms, HttpStatus.OK);
    }

    @GetMapping("/findAll/page/{page}/size/{size}")
    public ResponseEntity<Page<Room>> findAll(
            @PathVariable int page,
            @PathVariable int size) {
        return new ResponseEntity<>(roomService.findAll(page, size),
                HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Room> add(@Valid @RequestBody Room room) {
        return new ResponseEntity<>(roomService.add(room), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Room> update(@PathVariable Long id,
            @RequestBody Room room) {
        return new ResponseEntity<>(roomService.update(id, room),
                HttpStatus.OK);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Room> findById(@PathVariable Long id) {
        return new ResponseEntity<>(roomService.findById(id),
                HttpStatus.OK);
    }

    @GetMapping("/findByTipo/{tipo}")
    public ResponseEntity<Room> findByRoomType(@PathVariable String tipo) {
        return new ResponseEntity<>(roomService.findByRoomType(tipo), HttpStatus.OK);
    }

}
