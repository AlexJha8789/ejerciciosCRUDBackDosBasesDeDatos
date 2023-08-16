package com.prestamo.prestamobgp.service;


import com.prestamo.prestamobgp.dtos.PrestamoCreateDTO;
import com.prestamo.prestamobgp.dtos.PrestamoDTO;
import com.prestamo.prestamobgp.dtos.PrestamoUpdateDTO;
import com.prestamo.prestamobgp.mappers.PrestamoMapper;
import com.prestamo.prestamobgp.model.Prestamo;
import com.prestamo.prestamobgp.repository.PrestamoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PrestamoServiceImpl implements PrestamoService{

    @Autowired
    private PrestamoRepository prestamoRepository;



    @Override
    public List<PrestamoDTO> listarPrestamoPorIdCliente(long clienteId) {
        return PrestamoMapper.instancia.listaPrestamoAListaPrestamoDTO(prestamoRepository.findAllByIdCliente(clienteId)) ;
    }

    @Override
    public PrestamoDTO obtenerPrestamoPorID(long id) {
        Optional<Prestamo> prestamoOptional = prestamoRepository.findById(id);
        PrestamoDTO prestamoDTO = null;
        if (prestamoOptional.isPresent()) {
            Prestamo prest = prestamoOptional.get();
            prestamoDTO = PrestamoMapper.instancia.prestamoAPrestamoDTO(prest);
        }
        return prestamoDTO;
    }

    @Override
    public PrestamoDTO registrarPrestamo(PrestamoCreateDTO prestamoCreateDTO) {
        Prestamo prestamo= PrestamoMapper.instancia.prestamoCreateDTOAPrestamo(prestamoCreateDTO);
        Prestamo respuestaEntity=prestamoRepository.save(prestamo);
        PrestamoDTO respuestaDTO= PrestamoMapper.instancia.prestamoAPrestamoDTO(respuestaEntity);
        return respuestaDTO;
    }

    @Override
    public PrestamoDTO actualizarPrestamo(PrestamoUpdateDTO prestamoUpdateDTO) {
        Prestamo prestamo= PrestamoMapper.instancia.prestamoUpdateDTOAPrestamo(prestamoUpdateDTO);
        Prestamo respuestaEntity=prestamoRepository.save(prestamo);
        PrestamoDTO respuestaDTO= PrestamoMapper.instancia.prestamoAPrestamoDTO(respuestaEntity);
        return respuestaDTO;
    }

    @Override
    public String eliminarPrestamo(long id) {
        boolean prestamoExistente = prestamoRepository.existsById(id);
        String resultado = "";
        if (prestamoExistente) {
            prestamoRepository.deleteById(id);
            resultado = "Registro Eliminado";
        } else {
            resultado = "No se pudo realizar la eliminación";
        }
        return resultado;
    }
}
