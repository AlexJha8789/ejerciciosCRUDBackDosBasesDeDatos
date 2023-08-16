package com.prestamo.prestamobgp.controller;


import com.prestamo.prestamobgp.dtos.PrestamoCreateDTO;
import com.prestamo.prestamobgp.dtos.PrestamoDTO;
import com.prestamo.prestamobgp.dtos.PrestamoUpdateDTO;
import com.prestamo.prestamobgp.service.PrestamoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PrestamoController {
    @Autowired
    private PrestamoService prestamoService;

    @GetMapping("/prestamos/clientes/{clienteId}")
    public ResponseEntity<List<PrestamoDTO>> listarPrestamoPorIdCliente(@PathVariable("clienteId")  long clienteId){
        return  new ResponseEntity<>( prestamoService.listarPrestamoPorIdCliente(clienteId) , HttpStatus.OK);
    }
    @GetMapping("/prestamos/{prestamoId}")
    public ResponseEntity<PrestamoDTO> obtenerPrestamoPorId(@PathVariable("prestamoId") long prestamoId){
        return  new ResponseEntity<> ( prestamoService.obtenerPrestamoPorID(prestamoId),HttpStatus.OK);
    }

    @PostMapping("prestamos")
    public ResponseEntity<PrestamoDTO> registrarPrestamo(@RequestBody PrestamoCreateDTO prestamoCreateDTO){
        return  new ResponseEntity <>( prestamoService.registrarPrestamo(prestamoCreateDTO) ,HttpStatus.OK);
    }

    @PutMapping("prestamos")
    public ResponseEntity<PrestamoDTO> actualizarPrestamo(@RequestBody PrestamoUpdateDTO prestamoUpdateDTO){
        return new ResponseEntity<>(prestamoService.actualizarPrestamo(prestamoUpdateDTO),HttpStatus.OK);
    }

    @DeleteMapping("/prestamos/{prestamoId}")
    public ResponseEntity<String> eliminarPrestamo(@PathVariable("prestamoId") long prestamoId) {
        return new ResponseEntity<>( prestamoService.eliminarPrestamo(prestamoId),HttpStatus.OK);
    }
}
