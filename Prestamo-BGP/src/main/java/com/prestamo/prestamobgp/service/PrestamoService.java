package com.prestamo.prestamobgp.service;

import com.prestamo.prestamobgp.dtos.PrestamoCreateDTO;
import com.prestamo.prestamobgp.dtos.PrestamoDTO;
import com.prestamo.prestamobgp.dtos.PrestamoUpdateDTO;

import java.util.List;

public interface PrestamoService {

    List<PrestamoDTO> listarPrestamoPorIdCliente(long clienteId);
    PrestamoDTO obtenerPrestamoPorID(long id);
    PrestamoDTO registrarPrestamo(PrestamoCreateDTO prestamoCreateDTO);
    PrestamoDTO actualizarPrestamo(PrestamoUpdateDTO prestamoUpdateDTO);
    String eliminarPrestamo(long id);
}
